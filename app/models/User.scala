package models

import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import java.security.MessageDigest
import java.math.BigInteger
import models.renorm.Table

case class User(email: String, key: String, pseudo: Option[String], isAdmin: Boolean, isPublic : Boolean, apiKey : String) {
    var id : Long = 0
    
    lazy val ideaLiked = IdeaVote.byUser(id)
}

object User extends Table[User](Option("IUser")) {
    // -- Queries
    def findByEmail(email: String): Option[User] = findOption('email -> email)
    
    def hash(password : String) : String = {
        val digest = MessageDigest.getInstance("SHA").digest(password.getBytes())
        val number = new BigInteger(1, digest)
        number.toString(16).toUpperCase()
    }
    
    def getByKey(key : String) = findOption('key -> key)
    
    def authenticate(email: String, password: String): Option[User] = findOption('key -> hash(email.toLowerCase() + password))
    
    def setPublicProfile(id : Long, isPublic : Boolean) = {
        update(id, 'is_public -> isPublic)
    }
    
    def create(email: String, password: String, pseudo: String, isAdmin : Boolean = false) : Long = {
        createEntry('email -> email, 'pseudo -> pseudo, 'is_admin -> isAdmin, 'key -> hash(email + password), 
                'is_public -> false, 'api_key -> "")
    }
}
