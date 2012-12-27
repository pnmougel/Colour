package models
import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db._

case class ExternalScore(conferenceId: Long, externalRanking : Option[ExternalRanking], rank : Int, score: Int, scoreText : String)


object ExternalScore extends Table[ExternalScore] {

    val single = {
        get[Long]("ranking_id") ~ get[Long]("conference_id") ~ get[Int]("score_value") ~ get[Int]("rank") ~ get[String]("score_text") map {
            case rankingId ~ conferenceId ~ scoreValue ~ rank ~ scoreText => {
                val externalRanking = ExternalRanking.findById(rankingId)
                ExternalScore(conferenceId, externalRanking, rank, scoreValue, scoreText)
            }
        }
    }
    
    val tableName = "externalranking_conference"
    
    def getByConferenceId(conferenceId: Long) : List[ExternalScore] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM externalranking_conference WHERE conference_id = {id}").on('id -> conferenceId).as(single *)
    }
    
    def getRankingForConference(conferenceId: Long, rankingId : Long) : Option[ExternalScore] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM externalranking_conference WHERE conference_id = {id} AND ranking_id = {rankingId}").on(
                'id -> conferenceId,
                'rankingId -> rankingId).as(single.singleOpt)
    }

    def deleteByExternalRanking(externalRankingId : Long) = DB.withConnection { implicit c =>
        SQL("DELETE FROM externalranking_conference WHERE ranking_id = {externalRankingId}").on('externalRankingId -> externalRankingId).executeUpdate()
    }
    
    def deleteByConference(conferenceId : Long) = DB.withConnection { implicit c =>
        SQL("DELETE FROM externalranking_conference WHERE conference_id = {conferenceId}").on(
                'conferenceId -> conferenceId).executeUpdate()
        Conference.updateExternalScoreForConference(conferenceId)
    }
    
    /*
    def updateScore(conferenceId : Long, rankingId: Long, score: Int, rank : Int) = DB.withConnection { implicit c =>
        SQL("UPDATE external_ranking_conference SET score = {score}, rank = {rank} WHERE conference_id = {conferenceId} AND ranking_id = {rankingId}").on(
                'conferenceId -> conferenceId,
                'score -> score,
                'rank -> rank,
                'rankingId -> rankingId).executeUpdate()
        Conference.updateExternalScoreForConference(conferenceId)
    }
    */
    
    def createOrUpdate(
            conferenceId : Long, 
            rankingId: Long, 
            scoreValue: Int, 
            scoreText : String, 
            rank : Int) = DB.withConnection { implicit c =>

        // If the score already exist, it is updated
        val externalScore = SQL("SELECT * FROM externalranking_conference WHERE conference_id = {id} AND ranking_id = {rankingId}").on(
                'id -> conferenceId,
                'rankingId -> rankingId).as(single.singleOpt)
        if(externalScore.isDefined) {
            SQL("UPDATE externalranking_conference SET score_value = {score_value}, rank = {rank}, score_text = {score_text} WHERE conference_id = {conferenceId} AND ranking_id = {rankingId}").on(
                'conference_id -> conferenceId, 
                'ranking_id -> rankingId, 
                'score_value -> scoreValue, 
                'score_text -> scoreText, 
                'rank -> rank).executeUpdate()
        } else {
            build(
                'conference_id -> conferenceId, 
                'ranking_id -> rankingId, 
                'score_value -> scoreValue, 
                'score_text -> scoreText, 
                'rank -> rank)
        }   
        Conference.updateExternalScoreForConference(conferenceId)
    } 
    /*
    private def getRealScore(rankingId : Long, score : Int) = rankingId match {
        case 2 => {
            getAstarScore(score)
        }
        case _ => {
            -1
        }
    }
    
    private def getAstarScore(score : Int) = score match {
        case 4 => 5
        case 3 => 4.5
        case 2 => 3.5
        case 1 => 2
        case _ => -1
    }

    
    private def getScoreText(rankingId : Long, score : Int) = rankingId match {
        case 2 => {
            getAstarScoreText(score)
        }
        case _ => {
            ""
        }
    }
    
    private def getAstarScoreText(score : Int) = score match {
        case 4 => "Rank A+"
        case 3 => "Rank A"
        case 2 => "Rank B"
        case 1 => "Rank C"
        case _ => ""
    }
    */
    
}