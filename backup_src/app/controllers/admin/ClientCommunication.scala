package controllers.admin

import scala.collection.mutable._

import play.api._
import play.api.mvc._

object ClientCommunication extends Controller {

	var percentages = Map[String, Int]()

	var messages = Map[String, Stack[AdminMessage]]()

	def getPercentage(name : String) = Action { implicit request =>
		val value = if(percentages.contains(name)) percentages(name) else 0
		Ok(value.toString).as(HTML)
	}

	def getMessage(name : String) = Action { implicit request =>
		if(messages.contains(name)) {
			val messagesToSend = messages(name).toList
			messages(name).clear()
			Ok(views.html.admin.snippets.message(messagesToSend))
		} else {
			Ok("").as(HTML)
		}
	}

	def increasePercentage(name: String, value : Int) = {
		percentages(name) = (percentages.getOrElseUpdate(name, 0)) + value
	}

	def setPercentage(name: String, value : Int) = {
		percentages(name) = value
	}

	def addMessage(name : String, message : AdminMessage) = {
		messages.getOrElseUpdate(name, new Stack[AdminMessage]()).push(message)
	}
} 
