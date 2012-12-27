package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date
import models.renorm.Table

case class BibliometricSource(name: String, url : String) {
    var id : Long = 0
}

object BibliometricSource extends Table[BibliometricSource] {
    lazy val dblpSource = getOrCreate("Dblp", "http://dblp.org/")
    lazy val microsoftARSource = getOrCreate("Microsoft AR", "http://academic.research.microsoft.com/")
    lazy val googleScholarSource = getOrCreate("Google Scholar", "http://scholar.google.com/")
    
    def getOrCreate(name: String, url : String) : Long = super.getOrCreate('name -> name, 'url -> url)
}