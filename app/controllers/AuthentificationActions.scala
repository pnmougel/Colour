package controllers

import play.api._
import play.api.mvc._
import scala.collection.mutable.HashMap
import akka.actor.Cancellable
import play.libs.Akka
import akka.util.Duration
import java.util.concurrent.TimeUnit

case class RequestWithUser(user: Option[models.User], request: Request[AnyContent]) extends WrappedRequest(request)

object AuthentificationActions {
    var userCache = new HashMap[String, Cancellable]()

    val sessionDuration = Duration.create(1, TimeUnit.HOURS)

    def Authentification(f: RequestWithUser => Result) = {
        Action { request =>
            val sessionKeyUser = request.session.get("userKey")
            val user = if (sessionKeyUser.isDefined) {
                // Update last activity
                val userKey = sessionKeyUser.get
                models.User.getByKey(userKey)
            } else {
                None
            }
            f(RequestWithUser(user, request))
        }
    }
}

