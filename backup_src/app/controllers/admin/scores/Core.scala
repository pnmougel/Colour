package controllers.admin.scores

import java.io.File

import scala.collection.immutable.HashMap
import scala.io.Source.fromFile

import controllers.admin.FieldMapping
import controllers.admin.action.AdminAction
import models.CType
import models.Conference
import models.ExternalRanking
import models.ExternalScore
import models.Field
import models.ScoreType
import models.ScoreTypeEntry
import models.SubField
import play.api.mvc.AnyContent
import play.api.mvc.Request

object Core extends AdminAction  {
	val description = "This action gather the rankings from Core."
    
    val name = "core"
    
    val label = "Core"

    override val category = "External Ranking"
    override val icon = "star-empty"

    
	val fieldMatching = HashMap(
	        "01" -> Field.getOrCreate(FieldMapping.mathematics),
	        "02" -> Field.getOrCreate(FieldMapping.physics),
	        "03" -> Field.getOrCreate(FieldMapping.chemistry),
	        "04" -> Field.getOrCreate(FieldMapping.earthSciences),
	        "05" -> Field.getOrCreate(FieldMapping.environmentalSciences),
	        "06" -> Field.getOrCreate(FieldMapping.earthSciences),
	        "07" -> Field.getOrCreate(FieldMapping.agricultureAndVeterinary),
	        "08" -> Field.getOrCreate(FieldMapping.computerScience),
	        "09" -> Field.getOrCreate(FieldMapping.engineering),
	        "10" -> Field.getOrCreate(FieldMapping.technology),
	        "11" -> Field.getOrCreate(FieldMapping.medecineAndHealth),
	        "12" -> Field.getOrCreate(FieldMapping.architecture),
	        "13" -> Field.getOrCreate(FieldMapping.education),
	        "14" -> Field.getOrCreate(FieldMapping.economicsAndBusiness),
	        "15" -> Field.getOrCreate(FieldMapping.commerceAndManagement),
	        "16" -> Field.getOrCreate(FieldMapping.humanities),
	        "17" -> Field.getOrCreate(FieldMapping.psychology),
	        "18" -> Field.getOrCreate(FieldMapping.legalStudies),
	        "19" -> Field.getOrCreate(FieldMapping.artsAndHumanities),
	        "20" -> Field.getOrCreate(FieldMapping.languageAndCulture),
	        "21" -> Field.getOrCreate(FieldMapping.historyAndArchaeology),
	        "22" -> Field.getOrCreate(FieldMapping.philosophyAndReligions),
            "MD" -> Field.getOrCreate(FieldMapping.multidisciplinary))
	
    def getField(forCode : String) : Long = {
	    fieldMatching(forCode.substring(0, 2))
	}
	        
    override def run(request : Request[AnyContent]) = {
        val rankingDescription = """Ranking made by Computing Research and Education Association of Australasia, an association of 
	    university departments of computer science in Australia and New Zealand"""
	    val coreRankingId = ExternalRanking.getOrCreate("http://core.edu.au/", "Core", rankingDescription, 
	            ScoreType.getOrCreate(ScoreTypeEntry("A*ABC", "A*ABC")))
        
        infoMessage("Inserting Core Ranking...")
        ExternalScore.deleteByExternalRanking(coreRankingId)
        infoMessage("Remove previous core ranking...")
        
        // Conferences
        infoMessage("Adding conferences...")
        val conferenceType = CType.getOrCreate("Conference")
        val conferenceFile = new File("cache/core/core_2010_conference.csv")
        val nbLines = fromFile(conferenceFile).getLines.size
        fromFile(conferenceFile).getLines().zipWithIndex foreach { case (line, idx) =>
        	setPercentage(((idx + 1) * 100 / nbLines).toInt)
            val elems = line.split("\\|")
            if(elems.size >= 6 && idx != 0) {
                val name = elems(1)
                val shortName = elems(2)
	            val scoreText = elems(3)
	            val fieldId = getField(elems(4))
	            val confId = Conference.create(name, shortName, conferenceType, fieldId)
	            
	            val scoreValue = scoreText match  {
                    case "A" => 5
                    case "B" => 4
                    case "C" => 3
                    case _ => -1
                }
                
	            ExternalScore.createOrUpdate(confId, coreRankingId, scoreValue, scoreText, scoreValue)
	            
	            if(elems(4).size == 4) {
	            	val subfieldId = SubField.getOrCreate(elems(5), fieldId)
	            	Conference.addSubField(confId, subfieldId)
	            }
                if(elems.size >= 8 && !elems(6).isEmpty()) {
                    if(getField(elems(6)) == fieldId && elems(6).size == 4) {
                        val subfieldId = SubField.getOrCreate(elems(7), fieldId)
                		Conference.addSubField(confId, subfieldId)
                    }
                }
                if(elems.size >= 10 && !elems(8).isEmpty()) {
                    if(getField(elems(8)) == fieldId && elems(8).size == 4) {
                        val subfieldId = SubField.getOrCreate(elems(9), fieldId)
                		Conference.addSubField(confId, subfieldId)
                    }
                }
            }
        }
        
        // Journals
        infoMessage("Adding journals...")
        
        val journalType = CType.getOrCreate("Journal")
        val journalFile = new File("cache/core/core_2010_journal.csv")
        val nbJournals = fromFile(journalFile).getLines.size
        fromFile(journalFile).getLines().zipWithIndex foreach { case (line, idx) =>
        	setPercentage(((idx + 1) * 100 / nbJournals).toInt)
            val elems = line.split("\\|")
            println(line)
            if(elems.size >= 6 && idx != 0) {
            	val scoreText = elems(1)
                val name = elems(2)
                val shortName = ""
	            val fieldId = getField(elems(3))
	            val confId = Conference.create(name, shortName, journalType, fieldId)
	            
	            val scoreValue = scoreText match  {
                    case "A*" => 5
                    case "A" => 5
                    case "B" => 4
                    case "C" => 3
                    case _ => -1
                }
                
	            ExternalScore.createOrUpdate(confId, coreRankingId, scoreValue, scoreText, scoreValue)
	            
	            if(elems(3).size == 3) {
	            	val subfieldId = SubField.getOrCreate(elems(4), fieldId)
	            	Conference.addSubField(confId, subfieldId)
	            }
                if(elems.size >= 7 && !elems(5).isEmpty()) {
                    if(getField(elems(5)) == fieldId && elems(5).size == 4) {
                        val subfieldId = SubField.getOrCreate(elems(6), fieldId)
                		Conference.addSubField(confId, subfieldId)
                    }
                }
                if(elems.size >= 9 && !elems(7).isEmpty()) {
                    if(getField(elems(7)) == fieldId && elems(7).size == 4) {
                        val subfieldId = SubField.getOrCreate(elems(8), fieldId)
                		Conference.addSubField(confId, subfieldId)
                    }
                }
            }
        }
        infoMessage("Done")
        
	}
}