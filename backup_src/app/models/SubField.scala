package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class SubField(id: Long, name: String, fieldId : Long)

object SubField extends Table[SubField] {
	
    val tableName = "subfield"
    
    val single = {
        get[Long]("id") ~ get[String]("name") ~ get[Long]("field_id") map {
            case id ~ name ~ fieldId => SubField(id, name, fieldId)
        }
    }
    
    def getByName(name: String) : Option[SubField] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM subfield WHERE name = {name} LIMIT 1").on('name -> name).as(single.singleOpt)
    }
    
    def getByField(id: Long) : List[SubField] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM subfield WHERE field_id = {id} ORDER BY name").on('id -> id).as(single *)
    }

    def getByFieldAndName(name: String, fieldId: Long) : Option[SubField] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM subfield WHERE field_id = {fieldId} AND name = {name}").on(
            'fieldId -> fieldId,
            'name -> name).as(single.singleOpt)
    }
    
    def getNbConferencesWithSubfield(subfieldId : Long) : Long = DB.withConnection { implicit c =>
        SQL("SELECT count(*) FROM conference_subfield WHERE subfield_id = {subfieldId}").on(
            'subfieldId -> subfieldId).as(scalar[Long].single)
    }

    def all(): List[SubField] = DB.withConnection { implicit c =>
        SQL("SELECT * FROM subfield ORDER BY name").as(single *)
    }
    
    def setRelatedToConference(originalConferenceId : Long, newConferenceId : Long) = DB.withConnection { implicit c =>
        SQL("UPDATE conference_subfield SET conference_id = {newConferenceId} WHERE conference_id = {originalConferenceId}").on(
                'newConferenceId -> newConferenceId,
                'originalConferenceId -> originalConferenceId).executeUpdate()
    }
    
    def getOrCreate(name : String, fieldId : Long) : Long = {
        val subField = getByFieldAndName(name, fieldId)
        if(subField.isDefined) {
            subField.get.id
        } else {
            create(name, fieldId)
        }
    }

    def create(name: String, fieldId : Long) : Long = build('name -> name, 'field_id -> fieldId)
}