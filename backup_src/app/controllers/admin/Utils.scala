package controllers.admin
import java.io.PrintWriter
import org.jsoup.Jsoup
import java.io.File
import scala.io.Source
import org.jsoup.nodes.Document
import scala.collection.mutable._
import models._
import controllers.admin.utils.Timer

object Utils {
    def getDocument(directory: String, fileName: String, url: String): Option[Document] = {
        //        println(url)
        val dirFile = new File("cache/" + directory)
        dirFile.mkdirs()
        val cacheFile = new File("cache/" + directory + "/" + fileName)
        if (cacheFile.exists()) {
            val html = Source.fromFile(cacheFile).getLines().mkString("\n")
            Option(Jsoup.parse(html))
        } else {
            if (Jsoup.connect(url).timeout(200000).ignoreHttpErrors(true).execute().statusCode() != 200) {
                return None
            }
            val tmpDoc = Jsoup.connect(url).timeout(200000).get()
            val htmlFile = new PrintWriter(cacheFile)
            htmlFile.write(tmpDoc.body().toString())
            htmlFile.flush()
            htmlFile.close()
            Option(tmpDoc)
        }
    }

    val percentageRankA = 0.1f
    val percentageRankB = 0.25f
    val percentageRankC = 0.45f
    val percentageRankD = 0.2f

    def getConferenceRankFromScore(scores: Seq[(Long, Int)]): HashMap[(Long, Int), Int] = {
        // Group the conference by subfields
        var subFieldToConferences = new HashMap[Long, Stack[(Long, Int)]]()
        scores.foreach { score =>
            val subfields = Conference.getSubFields(score._1)
            subfields.foreach { subfield =>
                subFieldToConferences.getOrElseUpdate(subfield.id, new Stack[(Long, Int)]()).push(score)
            }
        }

        // Compute the bounds for each subfield
        var subFieldBounds = new HashMap[Long, Array[Int]]()
        subFieldToConferences.keys.foreach { subfieldId =>
            val nbConferenceInSubField = SubField.getNbConferencesWithSubfield(subfieldId)
            val nbRankA = (nbConferenceInSubField * percentageRankA).toInt
            val nbRankB = nbRankA + (nbConferenceInSubField * percentageRankB).toInt
            val nbRankC = nbRankB + (nbConferenceInSubField * percentageRankC).toInt
            val nbRankD = (nbConferenceInSubField - nbRankC).toInt
            subFieldBounds(subfieldId) = Array[Int](nbRankA, nbRankB, nbRankC, nbRankD)
        }

        // Compute the score
        var conferenceRanks = new HashMap[(Long, Int), Int]()
        subFieldToConferences.foreach {
            case (subfieldId, confList) =>
                confList.sortWith(_._2 < _._2).zipWithIndex.foreach {
                    case (score, idx) =>
                        val rank = subFieldBounds(subfieldId).count(idx <= _)
                        val curRank = conferenceRanks.getOrElse(score, 0)
                        conferenceRanks(score) = math.max(curRank, rank)
                }
        }
        conferenceRanks
    }

    /*
    Remove articles and several words like symposium, conference, journal.
    Remove also parenthesis and what they contains, all non alphabetical characters, inclucluding ponctuation and numbers
    */
    val replacementWords = Map(
        "int" -> "international",
        "conf" -> "conference",
        "trans" -> "transaction",
        "sci" -> "science",
        "jour" -> "journal")
    val shortWords = Set("on", "at", "the", "a", "in", "to", "of", "for", "and", "into")
    val commonWords = Set("international", "conference", "workshop", "journal", "symposium", "transaction", "int.", "conf.", "trans.", "jour.", "ieee", "acm")

    def cleanName(name: String): String = {
        var lowerName = name.toLowerCase()

        var (curName, p) = getParenthesisContent(lowerName)
        // Remove non alphabetical characters
        // lowerName = lowerName.filter( c => c.isLetter || c.isWhitespace)

        // remove plural forms
        var words = curName.split("[/ -]").map(word => if (word.endsWith("s")) { word.substring(0, word.size - 1) } else { word })

        // Remove non alphabetical characters
        words = words.map(word => word.filter(c => c.isLetter || c.isWhitespace))

        // Remove short words
        words = words.filter(word => !shortWords.contains(word) && !word.isEmpty)

        // Remove common words
        words = words.filter(word => !commonWords.contains(word) && !word.isEmpty)

        // Replace some short words with full word
        words.map(word => replacementWords.getOrElse(word, word)).mkString(" ")
    }
    
    def findMatchingConference(name : String, shortName : Option[String] = None, fieldId : Option[Long] = None) : Option[Conference] = {
        // First try on name
        var confTmp = Conference.findByName(name, fieldId)
        var matchingConference = getBestMatch(name, confTmp)
        if(!matchingConference.isDefined) {
            // Try on short name
            if(shortName.isDefined) {
                if(!shortName.get.trim.isEmpty()) {
			        var confTmp = Conference.findByShortName(shortName.get, fieldId)
	            	matchingConference = getBestMatch(name, confTmp)
                }
            }
            if(!matchingConference.isDefined) {
                // Try on matching name
	            matchingConference = getBestMatch(name, Conference.findByMatchingName(cleanName(name), fieldId))
	        }
        }
        matchingConference
    }
    
    def getBestMatch(name : String, conferences : List[Conference]) : Option[Conference] = {
        if(conferences.size == 1) {
            Option(conferences(0))
        } else if(conferences.size > 1 && conferences.size < 100) {
            val minConference = conferences.minBy { conference => stringDistance(conference.name, name) }
            if(stringDistance(minConference.name, name) < 0.8) {
                Option(minConference)
            } else {
                None
            }
        } else {
            None
        }
    }
    
    // Compute Levensthein distance between two string
    // The lower is the value, the more similar are the strings
    def stringDistance(s1: String, s2: String): Int = {
        val memo = scala.collection.mutable.Map[(List[Char], List[Char]), Int]()
            def min(a: Int, b: Int, c: Int) = math.min(math.min(a, b), c)
            def sd(s1: List[Char], s2: List[Char]): Int = {
                if (!memo.contains((s1, s2)))
                    memo((s1, s2)) = (s1, s2) match {
                        case (_, Nil) => s1.length
                        case (Nil, _) => s2.length
                        case (c1 :: t1, c2 :: t2) => min(sd(t1, s2) + 1, sd(s1, t2) + 1,
                            sd(t1, t2) + (if (c1 == c2) 0 else 1))
                    }
                memo((s1, s2))
            }

        sd(s1.toList, s2.toList)
    }

    // Remove the in parenthesis content and return a list of these contents
    def getParenthesisContent(data: String): (String, List[String]) = {
        var curData = data
        var parenthesisContents = List[String]()
        var parenthesisStart = 0
        var parenthesisEnd = 0
        do {
            parenthesisStart = curData.indexOf("(")
            parenthesisEnd = curData.indexOf(")")
            if (parenthesisStart != -1 && parenthesisEnd != -1) {
                val parenthesisContent = curData.substring(parenthesisStart + 1, parenthesisEnd)
                parenthesisContents = parenthesisContent :: parenthesisContents
                val toRemove = if (parenthesisStart != 0 && parenthesisEnd != curData.size - 1 && curData(parenthesisStart - 1) == ' ' && curData(parenthesisEnd + 1) == ' ') {
                    "(" + parenthesisContent + ") "
                } else {
                    "(" + parenthesisContent + ")"
                }
                curData = curData.replace(toRemove, "")
            }
        } while (parenthesisStart != -1 && parenthesisEnd != -1)

        (curData.trim(), parenthesisContents)
    }
}