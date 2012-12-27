package controllers

import play.api._
import play.api.data.Forms._
import play.api.mvc._
import controllers.AuthentificationActions._
import play.api.data.Form
import java.util.Date
import models.Idea
import views.html.defaultpages.unauthorized

object IdeaBox extends Controller {
    val addIdeaForm = Form(
        tuple(
            "name" -> text,
            "description" -> text))

    def index = Authentification { implicit request =>
        Ok(views.html.ideabox(Idea.byNbVotes, request.user))
    }

    def addIdea = Authentification { implicit request =>
        addIdeaForm.bindFromRequest.fold(
            errors => BadRequest("How did you manage that ?"),
            params => params match {
                case (name, description) =>
                    if (request.user.isDefined) {
                        models.Idea.create(name, description, new Date(), request.user.get.id)
                        Ok(views.html.ideabox(Idea.byDate, request.user))
                    } else {
                        Ok(views.html.ideabox(Idea.byDate, request.user))
                    }
            })
    }

    def vote(ideaId: Long) = Authentification { implicit request =>
        if (request.user.isDefined) {
            models.IdeaVote.create(ideaId, request.user.get.id)
            Ok
        } else {
            BadRequest
        }
    }
}