package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Conference
import models.Publisher
import models.Link

object Widgets extends Controller {
	
    def getBadge(conferenceId : Long, size : Int = 12) = Action { implicit request =>
        val conference = Conference.getById(conferenceId)
        if(conference.isDefined) {
            Ok(views.html.snippets.widget(conference.get.avgScore))
        } else {
            Ok(views.html.snippets.widget(None))
        }
    }

    def getBadgeByName(name : String, size : Int = 12) = Action { implicit request =>
        val conference = Conference.findByShortName(name)
        if(conference.size == 1) {
            Ok(views.html.snippets.widget(conference(0).avgScore))
        } else {
            Ok(views.html.snippets.widget(None))
        }
    }
}