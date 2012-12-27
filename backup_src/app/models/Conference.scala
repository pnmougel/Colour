package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import views.html.conferences.userScores

case class Conference(id: Long, name: String, shortName: Option[String], ctype : CType, region : Region,
        yearSince: Option[Int], description: Option[String], publisher: Option[Publisher], hindex: Option[Int], nbArticles: Option[Int], 
        externalScore : Option[Double], userScore : Option[Double], avgScore : Option[Double], field: Field)

object Conference {
    val conference = {
        get[Long]("id") ~ 
        get[String]("name") ~
        get[Option[String]]("short_name") ~
        get[Option[Int]]("yearSince") ~
        get[Option[String]]("description") ~
        get[Long]("ctype_id") ~
        get[Long]("region_id") ~
        get[Option[Long]]("publisher_id") ~ 
        get[Option[Int]]("hindex") ~ 
        get[Option[Int]]("nbArticles") ~ 
        get[Option[Double]]("user_score") ~ 
        get[Option[Double]]("external_score") ~ 
        get[Option[Double]]("avg_score") ~
        get[Long]("field_id") map {
            case id ~ name ~ shortName ~ yearSince ~ description ~ cTypeId ~ regionId ~ publisherId ~ hindex ~ nbArticles ~ userScore ~ externalScore ~ avgScore ~ fieldId =>
                val field = Field.findById(fieldId).get
                val cType = CType.findById(cTypeId).get
                val region = Region.findById(regionId).get
                val publisher = {
                    if(publisherId.isEmpty) {
                        None
                    } else {
                        Publisher.getById(publisherId.get)
                    }
                }
                /*
                val avgScore : Option[Double] = {
                    if(!userScore.isDefined && !externalScore.isDefined) {
                        None
                    } else {
                        if(userScore.isDefined) {
                            if(externalScore.isDefined) {
                                Option[Double]((userScore.get + externalScore.get) / 2) 
                            } else {
                                userScore
                            }
                        } else {
                            externalScore
                        }
                    }
                }
                */
                Conference(id, name, shortName, cType, region, yearSince, description, publisher, hindex, nbArticles, externalScore, userScore, avgScore, field)
        }
    }

    def all() : List[Conference] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM Conference").as(conference *)
    }
    
    def updateMatchingName(id : Long, matchingName : String) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET nameMatching = {matchingName} WHERE id = {id}").on('id -> id, 'matchingName -> matchingName).executeUpdate()
    }
    
    def countPages(fieldId : Long, cTypes : List[Long], subFields : List[Long]) : Long = DB.withConnection { implicit c =>
        val subFieldsStr : String = if(subFields.size > 0) {
    	    subFields.mkString("(", ",", ")")
    	} else {
    	    " (NULL) "
    	}
    	val cTypesStr : String = if(cTypes.size > 0) {
    	    cTypes.mkString("(", ",", ")")
    	} else {
    	    " (NULL) "
    	}
        val firstRow = SQL(
                "SELECT COUNT(conference.*) AS c  " +  
                "FROM conference, conference_subfield " + 
                "WHERE conference.ctype_id IN " + cTypesStr +
                "AND conference.field_id = {fieldId} " +
                "AND conference_subfield.subfield_id IN " + subFieldsStr +
                "AND conference_subfield.conference_id = conference.id").on(
                'fieldId -> fieldId).apply().head
        return firstRow[Long]("c")
    }
    
    def getPage(fieldId : Long, cTypes : List[Long], subFields : List[Long], nbConferencesPerPage : Int, startAt : Int, orderBy : String, sort : String) : 
    		List[Conference] = DB.withConnection { implicit c =>
    	val subFieldsStr : String = if(subFields.size > 0) {
    	    subFields.mkString("(", ",", ")")
    	} else {
    	    " (NULL) "
    	}
    	val cTypesStr : String = if(cTypes.size > 0) {
    	    cTypes.mkString("(", ",", ")")
    	} else {
    	    " (NULL) "
    	}
        SQL("SELECT conference.* " +  
            "FROM conference, conference_subfield " + 
            "WHERE conference.ctype_id IN " + cTypesStr +
            "AND conference.field_id = {fieldId} " +
            "AND conference_subfield.subfield_id IN " + subFieldsStr +
            "AND conference_subfield.conference_id = conference.id " +
            "ORDER BY " + orderBy + " " + sort + " NULLS LAST " +
            "LIMIT {nbConferencesPerPage}  " +
            "OFFSET {startAt} "
                ).on(
                'fieldId -> fieldId,
                'nbConferencesPerPage -> nbConferencesPerPage,
                'startAt -> startAt,
                'orderBy -> orderBy,
                'sort -> sort).as(conference *)
    }
    
    def create(name: String, shortName: String, cTypeId : Long, fieldId : Long, regionIdOpt : Option[Long] = None) : Long = {
        val regionId = if(regionIdOpt.isDefined) {
            regionIdOpt.get
        } else {
            Region.getOrCreate("Worldwide", None, true)
        }

        DB.withConnection { implicit c =>
            SQL("INSERT INTO Conference (name, short_name, ctype_id, field_id, region_id) " +
            		"values ({name}, {shortName}, {cTypeId}, {fieldId}, {regionId})").on(
                'name -> name,
                'shortName -> shortName,
                'cTypeId -> cTypeId,
                'fieldId -> fieldId,
                'regionId -> regionId).executeInsert().get
        }
    }
    
    def setHIndex(id : Long, hindex : Int) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET hindex = {hindex} WHERE id = {id}").on('id -> id, 'hindex -> hindex).executeUpdate()
    }
    
    def setNbArticles(id : Long, nbArticles : Int) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET nbarticles = {nbArticles} WHERE id = {id}").on('id -> id, 'nbArticles -> nbArticles).executeUpdate()
    }
    
    def updateHindexNbArticles(id : Long, hindex : Int, nbArticles : Int) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET nbarticles = {nbArticles}, hindex = {hindex} WHERE id = {id}").on(
                'id -> id, 
                'nbArticles -> nbArticles,
                'hindex -> hindex).executeUpdate()
    }
    
    /*
     * Subfields
     */
    // Add a subfield to the conference
    def addSubField(conferenceId : Long, subfieldId : Long) = DB.withConnection { implicit c =>
        val isAlreadyPresent = SQL("SELECT count(*) FROM conference_subfield WHERE conference_id = {conferenceId} and subfield_id = {subfieldId}").on(
                'conferenceId -> conferenceId, 'subfieldId -> subfieldId).as(scalar[Long].single)
        if(isAlreadyPresent == 0) {
            SQL("INSERT INTO conference_subfield (conference_id, subfield_id) VALUES ({conferenceId}, {subfieldId})").on(
                'conferenceId -> conferenceId, 'subfieldId -> subfieldId).executeUpdate()
        }
        
    }
    
    // Remove a subfield
    def removeSubField(conferenceId : Long, subfieldId : Long) = DB.withConnection { implicit c =>
        SQL("DELETE FROM conference_subfield WHERE conference_id = {conferenceId} AND subfield_id = {subfieldId}").on(
                'conferenceId -> conferenceId, 'subfieldId -> subfieldId).executeUpdate()
    }
    
    // List the subfields related to the conference
    def getSubFields(conferenceId : Long) : List[SubField] = DB.withConnection { implicit c =>
        SQL("SELECT subfield.* FROM subfield, conference_subfield " +
        		"WHERE conference_subfield.conference_id = {conferenceId} AND conference_subfield.subfield_id = subfield.id").on(
                'conferenceId -> conferenceId).as(SubField.single *)
    }
    
    def count() : Long = DB.withConnection { implicit c =>
        val firstRow = SQL("SELECT count(*) as c FROM Conference").apply().head
        return firstRow[Long]("c")
    }
    
    def getById(id : Long) : Option[Conference] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM Conference WHERE id = {id}").on('id -> id).as(Conference.conference.singleOpt)
    }
    
    def findByNameAndShortName2(query: String) : List[Conference] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM Conference WHERE name ILIKE {query} OR short_name ILIKE {query}").on(
                'query -> ("%" + query + "%")).as(conference *)
    }
    
    def findByNameAndShortName(query: String) : List[Conference] = DB.withConnection { implicit c =>
        val newQuery = query.replaceAll("International", "").replaceAll("""\\""", "").replaceAll("Conference", "").replaceAll("Journal", "").replace("(", "").replace(")", "").replaceAll("    ", " ").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " ").trim().replaceAll(" ", " | ")
        SQL("""
            SELECT *
        	FROM conference, to_tsquery('english', {query}) query
        	WHERE to_tsvector('english', short_name) @@ query
        	OR to_tsvector('english', name) @@ query
        	ORDER BY ts_rank_cd(to_tsvector('english', short_name), query, 32) * 2 DESC, 
            ts_rank_cd(to_tsvector('english', name), query, 32) DESC, hindex DESC
            LIMIT 30""").on(
                'query -> newQuery).as(conference *)
    }
    
    /**
     * This method is used to find the conference matching a name or short name
     * It could be improved, up to now it is very simple
     */
    def findBestMatch(
            name : String, 
            shortName : String, 
            cType : Option[Long] = None, 
            fieldId : Option[Long] = None) : Option[Conference] = DB.withConnection { implicit c =>

        // Build filter on type and field
        var filter = ""
        if(cType.isDefined) {
            filter += " AND ctype_id = " + cType.get
        }
        if(fieldId.isDefined) {
            filter += " AND field_id = " + fieldId.get
        }
        val matchingOnName = SQL("SELECT * FROM Conference WHERE short_name ILIKE {shortName} AND name ILIKE {name}" + filter).on(
                'shortName -> shortName, 'name -> name).as(conference *)
        if(matchingOnName.size == 1) {
            Option(matchingOnName(0))
        } else {
            None
        }
    }

    def findByShortName(query: String, fieldId : Option[Long] = None) : List[Conference] = DB.withConnection { implicit c =>
        if(fieldId.isDefined) {
            SQL("SELECT * FROM Conference WHERE shortnamelower = {query} AND field_id = {fieldId}").on(
                'query -> query.toLowerCase(),
                'fieldId -> fieldId.get).as(conference *)
        } else {
            SQL("SELECT * FROM Conference WHERE shortnamelower = {query}").on(
                'query -> query.toLowerCase()).as(conference *)
        }
    }
    
    def findByName(query: String, fieldId : Option[Long] = None) : List[Conference] = DB.withConnection { implicit c =>
        if(fieldId.isDefined) {
            SQL("SELECT * FROM Conference WHERE namelower = {query} AND field_id = {fieldId}").on(
                'query -> query.toLowerCase(),
                'fieldId -> fieldId.get).as(conference *)
        } else {
            SQL("SELECT * FROM Conference WHERE namelower = {query}").on(
                'query -> query.toLowerCase()).as(conference *)
        }
    }
    
    def findByMatchingName(name: String, fieldId : Option[Long] = None) : List[Conference] = DB.withConnection { implicit c =>
        if(fieldId.isDefined) {
            SQL("SELECT * FROM Conference WHERE nameMatching = {query} AND field_id = {fieldId}").on(
                'query -> name,
                'fieldId -> fieldId.get).as(conference *)
        } else {
            SQL("SELECT * FROM Conference WHERE nameMatching = {query}").on(
                'query -> name).as(conference *)
        }
    }
    
    def findByField(fieldId : Long) : List[Conference] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM Conference WHERE field_id = {fieldId} ORDER BY external_score DESC NULLS LAST LIMIT 10").on(
                'fieldId -> fieldId).as(conference *)
    }
    
    def updateHIndex(id : Long, hIndex : Int) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET hindex = {hIndex} WHERE id = {id}").on(
                'hIndex -> hIndex,
                'id -> id).executeUpdate()
    }
    
    def update(id : Long, name : String, shortName : String, cTypeId : Long, regionId : Long, yearSince : Int, publisherId : Long, description : String) = DB.withConnection { implicit c =>
        SQL("""UPDATE conference 
               SET name = {name},
               short_name = {shortName},
               ctype_id = {cTypeId},
               region_id = {regionId},
               yearsince = {yearSince},
               publisher_id = {publisherId},
               description = {description}
               WHERE id = {id}""").on(
                'name -> name,
                'shortName -> shortName,
                'cTypeId -> cTypeId,
                'regionId -> regionId,
                'yearSince -> yearSince,
                'publisherId -> publisherId,
                'description -> description,
                'id -> id).executeUpdate()
    }

    def updatRegion(whereCondition : String, regionId : Long) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET region_id = {regionId} WHERE name ILIKE {whereCondition} OR short_name ILIKE {whereCondition}").on(
                'whereCondition -> whereCondition,
                'regionId -> regionId).executeUpdate()
    }
    def updateType(whereCondition : String, cTypeId : Long) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET ctype_id = {cTypeId} WHERE name ILIKE {whereCondition} OR short_name ILIKE {whereCondition}").on(
                'whereCondition -> whereCondition,
                'cTypeId -> cTypeId).executeUpdate()
    }
    def updatePublisher(whereCondition : String, publisherId : Long) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET publisher_id = {publisherId} WHERE name ILIKE {whereCondition} OR short_name ILIKE {whereCondition}").on(
                'whereCondition -> whereCondition,
                'publisherId -> publisherId).executeUpdate()
    }
    
    def updateNbArticles(id : Long, nbArticles : Int) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET nb_articles = {nbArticles} WHERE id = {id}").on(
                'nbArticles -> nbArticles,
                'id -> id).executeUpdate()
    }
    
    def updatePublisher(id : Long, publisher : Long) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET publisher_id = {publisher} WHERE id = {id}").on(
                'publisher -> publisher,
                'id -> id).executeUpdate()
    }
    
    def updateName(id : Long, name : String) = DB.withConnection { implicit c =>
        SQL("UPDATE conference SET name = {name} WHERE id = {id}").on(
                'name -> name,
                'id -> id).executeUpdate()
    }
    
    def updateUserScoreForConference(conferenceId: Long) = DB.withConnection { implicit c =>
        val userScore = UserVote.getUserVotesByConferenceId(conferenceId)
        val score : Option[Double] = { 
            if(userScore.avgUserScore == -1) {
                None
            } else {
                Option[Double](userScore.avgUserScore)
            }
        }
        
        val row = SQL("""
                UPDATE conference 
                SET user_score = {userScore}
                WHERE id = {conferenceId}""").on(
                'conferenceId -> conferenceId,
                'userScore -> score).executeUpdate()
        updateAvgScoreForConference(conferenceId)
    }
    
    def updateExternalScoreForConference(conferenceId: Long) = DB.withConnection { implicit c =>
        
        var externalScoreTotal : Double = 0
        val externalScores = ExternalScore.getByConferenceId(conferenceId)
        externalScores.foreach { externalScore =>
            externalScoreTotal += externalScore.score
        }
        val externalScore : Option[Double] = {
            if(externalScores.size > 0) {
                Option[Double](externalScoreTotal / externalScores.size)
            } else {
                None
            }
        }
        
        val row = SQL("""
                UPDATE conference 
                SET external_score = {externalScore}
                WHERE id = {conferenceId}""").on(
                'externalScore -> externalScore,
                'conferenceId -> conferenceId).executeUpdate()
        updateAvgScoreForConference(conferenceId)
    } 
    
    def updateAvgScoreForConference(conferenceId: Long) = DB.withConnection { implicit c =>
        val row = SQL("""
                UPDATE conference 
                SET avg_score = (external_score + user_score) / 2 
                WHERE id = {conferenceId}""").on(
                'conferenceId -> conferenceId).executeUpdate()
    } 
    
    def delete(id: Long) {
        DB.withConnection { implicit c =>
            SQL("DELETE FROM Conference WHERE id = {id}").on('id -> id).executeUpdate()
        }
    }
    
    def deleteAll() {
        DB.withConnection { implicit c =>
            SQL("DELETE FROM Conference").executeUpdate()
        }
    }
    def getOrCreate(name : String, shortName : String, cTypeId : Long, fieldId : Long, regionId : Option[Long] = None) : (Long, Boolean) = DB.withConnection { implicit c =>
        val conference = findBestMatch(name, shortName, Option(cTypeId), Option(fieldId))
        if(conference.isDefined) {
            (conference.get.id, false)
        } else {
            (create(name, shortName, cTypeId, fieldId, regionId), true)
        }
    }
}