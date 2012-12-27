package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.util.Date
import org.joda.time.format.ISODateTimeFormat
import java.io.File
import models._
import org.squeryl.PrimitiveTypeMode._
object Application extends Controller {
	
    // Global name for the application
    val name = "ColouR"
    
    val addConfForm = Form(
        tuple(
            "fullName" -> text,
            "shortName" -> text,
            "type" -> number,
            "field" -> number))
    
    val updateConferenceForm = Form(
        tuple(
            "id" -> number,
            "name" -> text,
            "shortName" -> text,
            "type" -> number,
            "region" -> number,
            "subFields" -> text,
            "startedOn" -> number,
            "publisher" -> text,
            "description" -> text))
    
    def index() = Action { implicit request =>
        Ok(views.html.index(Conference.count(), Search.searchForm))
    }
    
    def conference(id: Long) = Action { implicit request =>
        // Retrieve the conference
        val conference = Conference.getById(id)
        
        if (conference.isDefined) {
            val links = Link.getByConferenceId(id)
            val comments = Comment.getByConferenceId(id)
            val userVotes = UserVote.getUserVotesByConferenceId(id)
            val externalScores = ExternalScore.getByConferenceId(id)
            val subFields = Conference.getSubFields(id)
            val relatedConferences = ConferenceRelation.getConferencesRelatedTo(id)
            
            // Update the scores
            // Should not be necessary
            Conference.updateUserScoreForConference(id)
            Conference.updateExternalScoreForConference(id)
            
            var hasVoted = false
            if(request.session.get("userId").isDefined) {
                val userId = request.session.get("userId").get.toInt
                hasVoted = UserVote.hasVotedForConference(id, userId)
            }
            Ok(views.html.conference(conference.get, userVotes, externalScores, subFields, relatedConferences, hasVoted, links, comments))
        } else {
            Search.noResults(request)
        }
    }
    
    def conferenceByName(name: String) = Action { implicit request =>
        val conference = Conference.findByNameAndShortName(name)
        if(conference.size > 0) {
            Redirect(routes.Application.conference(conference(0).id))
        } else {
            Search.noResults(request)
        }
        
    }
    
    
    def editConference(id: Long) = Action { implicit request =>
        // Retrieve the conference
        val conference = Conference.getById(id)
        
        if (conference.isDefined) {
            val subFields = Conference.getSubFields(id)
            
            Ok(views.html.conferences.edit(conference.get, subFields))
        } else {
            Ok("Unable to find conference")
        }
    }
    
    def updateConference() = Action { implicit request =>
        updateConferenceForm.bindFromRequest.fold(
            errors => BadRequest("Unable to update"),
            params => {
                val id = params._1
                val name = params._2
                val shortName = params._3
                val cTypeId = params._4
                val regionId = params._5
                val subFields = params._6
                val yearSince = params._7
                val publisher = params._8
                val description = params._9
                
                val publisherId = models.Publisher.getOrCreate(publisher)
                
                Conference.update(id, name, shortName, cTypeId, regionId, yearSince, publisherId, description)
                
                /* Add and remove the subfields */
                val newSubfieldsIds = subFields.split(",").map(_.toInt)
                val curentSubfields = Conference.getSubFields(id).map(_.id)
                curentSubfields.foreach { subfield =>
                    if(! newSubfieldsIds.contains(subfield)) {
                        Conference.removeSubField(id, subfield)
                    }
                }
                newSubfieldsIds.foreach { subfield =>
                    if(! curentSubfields.contains(subfield)) {
                        Conference.addSubField(id, subfield)
                    }
                }
                
                Redirect(routes.Application.conference(id))
            }
        )
    }
    
    def addConf = Action { implicit request =>
        addConfForm.bindFromRequest.fold(
            errors => BadRequest("Unable to create"),
            params => {
                val newConferenceId = Conference.create(params._1, params._2, params._3, params._4)
                Redirect(routes.Application.conference(newConferenceId))
            }
        )
    }

    def test = Action { implicit request =>
        transaction {
		    AppDB.publishers.insert(new SPublisher("carramba"))
		    AppDB.printDdl(println(_))
		    
		    AppDB.fields.foreach { p =>
                println(p.name)
                p.subfields.foreach { subfield =>
                    println("   " + subfield.name)
                }
            }
        }
        
	    
	    /*
        val test = UpdateEntry(20972, 2, new Date())

        Update.getOrCreate(test)
        */
        Ok
    }
}

