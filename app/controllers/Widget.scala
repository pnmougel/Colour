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
        val conference = Conference.byId(conferenceId)
        if(conference.isDefined) {
            Ok(views.html.snippets.widget(conference.get.avgScore))
        } else {
            Ok(views.html.snippets.widget(None))
        }
    }
    
    def getHindex(conferenceId : Long) = Action { implicit request =>
        val conference = Conference.byId(conferenceId)
        if(conference.isDefined) {
            Ok("")
        } else {
            Ok("")
        }
    }
}