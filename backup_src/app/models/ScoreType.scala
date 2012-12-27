package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date

case class ScoreType(id: Long, name: String, description: String)

case class ScoreTypeEntry(val name: String, description: String)
    
object ScoreType extends Magic[ScoreType](Option("scoretype")) {

    val single = {
        get[Long]("id") ~ get[String]("name") ~ get[String]("description") map {
            case id ~ name ~ description => ScoreType(id, name, description)
        }
    }
    
    def getById(id : Long) : Option[ScoreType]  = DB.withConnection { implicit c =>
        SQL("SELECT * FROM externalscoretype WHERE id = {id}").on('id -> id).as(ScoreType.single.singleOpt)
    }

    def delete(id : Long) = deleteById(id)
}