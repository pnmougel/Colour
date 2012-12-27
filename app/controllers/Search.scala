package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Conference
import models.Publisher
import models.Link
import play.api.libs.json.Json

object Search extends Controller {
    val searchForm = Form(tuple(
            "query" -> text,
            "shortName" -> text,
            "type" -> number,
            "field" -> number))
    val simpleQuery = Form("query" -> text)
    
    def search = Action { implicit request =>
        searchForm.bindFromRequest.fold(
            errors => BadRequest("How did you manage that ?"),
            query => query match { case (name, shortName, ctypeId, fieldId) =>
                val shortNameOpt = if(shortName.isEmpty) None else Option(shortName)
                val ctypeIdOpt : Option[Long] = if(ctypeId == -1) None else Option(ctypeId)
                val fieldIdOpt : Option[Long] = if(fieldId == -1) None else Option(fieldId)
                
                val conferences = Conference.findPublications(name, shortNameOpt, ctypeIdOpt, fieldIdOpt)
                val nbResults = if(conferences.size == 200) {
                    Conference.countPublications(name, shortNameOpt, ctypeIdOpt, fieldIdOpt)
                } else {
                    conferences.size
                }
		        if(nbResults == 1) {
		            // Only one conference is matching
		            Redirect(routes.Publication.publication(conferences(0)._1.id))
		        } else {
		            // Display the list of all matching conferences
		            val matchingExactly = conferences.filter { case (conference, scoreMatching) => 
		                conference.name.equalsIgnoreCase(name) ||
		                conference.shortName.equalsIgnoreCase(name) 
	                }
		            if(matchingExactly.size == 1) {
		                Redirect(routes.Publication.publication(matchingExactly(0)._1.id))
		            } else {
		                Ok(views.html.results(name, conferences, nbResults))
		            }
		        }
            }
        )
    }
    
    def json = Action { implicit request =>
        simpleQuery.bindFromRequest.fold(
            errors => BadRequest("How did you manage that ?"),
            query => {
                val lowerCaseQuery = query.toLowerCase()
            	val matchingConferences = Conference.getQuickMatch("%" + lowerCaseQuery + "%").map(c => if(c.shortName != "") c.shortName else c.name)
            	if(matchingConferences.size == 1 && matchingConferences(0) != lowerCaseQuery) {
            		Ok("")
            	} else {
            		Ok(Json.toJson(Map("options" -> matchingConferences)))
            	}
            }
        )
        
        
    }
    
    def noResults = Action { implicit request =>
        Ok(views.html.results("", List(), 0L))
    }
}