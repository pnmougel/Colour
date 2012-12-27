// @SOURCE:/home/nico/Dropbox/workspace_scala/Confer/conf/routes
// @HASH:530c5bb1524a630f4817f4c1f03ad04533ebe7d9
// @DATE:Tue Dec 25 15:13:19 NCT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:7
val controllers_Application_index1 = Route("GET", PathPattern(List(StaticPart("/index"))))
                    

// @LINE:8
val controllers_Application_index2 = Route("GET", PathPattern(List(StaticPart("/home"))))
                    

// @LINE:10
val controllers_Application_test3 = Route("GET", PathPattern(List(StaticPart("/test"))))
                    

// @LINE:14
val controllers_Ranking_byField4 = Route("GET", PathPattern(List(StaticPart("/ranking/field/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:15
val controllers_Ranking_page5 = Route("GET", PathPattern(List(StaticPart("/ranking/page"))))
                    

// @LINE:18
val controllers_StaticPage_widget6 = Route("GET", PathPattern(List(StaticPart("/page/widget"))))
                    

// @LINE:19
val controllers_Help_section7 = Route("GET", PathPattern(List(StaticPart("/help/"),DynamicPart("name", """[^/]+"""))))
                    

// @LINE:22
val controllers_Publication_publication8 = Route("GET", PathPattern(List(StaticPart("/conference/"),DynamicPart("id", """[0-9]+"""))))
                    

// @LINE:23
val controllers_Publication_publicationByName9 = Route("GET", PathPattern(List(StaticPart("/conference/"),DynamicPart("name", """[^/]+"""))))
                    

// @LINE:24
val controllers_Publication_publicationByName10 = Route("GET", PathPattern(List(StaticPart("/conference/name/"),DynamicPart("name", """[^/]+"""))))
                    

// @LINE:25
val controllers_Publication_editPublication11 = Route("GET", PathPattern(List(StaticPart("/conference/edit/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:26
val controllers_Publication_updatePublication12 = Route("POST", PathPattern(List(StaticPart("/conference/update"))))
                    

// @LINE:27
val controllers_Publication_publication13 = Route("GET", PathPattern(List(StaticPart("/journal/"),DynamicPart("id", """[0-9]+"""))))
                    

// @LINE:28
val controllers_Publication_publicationByName14 = Route("GET", PathPattern(List(StaticPart("/journal/"),DynamicPart("name", """[^/]+"""))))
                    

// @LINE:29
val controllers_Publication_editPublication15 = Route("GET", PathPattern(List(StaticPart("/journal/edit/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:30
val controllers_Publication_updatePublication16 = Route("POST", PathPattern(List(StaticPart("/journal/update"))))
                    

// @LINE:31
val controllers_Publication_getHistory17 = Route("GET", PathPattern(List(StaticPart("/history/"),DynamicPart("action", """[^/]+"""),StaticPart("/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:33
val controllers_Search_json18 = Route("GET", PathPattern(List(StaticPart("/search/json"))))
                    

// @LINE:35
val controllers_Publication_addPublication19 = Route("POST", PathPattern(List(StaticPart("/addConf"))))
                    

// @LINE:36
val controllers_Search_search20 = Route("GET", PathPattern(List(StaticPart("/search"))))
                    

// @LINE:39
val controllers_conference_Links_addLink21 = Route("POST", PathPattern(List(StaticPart("/link"))))
                    

// @LINE:40
val controllers_conference_Links_deleteLink22 = Route("DELETE", PathPattern(List(StaticPart("/link/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:43
val controllers_User_login23 = Route("POST", PathPattern(List(StaticPart("/user/login"))))
                    

// @LINE:44
val controllers_User_add24 = Route("POST", PathPattern(List(StaticPart("/user/add"))))
                    

// @LINE:45
val controllers_User_logout25 = Route("GET", PathPattern(List(StaticPart("/user/logout"))))
                    

// @LINE:48
val controllers_IdeaBox_index26 = Route("GET", PathPattern(List(StaticPart("/ideabox"))))
                    

// @LINE:49
val controllers_IdeaBox_addIdea27 = Route("POST", PathPattern(List(StaticPart("/ideabox/add"))))
                    

// @LINE:50
val controllers_IdeaBox_vote28 = Route("POST", PathPattern(List(StaticPart("/ideabox/vote/"),DynamicPart("id", """[0-9]+"""))))
                    

// @LINE:53
val controllers_Widgets_getBadge29 = Route("GET", PathPattern(List(StaticPart("/wid/"),DynamicPart("id", """[0-9]+"""))))
                    

// @LINE:54
val controllers_Widgets_getHindex30 = Route("GET", PathPattern(List(StaticPart("/wid/"),DynamicPart("id", """[0-9]+"""),StaticPart("/hindex"))))
                    

// @LINE:58
val controllers_conference_Comments_addComment31 = Route("POST", PathPattern(List(StaticPart("/comment"))))
                    

// @LINE:59
val controllers_conference_Comments_deleteComment32 = Route("DELETE", PathPattern(List(StaticPart("/comment/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:62
val controllers_conference_Publishers_add33 = Route("POST", PathPattern(List(StaticPart("/publisher"))))
                    

// @LINE:63
val controllers_conference_Publishers_delete34 = Route("DELETE", PathPattern(List(StaticPart("/publisher/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:66
val controllers_conference_Scores_addVote35 = Route("POST", PathPattern(List(StaticPart("/vote"))))
                    

// @LINE:67
val controllers_conference_Scores_deleteVote36 = Route("DELETE", PathPattern(List(StaticPart("/vote"))))
                    

// @LINE:70
val controllers_admin_Admin_index37 = Route("GET", PathPattern(List(StaticPart("/admin"))))
                    

// @LINE:71
val controllers_admin_Init_index38 = Route("GET", PathPattern(List(StaticPart("/admin/init"))))
                    

// @LINE:72
val controllers_admin_Admin_selectAction39 = Route("GET", PathPattern(List(StaticPart("/admin/action/"),DynamicPart("name", """[^/]+"""))))
                    

// @LINE:73
val controllers_admin_ClientCommunication_getPercentage40 = Route("GET", PathPattern(List(StaticPart("/admin/action/percentage/"),DynamicPart("name", """[^/]+"""))))
                    

// @LINE:74
val controllers_admin_ClientCommunication_getMessage41 = Route("GET", PathPattern(List(StaticPart("/admin/action/message/"),DynamicPart("name", """[^/]+"""))))
                    

// @LINE:75
val controllers_admin_Admin_run42 = Route("GET", PathPattern(List(StaticPart("/admin/action/run/"),DynamicPart("actionName", """[^/]+"""))))
                    

// @LINE:76
val controllers_admin_scores_PublicationMatching_sameAsPublication43 = Route("POST", PathPattern(List(StaticPart("/admin/sameAsPublication"))))
                    

// @LINE:77
val controllers_admin_scores_PublicationMatching_createPublication44 = Route("POST", PathPattern(List(StaticPart("/admin/createPublication"))))
                    

// @LINE:80
val controllers_Assets_at45 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index"""),("""GET""","""/index""","""controllers.Application.index"""),("""GET""","""/home""","""controllers.Application.index"""),("""GET""","""/test""","""controllers.Application.test"""),("""GET""","""/ranking/field/$id<[^/]+>""","""controllers.Ranking.byField(id:Long)"""),("""GET""","""/ranking/page""","""controllers.Ranking.page"""),("""GET""","""/page/widget""","""controllers.StaticPage.widget"""),("""GET""","""/help/$name<[^/]+>""","""controllers.Help.section(name:String)"""),("""GET""","""/conference/$id<[0-9]+>""","""controllers.Publication.publication(id:Long)"""),("""GET""","""/conference/$name<[^/]+>""","""controllers.Publication.publicationByName(name:String)"""),("""GET""","""/conference/name/$name<[^/]+>""","""controllers.Publication.publicationByName(name:String)"""),("""GET""","""/conference/edit/$id<[^/]+>""","""controllers.Publication.editPublication(id:Long)"""),("""POST""","""/conference/update""","""controllers.Publication.updatePublication"""),("""GET""","""/journal/$id<[0-9]+>""","""controllers.Publication.publication(id:Long)"""),("""GET""","""/journal/$name<[^/]+>""","""controllers.Publication.publicationByName(name:String)"""),("""GET""","""/journal/edit/$id<[^/]+>""","""controllers.Publication.editPublication(id:Long)"""),("""POST""","""/journal/update""","""controllers.Publication.updatePublication"""),("""GET""","""/history/$action<[^/]+>/$id<[^/]+>""","""controllers.Publication.getHistory(action:String, id:Long)"""),("""GET""","""/search/json""","""controllers.Search.json"""),("""POST""","""/addConf""","""controllers.Publication.addPublication()"""),("""GET""","""/search""","""controllers.Search.search()"""),("""POST""","""/link""","""controllers.conference.Links.addLink()"""),("""DELETE""","""/link/$id<[^/]+>""","""controllers.conference.Links.deleteLink(id:Long)"""),("""POST""","""/user/login""","""controllers.User.login"""),("""POST""","""/user/add""","""controllers.User.add"""),("""GET""","""/user/logout""","""controllers.User.logout"""),("""GET""","""/ideabox""","""controllers.IdeaBox.index"""),("""POST""","""/ideabox/add""","""controllers.IdeaBox.addIdea"""),("""POST""","""/ideabox/vote/$id<[0-9]+>""","""controllers.IdeaBox.vote(id:Long)"""),("""GET""","""/wid/$id<[0-9]+>""","""controllers.Widgets.getBadge(id:Int)"""),("""GET""","""/wid/$id<[0-9]+>/hindex""","""controllers.Widgets.getHindex(id:Int)"""),("""POST""","""/comment""","""controllers.conference.Comments.addComment()"""),("""DELETE""","""/comment/$id<[^/]+>""","""controllers.conference.Comments.deleteComment(id:Long)"""),("""POST""","""/publisher""","""controllers.conference.Publishers.add()"""),("""DELETE""","""/publisher/$id<[^/]+>""","""controllers.conference.Publishers.delete(id:Long)"""),("""POST""","""/vote""","""controllers.conference.Scores.addVote()"""),("""DELETE""","""/vote""","""controllers.conference.Scores.deleteVote()"""),("""GET""","""/admin""","""controllers.admin.Admin.index"""),("""GET""","""/admin/init""","""controllers.admin.Init.index()"""),("""GET""","""/admin/action/$name<[^/]+>""","""controllers.admin.Admin.selectAction(name:String)"""),("""GET""","""/admin/action/percentage/$name<[^/]+>""","""controllers.admin.ClientCommunication.getPercentage(name:String)"""),("""GET""","""/admin/action/message/$name<[^/]+>""","""controllers.admin.ClientCommunication.getMessage(name:String)"""),("""GET""","""/admin/action/run/$actionName<[^/]+>""","""controllers.admin.Admin.run(actionName:String)"""),("""POST""","""/admin/sameAsPublication""","""controllers.admin.scores.PublicationMatching.sameAsPublication"""),("""POST""","""/admin/createPublication""","""controllers.admin.scores.PublicationMatching.createPublication"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:7
case controllers_Application_index1(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:8
case controllers_Application_index2(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:10
case controllers_Application_test3(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.test, HandlerDef(this, "controllers.Application", "test", Nil))
   }
}
                    

// @LINE:14
case controllers_Ranking_byField4(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Ranking.byField(id), HandlerDef(this, "controllers.Ranking", "byField", Seq(classOf[Long])))
   }
}
                    

// @LINE:15
case controllers_Ranking_page5(params) => {
   call { 
        invokeHandler(_root_.controllers.Ranking.page, HandlerDef(this, "controllers.Ranking", "page", Nil))
   }
}
                    

// @LINE:18
case controllers_StaticPage_widget6(params) => {
   call { 
        invokeHandler(_root_.controllers.StaticPage.widget, HandlerDef(this, "controllers.StaticPage", "widget", Nil))
   }
}
                    

// @LINE:19
case controllers_Help_section7(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(_root_.controllers.Help.section(name), HandlerDef(this, "controllers.Help", "section", Seq(classOf[String])))
   }
}
                    

// @LINE:22
case controllers_Publication_publication8(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Publication.publication(id), HandlerDef(this, "controllers.Publication", "publication", Seq(classOf[Long])))
   }
}
                    

// @LINE:23
case controllers_Publication_publicationByName9(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(_root_.controllers.Publication.publicationByName(name), HandlerDef(this, "controllers.Publication", "publicationByName", Seq(classOf[String])))
   }
}
                    

// @LINE:24
case controllers_Publication_publicationByName10(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(_root_.controllers.Publication.publicationByName(name), HandlerDef(this, "controllers.Publication", "publicationByName", Seq(classOf[String])))
   }
}
                    

// @LINE:25
case controllers_Publication_editPublication11(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Publication.editPublication(id), HandlerDef(this, "controllers.Publication", "editPublication", Seq(classOf[Long])))
   }
}
                    

// @LINE:26
case controllers_Publication_updatePublication12(params) => {
   call { 
        invokeHandler(_root_.controllers.Publication.updatePublication, HandlerDef(this, "controllers.Publication", "updatePublication", Nil))
   }
}
                    

// @LINE:27
case controllers_Publication_publication13(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Publication.publication(id), HandlerDef(this, "controllers.Publication", "publication", Seq(classOf[Long])))
   }
}
                    

// @LINE:28
case controllers_Publication_publicationByName14(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(_root_.controllers.Publication.publicationByName(name), HandlerDef(this, "controllers.Publication", "publicationByName", Seq(classOf[String])))
   }
}
                    

// @LINE:29
case controllers_Publication_editPublication15(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Publication.editPublication(id), HandlerDef(this, "controllers.Publication", "editPublication", Seq(classOf[Long])))
   }
}
                    

// @LINE:30
case controllers_Publication_updatePublication16(params) => {
   call { 
        invokeHandler(_root_.controllers.Publication.updatePublication, HandlerDef(this, "controllers.Publication", "updatePublication", Nil))
   }
}
                    

// @LINE:31
case controllers_Publication_getHistory17(params) => {
   call(params.fromPath[String]("action", None), params.fromPath[Long]("id", None)) { (action, id) =>
        invokeHandler(_root_.controllers.Publication.getHistory(action, id), HandlerDef(this, "controllers.Publication", "getHistory", Seq(classOf[String], classOf[Long])))
   }
}
                    

// @LINE:33
case controllers_Search_json18(params) => {
   call { 
        invokeHandler(_root_.controllers.Search.json, HandlerDef(this, "controllers.Search", "json", Nil))
   }
}
                    

// @LINE:35
case controllers_Publication_addPublication19(params) => {
   call { 
        invokeHandler(_root_.controllers.Publication.addPublication(), HandlerDef(this, "controllers.Publication", "addPublication", Nil))
   }
}
                    

// @LINE:36
case controllers_Search_search20(params) => {
   call { 
        invokeHandler(_root_.controllers.Search.search(), HandlerDef(this, "controllers.Search", "search", Nil))
   }
}
                    

// @LINE:39
case controllers_conference_Links_addLink21(params) => {
   call { 
        invokeHandler(_root_.controllers.conference.Links.addLink(), HandlerDef(this, "controllers.conference.Links", "addLink", Nil))
   }
}
                    

// @LINE:40
case controllers_conference_Links_deleteLink22(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.conference.Links.deleteLink(id), HandlerDef(this, "controllers.conference.Links", "deleteLink", Seq(classOf[Long])))
   }
}
                    

// @LINE:43
case controllers_User_login23(params) => {
   call { 
        invokeHandler(_root_.controllers.User.login, HandlerDef(this, "controllers.User", "login", Nil))
   }
}
                    

// @LINE:44
case controllers_User_add24(params) => {
   call { 
        invokeHandler(_root_.controllers.User.add, HandlerDef(this, "controllers.User", "add", Nil))
   }
}
                    

// @LINE:45
case controllers_User_logout25(params) => {
   call { 
        invokeHandler(_root_.controllers.User.logout, HandlerDef(this, "controllers.User", "logout", Nil))
   }
}
                    

// @LINE:48
case controllers_IdeaBox_index26(params) => {
   call { 
        invokeHandler(_root_.controllers.IdeaBox.index, HandlerDef(this, "controllers.IdeaBox", "index", Nil))
   }
}
                    

// @LINE:49
case controllers_IdeaBox_addIdea27(params) => {
   call { 
        invokeHandler(_root_.controllers.IdeaBox.addIdea, HandlerDef(this, "controllers.IdeaBox", "addIdea", Nil))
   }
}
                    

// @LINE:50
case controllers_IdeaBox_vote28(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.IdeaBox.vote(id), HandlerDef(this, "controllers.IdeaBox", "vote", Seq(classOf[Long])))
   }
}
                    

// @LINE:53
case controllers_Widgets_getBadge29(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Widgets.getBadge(id), HandlerDef(this, "controllers.Widgets", "getBadge", Seq(classOf[Int])))
   }
}
                    

// @LINE:54
case controllers_Widgets_getHindex30(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Widgets.getHindex(id), HandlerDef(this, "controllers.Widgets", "getHindex", Seq(classOf[Int])))
   }
}
                    

// @LINE:58
case controllers_conference_Comments_addComment31(params) => {
   call { 
        invokeHandler(_root_.controllers.conference.Comments.addComment(), HandlerDef(this, "controllers.conference.Comments", "addComment", Nil))
   }
}
                    

// @LINE:59
case controllers_conference_Comments_deleteComment32(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.conference.Comments.deleteComment(id), HandlerDef(this, "controllers.conference.Comments", "deleteComment", Seq(classOf[Long])))
   }
}
                    

// @LINE:62
case controllers_conference_Publishers_add33(params) => {
   call { 
        invokeHandler(_root_.controllers.conference.Publishers.add(), HandlerDef(this, "controllers.conference.Publishers", "add", Nil))
   }
}
                    

// @LINE:63
case controllers_conference_Publishers_delete34(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.conference.Publishers.delete(id), HandlerDef(this, "controllers.conference.Publishers", "delete", Seq(classOf[Long])))
   }
}
                    

// @LINE:66
case controllers_conference_Scores_addVote35(params) => {
   call { 
        invokeHandler(_root_.controllers.conference.Scores.addVote(), HandlerDef(this, "controllers.conference.Scores", "addVote", Nil))
   }
}
                    

// @LINE:67
case controllers_conference_Scores_deleteVote36(params) => {
   call { 
        invokeHandler(_root_.controllers.conference.Scores.deleteVote(), HandlerDef(this, "controllers.conference.Scores", "deleteVote", Nil))
   }
}
                    

// @LINE:70
case controllers_admin_Admin_index37(params) => {
   call { 
        invokeHandler(_root_.controllers.admin.Admin.index, HandlerDef(this, "controllers.admin.Admin", "index", Nil))
   }
}
                    

// @LINE:71
case controllers_admin_Init_index38(params) => {
   call { 
        invokeHandler(_root_.controllers.admin.Init.index(), HandlerDef(this, "controllers.admin.Init", "index", Nil))
   }
}
                    

// @LINE:72
case controllers_admin_Admin_selectAction39(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(_root_.controllers.admin.Admin.selectAction(name), HandlerDef(this, "controllers.admin.Admin", "selectAction", Seq(classOf[String])))
   }
}
                    

// @LINE:73
case controllers_admin_ClientCommunication_getPercentage40(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(_root_.controllers.admin.ClientCommunication.getPercentage(name), HandlerDef(this, "controllers.admin.ClientCommunication", "getPercentage", Seq(classOf[String])))
   }
}
                    

// @LINE:74
case controllers_admin_ClientCommunication_getMessage41(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(_root_.controllers.admin.ClientCommunication.getMessage(name), HandlerDef(this, "controllers.admin.ClientCommunication", "getMessage", Seq(classOf[String])))
   }
}
                    

// @LINE:75
case controllers_admin_Admin_run42(params) => {
   call(params.fromPath[String]("actionName", None)) { (actionName) =>
        invokeHandler(_root_.controllers.admin.Admin.run(actionName), HandlerDef(this, "controllers.admin.Admin", "run", Seq(classOf[String])))
   }
}
                    

// @LINE:76
case controllers_admin_scores_PublicationMatching_sameAsPublication43(params) => {
   call { 
        invokeHandler(_root_.controllers.admin.scores.PublicationMatching.sameAsPublication, HandlerDef(this, "controllers.admin.scores.PublicationMatching", "sameAsPublication", Nil))
   }
}
                    

// @LINE:77
case controllers_admin_scores_PublicationMatching_createPublication44(params) => {
   call { 
        invokeHandler(_root_.controllers.admin.scores.PublicationMatching.createPublication, HandlerDef(this, "controllers.admin.scores.PublicationMatching", "createPublication", Nil))
   }
}
                    

// @LINE:80
case controllers_Assets_at45(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                