package models

import java.util.Date
import anorm._
import anorm.SqlParser._
import play.api.Play.current
import play.api.db._
import models.renorm.OrderBy
import models.renorm.Table

case class IdeaVote(ideaId: Long, userId : Long)

object IdeaVote extends Table[IdeaVote] {
    override val idColumn = ""
    def create(ideaId: Long, userId : Long) = {
        if(countWhere('idea_id -> ideaId, 'user_id -> userId) == 0) {
            createEntry('idea_id -> ideaId, 'user_id -> userId)
        }
    }
    
    def byUser(userId : Long) : Set[Long] = {
        find('user_id -> userId).map(_.ideaId).toSet
    }
}