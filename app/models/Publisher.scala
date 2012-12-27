package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date
import models.renorm.Table

case class Publisher(name: String) {
    var id : Long = 0
}

object Publisher extends Table[Publisher] {
    def getByName(name: String) = findOption('name -> name)
    
    def create(name: String) = createEntry('name -> name)
    
    def getOrCreate(name: String) = super.getOrCreate('name -> name)
}