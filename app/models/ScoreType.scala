package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date
import models.renorm.Table

case class ScoreType(name: String, description: String) {
    var id : Long = 0
}

object ScoreType extends Table[ScoreType](Option("scoretype")) {
    def getOrCreate(name: String, description: String) = super.getOrCreate('name -> name, 'description -> description)
}