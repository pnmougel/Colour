package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Conference
import models.Publisher
import models.Link
import scala.collection.mutable.Stack

object Ranking extends Controller {
    
    val nbConferencesPerPage = 10
    
    val paginateConferences = Form(
        tuple(
            "pageNum" -> number,
            "field" -> number,
            "nat" -> number,
            "intl" -> number,
            "conference" -> number,
            "journal" -> number,
            "workshop" -> number,
            "subfields" -> text,
            "orderBy" -> text,
            "sort" -> text,
            "nameFilter" -> text))
            
    def byField(fieldId : Long) = Action { implicit request =>
        val conferences = Conference.findByField(fieldId)
        val subFields = models.SubField.getByField(fieldId)
        val ctypes = getCTypes(true, true, true)
        
        val nbResults = Conference.countPages(fieldId, ctypes, subFields.map(_.id))
        Ok(views.html.ranking(fieldId, conferences.zipWithIndex, subFields, 1, ((nbResults - 1) / nbConferencesPerPage) + 1, ""))
    }
    
    def page() = Action { implicit request =>
        paginateConferences.bindFromRequest.fold(
            errors => {
                BadRequest("Unable to get the page")
            },
            params => params match {
            case (pageNum, fieldId, national, international, conference, journal, workshop, subfields, orderByParam, sort, nameFilter) =>
                val subFieldsList = subfields.split(",")
                val selectedSubFields : List[Long] = if(subfields.size > 0) {
                	subFieldsList.map(_.split("_")(1).toLong).toList
                } else {
                    List[Long]()
                }
                val ctypes = getCTypes(conference == 1, journal == 1, workshop == 1)
                
                val orderBy = orderByParam match {
                    case "user" => "user_score"
                    case "ext" => "external_score"
                    case "avg" => "avg_score"
                    case _ => "user_score"
                }
                
                val nbResults = Conference.countPages(fieldId, ctypes, selectedSubFields)
                if(!nameFilter.trim().isEmpty()) {
                    // Perform manual pagination
                    // Great :(
                    val lowerCaseFilter = nameFilter.toLowerCase()
                    val conferenceList = Conference.getPage(fieldId, ctypes, selectedSubFields, None, None, orderBy, sort).zipWithIndex.filter { case (conference, idx) =>
                        conference.name.toLowerCase().contains(lowerCaseFilter) || conference.shortName.toLowerCase().contains(lowerCaseFilter)
                    }
                    val nbItems = conferenceList.size
                    val nbPages = scala.math.max(1, scala.math.floor((nbItems  + nbConferencesPerPage - 1) / nbConferencesPerPage)).toInt
                    val startAt = if(pageNum > nbPages) 0 else (pageNum - 1) * nbConferencesPerPage
                    
                    val conferencesInPage = conferenceList.slice(startAt, startAt + nbConferencesPerPage)
                    Ok(views.html.rankingConferences(conferencesInPage, startAt + 1, pageNum, nbPages, nameFilter))
                } else {
                    val nbPages = scala.math.max(1, scala.math.floor((nbResults  + nbConferencesPerPage - 1) / nbConferencesPerPage)).toInt
                    val startAt = if(pageNum > nbPages) 0 else (pageNum - 1) * nbConferencesPerPage
                    val conferenceList = Conference.getPage(fieldId, ctypes, selectedSubFields, Option(nbConferencesPerPage), Option(startAt), orderBy, sort).zipWithIndex
                    Ok(views.html.rankingConferences(conferenceList, startAt + 1, pageNum, nbPages, nameFilter))
                }
                
            }
        )
    }
    
    def getCTypes(isConference : Boolean, isJournal : Boolean, isWorkshop : Boolean) : List[Long] = {
        var ctypes = new Stack[Long]()
        if(isConference) ctypes.push(models.CType.conferenceType)
        if(isJournal) ctypes.push(models.CType.journalType)
        if(isWorkshop) ctypes.push(models.CType.workshopType)
        ctypes.toList
    }
}