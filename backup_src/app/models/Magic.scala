package models
import scala.collection.mutable.ListBuffer
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import java.util.Date
import java.text.SimpleDateFormat

/*
Quelques idées rapides :
- Il est possible de définir des paramètres where, from (surement découvrable automatiquement), limit, group by qui ont plusieurs types (Pattern Matching), donc on pourrait avoir soit une séquence, soit un type plus complexe (AND OR IN LIKE, ETC)
- Il faut faire le update (Seq pour les valeurs à modifier et Where pour savoir ou), surement faire un updateAtId également
- l'attribut single doit surement être générable de manière automatique, avec un comportement sympa
- réfléchir à comment faire les jointures
- Pour l'insertion, il doit être possible d'utiliser le type T. En fait, T pose surtout des problèmes pou l'identifiant. Avant l'insertion il n'existe pas, par contre, lorsque l'on récupère une instance on en a besoin et d'une manière simple (i.e., T.id et pas T.id.get). L'exemple suivant est une piste de ce que l'on pourraît faire. 
Attention, il faut aussi prendre en compte le cas avec des clés plus complexes (ce qui correspond au generic KeyType)

    class Entity[KeyType] {
        def id : KeyType = {
            0
        }
    }

    case class Foo(name: String) extends Entity

 - Il faut aussi absolument gérer le cas de manière élégante ou le Case Class correspond assez peu à la table (i.e., champs en plus et champs en moins). Comment gérer le cas ou un attibut d'une case classe doit être modifié pour corespondre à des champs dans la base de données ? Annotation MapsTo : Function[Any, (String, Any)*] ?

 - Idée générale : La case class telle qu'il est défini actuellement permet de faire un mapping row => Class mais pas l'inverse. Il est donc utile pour la selection mais pas l'insertion. Le mapping inverse permet de gérer l'insertion de manière élégante.

 */

abstract class Magic[T](tableNameOpt : Option[String] = None)(implicit t: reflect.Manifest[T]) {
    val idColumn = "id"
        
    val tableName = tableNameOpt.getOrElse(t.toString.split("[.]").last)
    
    // It should be possible to build given T a default RowParser which can possibly be overriden
    val single : RowParser[T]


    def getOrCreate(entry : Any) : Long = {
        val params = getSeqFromTableEntry(entry)
        val id = findIdWhere(params)
        if(id.isDefined) {
            id.get
        } else {
            createEntry(entry)
        }
    }
    
    def createEntry(entry : Any) : Long = DB.withConnection { implicit c =>
        createEntry(getSeqFromTableEntry(entry))
    }
    def createEntry(params : Seq[(String, ParameterValue[_])]) : Long = DB.withConnection { implicit c =>
        SQL("INSERT INTO " + tableName + 
            params.map(_._1).mkString(
            "(", ",", ") VALUES " + 
            params.map("{" + _._1 + "}").mkString("(", ",", ")"))).on(params:_*).executeInsert().get
    }
    
    // Count
    def count() : Long = DB.withConnection { implicit c =>
        SQL("SELECT COUNT(*) FROM " + tableName).as(scalar[Long].single)
    }

    def countWhere(params: Seq[(String, ParameterValue[_])]) : Long = DB.withConnection { implicit c =>
        Sql("SELECT COUNT(*) FROM " + tableName + " WHERE " + andQuery(params), params).as(scalar[Long].single)
    }

    // Find
    def findIdWhere(params: Seq[(String, ParameterValue[_])]): Option[Long] = DB.withConnection { implicit connection =>
        val query = "SELECT " + idColumn + " FROM " + tableName + " WHERE " + andQuery(params)
        Sql(query, params).as(scalar[Long].singleOpt)
    }

    def findWhere(params: (String, ParameterValue[_])*): List[T] = DB.withConnection { implicit connection => 
        select(params).as(single *)
    }

    def findOneWhere(params: Seq[(String, ParameterValue[_])]): Option[T] = DB.withConnection { implicit connection => 
        select(params).as(single.singleOpt)
    }
    
    def findExistingOneWhere(params: Seq[(String, ParameterValue[_])]) : T = DB.withConnection { implicit connection =>
        select(params).as(single.single)
    }

    def select(params: Seq[(String, ParameterValue[_])]) : SimpleSql[_] = DB.withConnection { implicit connection =>
        Sql("SELECT * FROM " + tableName + " WHERE " + andQuery(params), params)
    }

    // Deletes
    def deleteAll() = DB.withConnection { implicit c =>
        SQL("DELETE FROM " + tableName).executeUpdate()
    }

    def deleteWhere(params: Seq[(String, ParameterValue[_])]) : Long = DB.withConnection { implicit c =>
        Sql("DELETE FROM " + tableName + " WHERE " + andQuery(params), params).executeUpdate()
    }

    def deleteById(id: Long) {
        DB.withConnection { implicit c =>
            SQL("DELETE FROM " + tableName + " WHERE " + idColumn + " = {" + id + "}").on('id -> id).executeUpdate()
        }
    }

    def Sql(query : String, params: Seq[(String, ParameterValue[_])]) : SimpleSql[_] = DB.withConnection { implicit connection =>
        SQL(query).on(params:_*)
    }

    def andQuery(params: Seq[(String, ParameterValue[_])]) = {
        if (params.isEmpty) {
            ""
        } else {
            params.map { case (col, _) => col + " = {" + col + "}" }.mkString(" AND ")
        }
    }
    
    def update(id : Long, updatedValues: Seq[(String, ParameterValue[_])]) = DB.withConnection { implicit c =>
        val updateValuesStr = if (updatedValues.isEmpty) {
            ""
        } else {
            updatedValues.map { case (col, _) => col + " = {" + col + "}" }.mkString(", ")
        }
        Sql("UPDATE " + tableName + " SET " + updateValuesStr + " WHERE " + idColumn + " = " + id, updatedValues).executeUpdate()
    }

    def getSeqFromTableEntry(tableEntry : Any) : Seq[(String, ParameterValue[_])] = {
        val elements = new scala.collection.mutable.Stack[(String, ParameterValue[_])]()
        tableEntry.getClass.getDeclaredFields.foreach { field =>
            field.setAccessible(true)
            val fieldName = if(field.isAnnotationPresent(classOf[Attribute])) {
                field.getAnnotation(classOf[Attribute]).value()
            } else {
                field.getName()
            }
            elements.push(fieldName -> field.get(tableEntry))
        }
        elements
    }
}