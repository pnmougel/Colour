package controllers.admin.scores

import scala.collection.JavaConversions._
import org.jsoup.nodes.Document
import models.Conference
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api._
import scala.collection.mutable.ListBuffer
import models._
import controllers.admin._
import controllers.admin.action._

object CiteSeer extends AdminAction  {
	val description = "This action gather the rankings from CiteSeer."
    
    val name = "citeseer"
    
    val label = "CiteSeer"

    override val category = "External Ranking"
    override val icon = "star-empty"

    val rankingId = ExternalRanking.getOrCreate("http://citeseerx.ist.psu.edu/stats/venues", 
        "CiteSeer", 
        "Description CiteSeer",
        ScoreType.getOrCreate(ScoreTypeEntry("hIndex citeseer", "hIndex citeseer")))
    
    def setScore(conferenceId : Long, score : Int) = {
        /*
        if(!ExternalScore.getRankingForConference(conferenceId, rankingId).isDefined) {
            ExternalScore.createOrUpdate(conferenceId, rankingId, score, "toto", 45)
        }
        */
    }
    
    override def run(request : Request[AnyContent]) = {
        ExternalScore.deleteByExternalRanking(rankingId)
        // var matches = new ListBuffer[ConferenceMatch]
        
        var nbRow = 0
        
        var nbMatchingOne = 0
        var nbNotMatching = 0
        
        val docOpt = Utils.getDocument("citeseer", "citeseer", "http://citeseerx.ist.psu.edu/stats/venues")
        if(docOpt.isDefined) {
            val doc = docOpt.get
            val rows = doc.select("ol")
	        rows.foreach { row =>
	            val lis = row.select("li")
	            lis.foreach { li =>
	                val confDblpUrl = li.select("a").attr("href")
	                val confName = li.select("a").text.replace("/", "_")
	                val dblpPageOpt = Utils.getDocument("citeseer/dblp/", confName, confDblpUrl)
	                if(dblpPageOpt.isDefined) {
	                    val (nameFull, pContent) = Utils.getParenthesisContent(dblpPageOpt.get.select("h1").text)
                		val shortName = if(pContent.size == 1) {
                		    Option(pContent(0))
                		} else {
                		    None
                		}
	                    
		                // val confName = li.select("a").text
	                    val matchingConference = Utils.findMatchingConference(nameFull, shortName)
		                if(matchingConference.isDefined) {
		                    nbMatchingOne += 1
		                } else {
		                	println(nameFull + " (" + shortName.getOrElse("") + ")")
		                    nbNotMatching += 1
		                }
		                // val score = li.select("em").text
	                }
	            }
	        }
        }
        
        println("Nb matching one " + nbMatchingOne)
        println("Nb matching none " + nbNotMatching)
    }
    /*
    val confMatchingForm = Form (
        tuple("score" -> list(text), 
                "shortName" -> list(text), 
                "longName" -> list(text),
                "matchingId" -> list(number))
        
    )
    
    def update() = Action { implicit request =>
        confMatchingForm.bindFromRequest.fold(
            errors => {
                println("Argh")
                BadRequest("Unable to create")
            },
            params => {
                
                val scores = params._1
                val shortNames = params._2
                val longNames = params._3
                val matchingIds = params._4
                
                println(scores.size)
                
                var idx = 0
                while(idx < scores.size) {
	                val score = scores(idx) match {
	                    case "A*" => 4
	                    case "A" => 3
	                    case "B" => 2
	                    case "C" => 1
	                    case _ => -1
	                }
                    
	                val conferenceId = {
	                    if(matchingIds(idx) == -1) {
	                        Conference.create(longNames(idx), shortNames(idx), 1, 261)
	                    } else {
	                        matchingIds(idx)
	                    }
	                }
	                
	                setScore(conferenceId, score)
                    idx += 1
                }
                Ok
            }
        )
    }
    */
    
}