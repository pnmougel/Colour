package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import controllers.AuthentificationActions._
import models._

object Publication extends Controller {
	val addPublicationForm = Form(
        tuple(
            "fullName" -> text,
            "shortName" -> text,
            "type" -> number,
            "field" -> number))
    
    val updatePublicationForm = Form(
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
    
    def publication(id: Long) = Authentification { implicit request =>
        // Retrieve the conference
        val conference = Conference.byId(id)
        
        if (conference.isDefined) {
            val userVotes = UserVote.getUserVotesByConferenceId(id)
            
            // Update the scores
            // Should not be necessary
            Conference.updateUserScoreForConference(id)
            Conference.updateExternalScoreForConference(id)
            
            val vote = UserVote.userVoteForConference(id, request.user)
            Ok(views.html.conference(conference.get, vote, request.user))
        } else {
            Search.noResults(request)
        }
    }
    
    def publicationByName(name: String) = Action { implicit request =>
        val conference = Conference.findPublications(name)
        if(conference.size > 0) {
            Redirect(routes.Publication.publication(conference(0)._1.id))
        } else {
            Search.noResults(request)
        }
    }
    
    
    def editPublication(id: Long) = Authentification { implicit request =>
        // Retrieve the conference
        val conference = Conference.byId(id)
        
        if (conference.isDefined && request.user.isDefined) {
            Ok(views.html.conferences.edit(conference.get))
        } else {
            Ok("Unable to find conference")
        }
    }
    
    def updatePublication() = Authentification { implicit request =>
        updatePublicationForm.bindFromRequest.fold(
            errors => BadRequest("Unable to update"),
            params => params match {
                case (id, name, shortName, ctypeId, regionId, subFields, yearSince, publisher, description) => {
                    if(request.user.isDefined) {
	                    val publisherId = if(publisher != "") Option(models.Publisher.getOrCreate(publisher)) else None
	                    val yearSinceOpt : Option[Int] = if(yearSince == 0) None else Option(yearSince)
	                    val descriptionOpt : Option[String] = if(description == "") None else Option(description)
		                
	                    /* Add and remove the subfields */
	                    var subfieldsToRemove = List[Long]()
	                    var subfieldsToAdd = List[Long]()
	                    
		                val newSubfieldsIds = if(subFields.isEmpty()) Array[Int]() else subFields.split(",").map(_.toInt)
		                val curentSubfields = Conference.getSubFields(id).map(_.id)
		                newSubfieldsIds.foreach { subfieldId =>
		                    if(! curentSubfields.contains(subfieldId)) {
		                        subfieldsToAdd = subfieldId :: subfieldsToAdd
		                    }
		                }
		                curentSubfields.foreach { subfieldId =>
		                    if(! newSubfieldsIds.contains(subfieldId)) {
		                        subfieldsToRemove = subfieldId :: subfieldsToRemove
		                    }
		                }
		                Conference.update(id, name, shortName, ctypeId, regionId, yearSinceOpt, publisherId, descriptionOpt, 
		                        subfieldsToAdd, subfieldsToRemove, request.user.get.id)
                    }
	                
	                Redirect(routes.Publication.publication(id))
                }
            }
        )
    }
    
    def getHistory(action: String, conferenceId : Long) = Action { implicit request =>
        val conference = Conference.byId(conferenceId)
        if(conference.isDefined) {
            if(action == "all") {
	            Ok(views.html.snippets.update.updates(conference.get.updatesAll))
	        } else {
	            Ok(views.html.snippets.update.updates(conference.get.updates))
	        }
        } else {
            Ok
        }
    }
    
    def addPublication = Authentification { implicit request =>
        addPublicationForm.bindFromRequest.fold(
            errors => BadRequest("Unable to create"),
            params => params match { case (fullName, shortName, ctype, field) =>
                if(request.user.isDefined) {
                    val newConferenceId = Conference.create(fullName, shortName, ctype, field, userIdOpt = Option(request.user.get.id))
                    Redirect(routes.Publication.publication(newConferenceId))
                } else {
                    Ok
                }
            }
        )
    }

}