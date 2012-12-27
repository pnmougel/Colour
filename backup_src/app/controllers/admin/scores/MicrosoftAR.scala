package controllers.admin.scores

import java.util.Date
import scala.collection.JavaConversions._
import scala.collection.mutable._
import org.jsoup.nodes.Document
import controllers.admin._
import controllers.admin.action._
import models._
import models.Conference
import play.api._
import play.api.data.Forms._
import play.api.mvc._
import controllers.admin.utils.Timer


object MicrosoftAR extends AdminAction {
	val description = "This action gather information from Microsoft Academic Research."
    
    val name = "microsoftAR"
    
    val label = "Microsoft Academic Research"

    override val category = "External Ranking"
    override val icon = "star-empty"

    val MicrosoftARJournalId = 4
    val MicrosoftARConferenceId = 3

    var curFieldId : Long = 0
    var curSubFieldId : Long = 0
    var conferenceToHindex = new Stack[(Long, Int)]()
    
    var nbCreated = 0
    
    val rankingId = ExternalRanking.getOrCreate("http://academic.research.microsoft.com/", "Microsoft AR", 
        "Ranking based on the hindex using the citations found by the Microsoft web search engine Bing", 
        ScoreType.getOrCreate(ScoreTypeEntry("Microsoft hindex", "Microsoft hindex")))
    
    override def run(request : Request[AnyContent]) = {
	    
        infoMessage("Adding journals...")
        getByEntity(MicrosoftARJournalId)

        infoMessage("Adding conferences...")
        getByEntity(MicrosoftARConferenceId)
        
        // Update the ranks from the hindex
        infoMessage("Updating ranks...")
        val conferenceRanks = Utils.getConferenceRankFromScore(conferenceToHindex)
        conferenceRanks.foreach { case ((conferenceId, scoreValue), rank) =>
            ExternalScore.createOrUpdate(conferenceId, rankingId, scoreValue, "" + scoreValue, rank)
        }

        successMessage("Finished :)")
    }

    def getDoc(fileName : String, url : String) : Document = {
        Utils.getDocument("microsoft_AR", fileName, url).get
    }
    
    def getTopDomains(entityTypeId : Int) : HashMap[Int, String] = {
        val fileName = "subDomain_" + entityTypeId
        val doc = getDoc(fileName, "http://academic.research.microsoft.com/RankList?entitytype=" + entityTypeId + 
	                "&topdomainid=2&subdomainid=0&last=0")
        
        val topDomains = doc.select("div.option")
        var map = new HashMap[Int, String]()
        topDomains.foreach { topDomain =>
            map(topDomain.select("input").first().attr("value").toInt) = topDomain.select("span").first().text()
        }
        map
    }
    
    def getNbObjectByType(entityTypeId : Int) : Int = {
        var nbObjects = 0
        getTopDomains(entityTypeId).foreach { field =>
            val topDomain = field._1
            val fileName = "subDomain_" + entityTypeId + "_topDomain" + topDomain
	        val doc = getDoc(fileName, "http://academic.research.microsoft.com/RankList?entitytype=" + entityTypeId + 
		                "&topdomainid=" + topDomain + "&subdomainid=0&last=0")
		    val element = doc.getElementById("ctl00_MainContent_SearchSummary_lblResultMessage")
		    if(element != null) {
		        val elementText = element.text().split(" of ")
			    if(elementText.size == 2) {
			        nbObjects += elementText(1).split(" ")(0).replaceAll(",", "").toInt
			    }
		    }
        }
        nbObjects
    }
    
    def getSubDomains(entityTypeId : Int, topDomain : Int) : HashMap[Int, String] = {
        val fileName = "subDomain_" + entityTypeId + "_topDomain" + topDomain
        val doc = getDoc(fileName, "http://academic.research.microsoft.com/RankList?entitytype=" + entityTypeId + 
	                "&topdomainid=" + topDomain + "&subdomainid=0&last=0")
	    var found = false
	    var map = new HashMap[Int, String]()
	    doc.toString().split("\n").foreach { line =>
            if(line.contains("options[") && line.contains("] = {")) {
                if(!found) {
                    found = true
	                line.split(";").foreach { elem => 
	                    val subFieldName = elem.split("\"")(3)
	                    val subFieldId = elem.split("\"")(7)
	                    
	                    // Handle special cases
	                    if(subFieldName == "Last 5 Years") {
	                        map(0) = "Multidisciplinary"
	                    } else {
	                        if(subFieldId != "0") {
		                    	map(subFieldId.toInt) = subFieldName
		                    }
	                    }
	                }
                }
            }
        }
        map
    }
    
    def getItems(entityTypeId : Int, topDomain : Int, subDomain : Int) : Unit = {
        val fileName = "items_type" + entityTypeId + "_topDomain" +  topDomain + "_subDomain" + subDomain
        val doc = getDoc(fileName, "http://academic.research.microsoft.com/RankList?entitytype=" + entityTypeId + 
	                "&topdomainid=" + topDomain + "&subdomainid=" + subDomain + "&last=0")
        val results = doc.select("span.result").text()
        if(results.split(" ").size < 5) {
            return
        }
        val nbResults = results.replaceAll(",", "").split(" ")(4).toInt
        
        var startPage = 1
        var resultCount = 0
        while(startPage < nbResults + 1) {
            val page = getItemsByPage(entityTypeId, topDomain, subDomain, startPage)
            resultCount += page.size
            startPage += 100
        }
        
        if(resultCount != nbResults) {
            warningMessage("Found " + resultCount + " while " + nbResults + " where expected")
            warningMessage("http://academic.research.microsoft.com/RankList?entitytype=" + entityTypeId + 
	                "&topdomainid=" + topDomain + "&subdomainid=" + subDomain + "&last=0")
        }
    }
    
    def getItemsByPage(entityTypeId : Int, topDomain : Int, subDomain : Int, startPage : Int) : 
    	List[(String, String, String, String)] = {

        val entityTypeName = if(entityTypeId == MicrosoftARJournalId) "Journal" else "Conference"
        val fileName = "itemsPage_type" + entityTypeId + "_topDomain" +  topDomain + "_subDomain" + subDomain + "_start" + startPage
        val doc = getDoc(fileName, "http://academic.research.microsoft.com/RankList?entitytype=" + entityTypeId + 
	                "&topdomainid=" + topDomain + "&subdomainid=" + subDomain + "&last=0&start=" + 
	                startPage + "&end=" + (startPage + 99))
	    doc.select("tr").map { tr =>
	        objectCounter += 1
	        setPercentage((objectCounter * 100) / nbObjectsTotal)
	        
            val url = "http://academic.research.microsoft.com" + tr.select("td.rank-content").select("a").attr("href")
            val name = tr.select("td.rank-content").select("a").text()
            val (shortName, fullName) = {
            	if(name.split(" - ").size != 2) {
            	    (("", name))
            	} else {
            	    ((name.split(" - ")(0), name.split(" - ")(1)))
            	}
            }
            val data = tr.select("td.staticOrderCol").text().split(" ")
            val (nbPublications, hIndex) = {
                if(data.size == 2) {
                    (data(0), data(1))
                } else {
                    ("-1", "-1")
                }
            }
            if(data.size == 2) {
                val ctype : Long = {
                    if(entityTypeId == MicrosoftARConferenceId) {
                        CType.getOrCreate("Conference")
	                } else {
	                    CType.getOrCreate("Journal")
	                }
                }
                
                createConference(fullName, shortName, cType, curFieldId, curSubFieldId, nbPublications.toInt, hIndex.toInt, url)
            }
            ((name, url, nbPublications, hIndex))
        }.filter( a => a._1 != "").toList
    }
    
    var objectCounter = 0
    var nbObjectsTotal = 0
    
    def getByEntity(entityTypeId: Int) = {
        val entityTypeName = if(entityTypeId == MicrosoftARJournalId) "Journal" else "Conference"
        setPercentage(0)
        
        // Build percentage
        objectCounter = 0
        nbObjectsTotal = getNbObjectByType(entityTypeId)
        
        getTopDomains(entityTypeId).foreach { field =>
            
            // Add field into the table
            val fieldId = field._1
            val fieldName = FieldMapping.fieldMapping(field._2)
            
            curFieldId = models.Field.getOrCreate(fieldName)

            val map = getSubDomains(entityTypeId, field._1)
            map.foreach { subField =>
                // Add sub field into the table
            	val subFieldId = subField._1
            	val subFieldName = subField._2
            	
            	curSubFieldId = SubField.getOrCreate(subFieldName, curFieldId)
            	getItems(entityTypeId, fieldId, subFieldId)
            	
            }

            infoMessage(nbCreated + " " + entityTypeName + " added in the field " + fieldName)
            nbCreated = 0
        }
    }


    def createConference(fullName : String, shortName : String, cType : Long, fieldId : Long, subFieldId : Long,
        nbPublications : Int, hIndex : Int, url : String) {
        
        val matchingConference = Utils.findMatchingConference(fullName, Option(shortName), Option(fieldId))
        val conferenceId = if(matchingConference.isDefined) {
            matchingConference.get.id
        } else {
        	nbCreated += 1
            Conference.create(fullName, shortName, cType, fieldId)
        }
        Conference.updateHindexNbArticles(conferenceId, hIndex, nbPublications)
        Conference.addSubField(conferenceId, subFieldId)
        Link.create(conferenceId, url, "Microsoft AR", new Date())
        conferenceToHindex.push((conferenceId, hIndex))
    }
}