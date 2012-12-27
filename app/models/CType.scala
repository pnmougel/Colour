package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date
import models.renorm.Table

case class CType(name: String) {
    var id : Long = 0
}

object CType extends Table[CType] {
    lazy val conferenceType = getOrCreate("Conference")
    lazy val journalType = getOrCreate("Journal")
    lazy val workshopType = getOrCreate("Workshop")
    
    def create(name: String) : Long = createEntry('name -> name)
    def getOrCreate(name: String) : Long = super.getOrCreate('name -> name)
}