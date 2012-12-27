package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date
import java.text.SimpleDateFormat

case class Comment(
        id: Long, 
        userId: Long, 
        conferenceId: Long, 
        content: String, 
        date: Date, 
        isoDate: String, 
        user: User)

object Comment {

    val comment = {
        get[Long]("id") ~ get[Long]("createdBy") ~ get[Long]("conference_id") ~ get[String]("content") ~ get[Date]("createdAt") map {
            case id ~ userId ~ conferenceId ~ content ~ date => {
                val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                val isoDate = dateFormat.format(date)
                val user = User.findById(userId).get
            	Comment(id, userId, conferenceId, content, date, isoDate, user)
            } 
        }
    }
    
    def getById(id: Long) : Option[Comment] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM comment WHERE id = {id}").on('id -> id).as(Comment.comment.singleOpt)
    }
    
    def getByDate(date : Date) : Option[Comment] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM comment WHERE date = {createdAt}").on('date -> date).as(Comment.comment.singleOpt)
    }
    
    def getByConferenceId(conferenceId : Long): List[Comment] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM comment WHERE conference_id = {conferenceId} ORDER BY createdAt DESC").on('conferenceId -> conferenceId).as(comment *)
    }
    
    def all(): List[Comment] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM comment").as(comment *)
    }
    
    def setRelatedToConference(originalConferenceId : Long, newConferenceId : Long) = DB.withConnection { implicit c =>
        SQL("UPDATE comment SET conference_id = {newConferenceId} WHERE conference_id = {originalConferenceId}").on(
                'newConferenceId -> newConferenceId,
                'originalConferenceId -> originalConferenceId).executeUpdate()
    }
    
    def create(conferenceId : Long, userId : Long, content: String, date: Date) {
        DB.withConnection { implicit c =>
            SQL("INSERT INTO comment (createdBy, conference_id, content, createdAt) values " +
            		"({userId}, {conferenceId}, {content}, {date})").on(
                'userId -> userId,
                'conferenceId -> conferenceId,
                'content -> content,
                'date -> date).executeUpdate()
        }
    }

    def delete(id: Long) {
        DB.withConnection { implicit c =>
            SQL("DELETE FROM comment WHERE id = {id}").on('id -> id).executeUpdate()
        }
    }

}