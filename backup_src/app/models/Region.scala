package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date

case class Region(id: Long, name: String, adjective : String, isInternational : Boolean)

object Region extends Table[Region] {

    val tableName = "Region"
        
    val single = {
        get[Long]("id") ~ get[String]("name") ~ get[Option[String]]("adjective") ~ get[Boolean]("isInternational")map {
            case id ~ name ~ adjectiveOpt ~ isInternational => {
                val adjective = if(adjectiveOpt.isDefined) adjectiveOpt.get else name
                Region(id, name, adjective, isInternational)
            }
        }
    }
    
    def getInternationalRegions() : List[Region] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM Region WHERE isInternational = true ORDER BY id").as(single *)
    }
    
    def getCountries() : List[Region] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM Region WHERE isInternational = false ORDER BY name").as(single *)
    }
    
    def getFrequentCountries() : List[Region] = DB.withConnection { implicit c =>
        SQL("""SELECT r.*
            FROM Region r, Conference c
            WHERE c.region_id = r.id
            AND r.isInternational = false
            GROUP BY r.id
            ORDER BY count(*) DESC
            LIMIT 10;""").as(single *)
    }
    
    def create(name: String, adjectiveOpt : Option[String], isInternational : Boolean) : Long = {
        build('name -> name, 'adjective -> adjectiveOpt, 'isinternational -> isInternational)
    }

    def getOrCreate(name: String, adjectiveOpt : Option[String], isInternational : Boolean) : Long = {
        val region = findOneBy(name, "name")
        if(region.isDefined) {
            region.get.id
        } else {
            create(name, adjectiveOpt, isInternational)
        }
    }
}