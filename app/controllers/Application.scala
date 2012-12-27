package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.util.Date
import org.joda.time.format.ISODateTimeFormat
import java.io.File
import models._
import models.renorm._
import com.cybozu.labs.langdetect.DetectorFactory
import com.cybozu.labs.langdetect.Detector
import java.util.HashMap
import collection.JavaConversions._

object Application extends Controller {
	
    // Global name for the application
    val name = "ColouR"
    
    
    def index() = Action { implicit request =>
        Ok(views.html.index(Conference.count()))
    }
    
    def test = Action { implicit request =>
        val confList = List((1, 2), (2, 4), (3, 3))
        println(confList.sortWith(_._2 > _._2))
        
        // DetectorFactory.loadProfile("cache/profiles/")
        // val detector = DetectorFactory.create()
        // detector.append("Kanagawa-Ken Seishin Igakkaishi")
        
        /*
        println(models.Field.countWhere('name -> "Music"))
        models.Field.all(OrderBy("name") :: Limit(4)).foreach { field =>
            println(field)
            field.subfields.foreach { subfield =>
                println("   " + subfield.name + " / " + subfield.field.name)
            }
        }
        detector.getProbabilities().foreach { p =>
            println(p.lang + ": " + p.prob)
        }
         */
    	// Ok(detector.detect())
        Ok("")
    }
}

