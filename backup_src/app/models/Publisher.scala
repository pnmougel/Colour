package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Publisher(id: Long, name: String)

object Publisher extends Magic[Publisher] {

    val single = {
        get[Long]("id") ~ get[String]("name") map {
            case id ~ name => Publisher(id, name)
        }
    }
    
    def getByName(name: String) : Option[Publisher] = findOneWhere(Seq(("name", name)))
    
    def getById(id: Long) : Option[Publisher] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM publisher WHERE id = {id} LIMIT 1").on('id -> id).as(Publisher.single.singleOpt)
    }
    
    def all(): List[Publisher] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM publisher ORDER BY name").as(single *)
    }

    def create(name: String) : Long = {
        DB.withConnection { implicit c =>
            SQL("INSERT INTO publisher (name) values ({name})").on(
                'name -> name).executeInsert().get
        }
    }
    
    def getOrCreate(name: String) : Long = {
        val publisherId = getByName(name)
        if(publisherId.isDefined) {
            publisherId.get.id
        } else {
            create(name)
        }
    }

    def delete(id: Long) {
        DB.withConnection { implicit c =>
            SQL("DELETE FROM publisher WHERE id = {id}").on('id -> id).executeUpdate()
        }
    }
}