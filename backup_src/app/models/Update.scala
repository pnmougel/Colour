package models

import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date
import models.Annotations._

case class Update(id: Long, conference: Long, user: Long, date: Date)

case class UpdateEntry(
    @FieldName("conference_id") 
    val conferenceId: Long, 

    @FieldName("user_id") 
    val userId: Long, 

    val date: Date)

object Update extends Magic[Update] {
    // val tableName = "update"

    val single = {
        get[Long]("id") ~ get[Long]("conference_id") ~ get[Long]("user_id") ~ get[Date]("date") map {
            case id ~ conferenceId ~ userId ~ date => {
                Update(id, conferenceId, userId, date)
            }
        }
    }
    
    def create(entry : UpdateEntry) : Long = createEntry(entry)
}