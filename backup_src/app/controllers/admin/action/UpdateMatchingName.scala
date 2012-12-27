package controllers.admin.action

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import controllers.admin._
import models._

object UpdateMatchingName extends AdminAction {
    val description = "This action update the name used for matching"
    
    val name = "matchingName"
    
    val label = "Update Matching Name"

    override def run(request : Request[AnyContent]) = {
        val conferences = Conference.all
        infoMessage("Conferences loaded")
        val nbConferences = conferences.size
        var i = 1
    	conferences.foreach { conf =>
    	    setPercentage(i * 100 / nbConferences)
    	    i += 1
    	    val cleanedName = Utils.cleanName(conf.name)
    	    // println(conf.name + " => " + cleanedName)
    	    Conference.updateMatchingName(conf.id, cleanedName)
    	}
    	successMessage("Done")
    }
}