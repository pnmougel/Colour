package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date

case class ExternalRanking(id: Long, url: String, name: String, description : String, scoreType : Long)

object ExternalRanking extends Table[ExternalRanking] {

    val tableName = "externalranking"
        
    val single = {
        get[Long]("id") ~ get[String]("url") ~ get[String]("name") ~ get[String]("description") ~ get[Long]("scoretype_id") map {
            case id ~ url ~ name ~ description ~ scoreTypeId => {
                ExternalRanking(id, url, name, description, scoreTypeId)
            }
        }
    }
    
    def getOrCreate(url: String, name: String, description: String, scoreTypeId : Long) : Long = {
    	val externalRanking = ExternalRanking.findOneBy(name, "name")
    	if(externalRanking.isDefined) {
			externalRanking.get.id
    	} else {
    		build('url -> url, 'name -> name, 'description -> description, 'scoretype_id -> scoreTypeId)
    	}
    }
}