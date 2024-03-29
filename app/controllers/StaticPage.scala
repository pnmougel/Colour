package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Conference
import models.Publisher
import models.Link

object StaticPage extends Controller {
    def widget() = Action { implicit request =>
        Ok(views.html.staticpages.widget(request))
    }
}