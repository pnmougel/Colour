package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Conference
import models.Publisher
import models.Link
import org.apache.commons.lang3.RandomStringUtils
import play.libs.Akka
import akka.util.Duration
import java.util.concurrent.TimeUnit

/**
 * In order to increase security against session corruption, we should keep a session in the server with the logged users.
 * This session should expire after one hour of inactivity.
 * If a user use a session key which is not in the cache, ask him to re log
 */

object User extends Controller {
    val userForm = Form(tuple("email" -> text, "password" -> text))

    def login = Action { implicit request =>
        userForm.bindFromRequest.fold(
            errors => BadRequest("Unable to login, check that you typed a valid email address"),
            params => params match { case (email, password) =>
                val loggedUser = models.User.authenticate(email, password)
                if (loggedUser.isDefined) {
                    val userKey = loggedUser.get.key
                    AuthentificationActions.userCache(userKey) = Akka.system.scheduler.scheduleOnce(AuthentificationActions.sessionDuration) {
	                    AuthentificationActions.userCache.remove(userKey)
                 	}
                    Ok("You successfully logged in").withSession("userKey" -> loggedUser.get.key)
                } else {
                    BadRequest("""Unable to login, check that the mail and password are correct. If you lost your password click <a href="/user/lostPasword">here</a>""")
                }
            }
        )
    }

    def logout = Action { implicit request =>
        Ok("You logged out").withNewSession
    }

    def add = Action { implicit request =>
        userForm.bindFromRequest.fold(
            errors => BadRequest("Unable to create an account, check that you typed a valid email address"),
            user => {
                user match {
                    case (email, password) => {
                        // Create a new user if not existing
                        if (!models.User.findByEmail(email).isDefined && !models.User.authenticate(email, password).isDefined) {
                            val pseudo = user._1.split("@")(0)
                            models.User.create(email, password, pseudo)
                            val loggedUser = models.User.authenticate(email, password)
                            Ok("Account succesfully created").withSession("userKey" -> loggedUser.get.key)
                        } else {
                            BadRequest("Sorry, a user is already registered with this email address")
                        }
                    }
                }
            })
    }
    
    def resetPasswordRequest(mailAddress : String) = Action { implicit request =>
        // A new password has been generated and send to your mail address. Click on the link in the message to update your password. You will then be able to access your account using this new password. If you want to change it, go to your profile page once connected.
        val newPassword = RandomStringUtils.randomAlphanumeric(16)
        
        val user = models.User.findByEmail(mailAddress)
        if(user.isDefined) {
            val newKey = models.User.hash(user.get.email.toLowerCase() + newPassword)
            
            // Add an entry into a resetpassord table
            // get a unique key identifying the password reset query
            
            // Mail object : [colour-ranking.org] Password reset request
        /* A password reset request has been performed using your email account on http://colour-ranking.org
         * 
         * The following password has been generated: newPassword
         * In order to ensure that you are at the origin of the request, to update your password click on the following link:
         * 
         * http://colour.org/resetpassword?mail=yourmail&key=newKey&request=requestKey
         * 
         * This link will be valid during one week.
         * 
         * You will then be able to connect to your account using this email address and the generated password. 
         * We advise you to change it by going to your profile page once connected.
         * 
         * If you are not at the origin of this request, please accept our apologies and delete this message.
         * 
         * Regards,
         */
        }
        Ok
    }
    
    def updateResetedPassword(mailAddress : String, key : String, requestKey : String) = Action { implicit request =>
        
        Ok
    }
}