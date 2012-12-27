package controllers.conference

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Conference
import models.Publisher
import models.Link
import java.util.Date
import org.joda.time.format.ISODateTimeFormat
import controllers.AuthentificationActions._

object Links extends Controller {
    val addLinkForm = Form(
        tuple(
            "url" -> text,
            "conference_id" -> number,
            "label" -> text))
    
    def addLink = Authentification { implicit request => 
        addLinkForm.bindFromRequest.fold(
            errors => BadRequest(""),
            params => params match { case (url, conferenceId, label) =>
                if(request.user.isDefined) {
                    val newLink = Link.byId(Link.create(conferenceId, url, label, new Date(), request.user.get.id))
                    Ok(views.html.snippets.link(newLink.get))
                } else {
                    Ok
                }
            }
        )
    }
    
    def deleteLink(id: Long) = Authentification { implicit request =>
        if(request.user.isDefined) {
            // Check that the link correspond to the user
            val curUser = request.user.get
            if(curUser.isAdmin || {
                val curLink = Link.byId(id)
                curLink.isDefined && curLink.get.userId == curUser.id
            }) {
                Link.delete(id)
            }
        }
        Ok
    }
    
}

