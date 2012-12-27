// @SOURCE:/home/nico/Dropbox/workspace_scala/Confer/conf/routes
// @HASH:530c5bb1524a630f4817f4c1f03ad04533ebe7d9
// @DATE:Tue Dec 25 15:13:19 NCT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
package controllers.admin {

// @LINE:71
class ReverseInit {
    


 
// @LINE:71
def index() = {
   Call("GET", "/admin/init")
}
                                                        

                      
    
}
                            

// @LINE:75
// @LINE:72
// @LINE:70
class ReverseAdmin {
    


 
// @LINE:75
def run(actionName:String) = {
   Call("GET", "/admin/action/run/" + implicitly[PathBindable[String]].unbind("actionName", actionName))
}
                                                        
 
// @LINE:72
def selectAction(name:String) = {
   Call("GET", "/admin/action/" + implicitly[PathBindable[String]].unbind("name", name))
}
                                                        
 
// @LINE:70
def index() = {
   Call("GET", "/admin")
}
                                                        

                      
    
}
                            

// @LINE:74
// @LINE:73
class ReverseClientCommunication {
    


 
// @LINE:73
def getPercentage(name:String) = {
   Call("GET", "/admin/action/percentage/" + implicitly[PathBindable[String]].unbind("name", name))
}
                                                        
 
// @LINE:74
def getMessage(name:String) = {
   Call("GET", "/admin/action/message/" + implicitly[PathBindable[String]].unbind("name", name))
}
                                                        

                      
    
}
                            
}
                    

// @LINE:77
// @LINE:76
package controllers.admin.scores {

// @LINE:77
// @LINE:76
class ReversePublicationMatching {
    


 
// @LINE:76
def sameAsPublication() = {
   Call("POST", "/admin/sameAsPublication")
}
                                                        
 
// @LINE:77
def createPublication() = {
   Call("POST", "/admin/createPublication")
}
                                                        

                      
    
}
                            
}
                    

// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:62
// @LINE:59
// @LINE:58
// @LINE:40
// @LINE:39
package controllers.conference {

// @LINE:40
// @LINE:39
class ReverseLinks {
    


 
// @LINE:39
def addLink() = {
   Call("POST", "/link")
}
                                                        
 
// @LINE:40
def deleteLink(id:Long) = {
   Call("DELETE", "/link/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:63
// @LINE:62
class ReversePublishers {
    


 
// @LINE:62
def add() = {
   Call("POST", "/publisher")
}
                                                        
 
// @LINE:63
def delete(id:Long) = {
   Call("DELETE", "/publisher/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:67
// @LINE:66
class ReverseScores {
    


 
// @LINE:67
def deleteVote() = {
   Call("DELETE", "/vote")
}
                                                        
 
// @LINE:66
def addVote() = {
   Call("POST", "/vote")
}
                                                        

                      
    
}
                            

// @LINE:59
// @LINE:58
class ReverseComments {
    


 
// @LINE:58
def addComment() = {
   Call("POST", "/comment")
}
                                                        
 
// @LINE:59
def deleteComment(id:Long) = {
   Call("DELETE", "/comment/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            
}
                    

// @LINE:80
// @LINE:54
// @LINE:53
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:80
class ReverseAssets {
    


 
// @LINE:80
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            

// @LINE:54
// @LINE:53
class ReverseWidgets {
    


 
// @LINE:53
def getBadge(id:Int) = {
   Call("GET", "/wid/" + implicitly[PathBindable[Int]].unbind("id", id))
}
                                                        
 
// @LINE:54
def getHindex(id:Int) = {
   Call("GET", "/wid/" + implicitly[PathBindable[Int]].unbind("id", id) + "/hindex")
}
                                                        

                      
    
}
                            

// @LINE:35
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReversePublication {
    


 
// @LINE:28
// @LINE:24
// @LINE:23
def publicationByName(name:String) = {
   (name) match {
// @LINE:23
case (name) if true => Call("GET", "/conference/" + implicitly[PathBindable[String]].unbind("name", name))
                                                                
// @LINE:24
case (name) if true => Call("GET", "/conference/name/" + implicitly[PathBindable[String]].unbind("name", name))
                                                                
// @LINE:28
case (name) if true => Call("GET", "/journal/" + implicitly[PathBindable[String]].unbind("name", name))
                                                                    
   }
}
                                                        
 
// @LINE:27
// @LINE:22
def publication(id:Long) = {
   (id) match {
// @LINE:22
case (id) if true => Call("GET", "/conference/" + implicitly[PathBindable[Long]].unbind("id", id))
                                                                
// @LINE:27
case (id) if true => Call("GET", "/journal/" + implicitly[PathBindable[Long]].unbind("id", id))
                                                                    
   }
}
                                                        
 
// @LINE:29
// @LINE:25
def editPublication(id:Long) = {
   (id) match {
// @LINE:25
case (id) if true => Call("GET", "/conference/edit/" + implicitly[PathBindable[Long]].unbind("id", id))
                                                                
// @LINE:29
case (id) if true => Call("GET", "/journal/edit/" + implicitly[PathBindable[Long]].unbind("id", id))
                                                                    
   }
}
                                                        
 
// @LINE:31
def getHistory(action:String, id:Long) = {
   Call("GET", "/history/" + implicitly[PathBindable[String]].unbind("action", action) + "/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:35
def addPublication() = {
   Call("POST", "/addConf")
}
                                                        
 
// @LINE:30
// @LINE:26
def updatePublication() = {
   () match {
// @LINE:26
case () if true => Call("POST", "/conference/update")
                                                                
// @LINE:30
case () if true => Call("POST", "/journal/update")
                                                                    
   }
}
                                                        

                      
    
}
                            

// @LINE:18
class ReverseStaticPage {
    


 
// @LINE:18
def widget() = {
   Call("GET", "/page/widget")
}
                                                        

                      
    
}
                            

// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:10
def test() = {
   Call("GET", "/test")
}
                                                        
 
// @LINE:8
// @LINE:7
// @LINE:6
def index() = {
   () match {
// @LINE:6
case () if true => Call("GET", "/")
                                                                
// @LINE:7
case () if true => Call("GET", "/index")
                                                                
// @LINE:8
case () if true => Call("GET", "/home")
                                                                    
   }
}
                                                        

                      
    
}
                            

// @LINE:45
// @LINE:44
// @LINE:43
class ReverseUser {
    


 
// @LINE:45
def logout() = {
   Call("GET", "/user/logout")
}
                                                        
 
// @LINE:44
def add() = {
   Call("POST", "/user/add")
}
                                                        
 
// @LINE:43
def login() = {
   Call("POST", "/user/login")
}
                                                        

                      
    
}
                            

// @LINE:15
// @LINE:14
class ReverseRanking {
    


 
// @LINE:15
def page() = {
   Call("GET", "/ranking/page")
}
                                                        
 
// @LINE:14
def byField(id:Long) = {
   Call("GET", "/ranking/field/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:36
// @LINE:33
class ReverseSearch {
    


 
// @LINE:36
def search() = {
   Call("GET", "/search")
}
                                                        
 
// @LINE:33
def json() = {
   Call("GET", "/search/json")
}
                                                        

                      
    
}
                            

// @LINE:19
class ReverseHelp {
    


 
// @LINE:19
def section(name:String) = {
   Call("GET", "/help/" + implicitly[PathBindable[String]].unbind("name", name))
}
                                                        

                      
    
}
                            

// @LINE:50
// @LINE:49
// @LINE:48
class ReverseIdeaBox {
    


 
// @LINE:49
def addIdea() = {
   Call("POST", "/ideabox/add")
}
                                                        
 
// @LINE:50
def vote(id:Long) = {
   Call("POST", "/ideabox/vote/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:48
def index() = {
   Call("GET", "/ideabox")
}
                                                        

                      
    
}
                            
}
                    


// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
package controllers.admin.javascript {

// @LINE:71
class ReverseInit {
    


 
// @LINE:71
def index = JavascriptReverseRoute(
   "controllers.admin.Init.index",
   """
      function() {
      return _wA({method:"GET", url:"/admin/init"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:75
// @LINE:72
// @LINE:70
class ReverseAdmin {
    


 
// @LINE:75
def run = JavascriptReverseRoute(
   "controllers.admin.Admin.run",
   """
      function(actionName) {
      return _wA({method:"GET", url:"/admin/action/run/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("actionName", actionName)})
      }
   """
)
                                                        
 
// @LINE:72
def selectAction = JavascriptReverseRoute(
   "controllers.admin.Admin.selectAction",
   """
      function(name) {
      return _wA({method:"GET", url:"/admin/action/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", name)})
      }
   """
)
                                                        
 
// @LINE:70
def index = JavascriptReverseRoute(
   "controllers.admin.Admin.index",
   """
      function() {
      return _wA({method:"GET", url:"/admin"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:74
// @LINE:73
class ReverseClientCommunication {
    


 
// @LINE:73
def getPercentage = JavascriptReverseRoute(
   "controllers.admin.ClientCommunication.getPercentage",
   """
      function(name) {
      return _wA({method:"GET", url:"/admin/action/percentage/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", name)})
      }
   """
)
                                                        
 
// @LINE:74
def getMessage = JavascriptReverseRoute(
   "controllers.admin.ClientCommunication.getMessage",
   """
      function(name) {
      return _wA({method:"GET", url:"/admin/action/message/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", name)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    

// @LINE:77
// @LINE:76
package controllers.admin.scores.javascript {

// @LINE:77
// @LINE:76
class ReversePublicationMatching {
    


 
// @LINE:76
def sameAsPublication = JavascriptReverseRoute(
   "controllers.admin.scores.PublicationMatching.sameAsPublication",
   """
      function() {
      return _wA({method:"POST", url:"/admin/sameAsPublication"})
      }
   """
)
                                                        
 
// @LINE:77
def createPublication = JavascriptReverseRoute(
   "controllers.admin.scores.PublicationMatching.createPublication",
   """
      function() {
      return _wA({method:"POST", url:"/admin/createPublication"})
      }
   """
)
                                                        

                      
    
}
                            
}
                    

// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:62
// @LINE:59
// @LINE:58
// @LINE:40
// @LINE:39
package controllers.conference.javascript {

// @LINE:40
// @LINE:39
class ReverseLinks {
    


 
// @LINE:39
def addLink = JavascriptReverseRoute(
   "controllers.conference.Links.addLink",
   """
      function() {
      return _wA({method:"POST", url:"/link"})
      }
   """
)
                                                        
 
// @LINE:40
def deleteLink = JavascriptReverseRoute(
   "controllers.conference.Links.deleteLink",
   """
      function(id) {
      return _wA({method:"DELETE", url:"/link/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:63
// @LINE:62
class ReversePublishers {
    


 
// @LINE:62
def add = JavascriptReverseRoute(
   "controllers.conference.Publishers.add",
   """
      function() {
      return _wA({method:"POST", url:"/publisher"})
      }
   """
)
                                                        
 
// @LINE:63
def delete = JavascriptReverseRoute(
   "controllers.conference.Publishers.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"/publisher/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:67
// @LINE:66
class ReverseScores {
    


 
// @LINE:67
def deleteVote = JavascriptReverseRoute(
   "controllers.conference.Scores.deleteVote",
   """
      function() {
      return _wA({method:"DELETE", url:"/vote"})
      }
   """
)
                                                        
 
// @LINE:66
def addVote = JavascriptReverseRoute(
   "controllers.conference.Scores.addVote",
   """
      function() {
      return _wA({method:"POST", url:"/vote"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:59
// @LINE:58
class ReverseComments {
    


 
// @LINE:58
def addComment = JavascriptReverseRoute(
   "controllers.conference.Comments.addComment",
   """
      function() {
      return _wA({method:"POST", url:"/comment"})
      }
   """
)
                                                        
 
// @LINE:59
def deleteComment = JavascriptReverseRoute(
   "controllers.conference.Comments.deleteComment",
   """
      function(id) {
      return _wA({method:"DELETE", url:"/comment/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    

// @LINE:80
// @LINE:54
// @LINE:53
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:80
class ReverseAssets {
    


 
// @LINE:80
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:54
// @LINE:53
class ReverseWidgets {
    


 
// @LINE:53
def getBadge = JavascriptReverseRoute(
   "controllers.Widgets.getBadge",
   """
      function(id) {
      return _wA({method:"GET", url:"/wid/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:54
def getHindex = JavascriptReverseRoute(
   "controllers.Widgets.getHindex",
   """
      function(id) {
      return _wA({method:"GET", url:"/wid/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id) + "/hindex"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:35
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReversePublication {
    


 
// @LINE:28
// @LINE:24
// @LINE:23
def publicationByName = JavascriptReverseRoute(
   "controllers.Publication.publicationByName",
   """
      function(name) {
      if (true) {
      return _wA({method:"GET", url:"/conference/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", name)})
      }
      if (true) {
      return _wA({method:"GET", url:"/conference/name/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", name)})
      }
      if (true) {
      return _wA({method:"GET", url:"/journal/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", name)})
      }
      }
   """
)
                                                        
 
// @LINE:27
// @LINE:22
def publication = JavascriptReverseRoute(
   "controllers.Publication.publication",
   """
      function(id) {
      if (true) {
      return _wA({method:"GET", url:"/conference/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
      if (true) {
      return _wA({method:"GET", url:"/journal/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
      }
   """
)
                                                        
 
// @LINE:29
// @LINE:25
def editPublication = JavascriptReverseRoute(
   "controllers.Publication.editPublication",
   """
      function(id) {
      if (true) {
      return _wA({method:"GET", url:"/conference/edit/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
      if (true) {
      return _wA({method:"GET", url:"/journal/edit/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
      }
   """
)
                                                        
 
// @LINE:31
def getHistory = JavascriptReverseRoute(
   "controllers.Publication.getHistory",
   """
      function(action,id) {
      return _wA({method:"GET", url:"/history/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("action", action) + "/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:35
def addPublication = JavascriptReverseRoute(
   "controllers.Publication.addPublication",
   """
      function() {
      return _wA({method:"POST", url:"/addConf"})
      }
   """
)
                                                        
 
// @LINE:30
// @LINE:26
def updatePublication = JavascriptReverseRoute(
   "controllers.Publication.updatePublication",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"/conference/update"})
      }
      if (true) {
      return _wA({method:"POST", url:"/journal/update"})
      }
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:18
class ReverseStaticPage {
    


 
// @LINE:18
def widget = JavascriptReverseRoute(
   "controllers.StaticPage.widget",
   """
      function() {
      return _wA({method:"GET", url:"/page/widget"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:10
def test = JavascriptReverseRoute(
   "controllers.Application.test",
   """
      function() {
      return _wA({method:"GET", url:"/test"})
      }
   """
)
                                                        
 
// @LINE:8
// @LINE:7
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"/"})
      }
      if (true) {
      return _wA({method:"GET", url:"/index"})
      }
      if (true) {
      return _wA({method:"GET", url:"/home"})
      }
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:45
// @LINE:44
// @LINE:43
class ReverseUser {
    


 
// @LINE:45
def logout = JavascriptReverseRoute(
   "controllers.User.logout",
   """
      function() {
      return _wA({method:"GET", url:"/user/logout"})
      }
   """
)
                                                        
 
// @LINE:44
def add = JavascriptReverseRoute(
   "controllers.User.add",
   """
      function() {
      return _wA({method:"POST", url:"/user/add"})
      }
   """
)
                                                        
 
// @LINE:43
def login = JavascriptReverseRoute(
   "controllers.User.login",
   """
      function() {
      return _wA({method:"POST", url:"/user/login"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:15
// @LINE:14
class ReverseRanking {
    


 
// @LINE:15
def page = JavascriptReverseRoute(
   "controllers.Ranking.page",
   """
      function() {
      return _wA({method:"GET", url:"/ranking/page"})
      }
   """
)
                                                        
 
// @LINE:14
def byField = JavascriptReverseRoute(
   "controllers.Ranking.byField",
   """
      function(id) {
      return _wA({method:"GET", url:"/ranking/field/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:36
// @LINE:33
class ReverseSearch {
    


 
// @LINE:36
def search = JavascriptReverseRoute(
   "controllers.Search.search",
   """
      function() {
      return _wA({method:"GET", url:"/search"})
      }
   """
)
                                                        
 
// @LINE:33
def json = JavascriptReverseRoute(
   "controllers.Search.json",
   """
      function() {
      return _wA({method:"GET", url:"/search/json"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:19
class ReverseHelp {
    


 
// @LINE:19
def section = JavascriptReverseRoute(
   "controllers.Help.section",
   """
      function(name) {
      return _wA({method:"GET", url:"/help/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", name)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:50
// @LINE:49
// @LINE:48
class ReverseIdeaBox {
    


 
// @LINE:49
def addIdea = JavascriptReverseRoute(
   "controllers.IdeaBox.addIdea",
   """
      function() {
      return _wA({method:"POST", url:"/ideabox/add"})
      }
   """
)
                                                        
 
// @LINE:50
def vote = JavascriptReverseRoute(
   "controllers.IdeaBox.vote",
   """
      function(id) {
      return _wA({method:"POST", url:"/ideabox/vote/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:48
def index = JavascriptReverseRoute(
   "controllers.IdeaBox.index",
   """
      function() {
      return _wA({method:"GET", url:"/ideabox"})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
package controllers.admin.ref {

// @LINE:71
class ReverseInit {
    


 
// @LINE:71
def index() = new play.api.mvc.HandlerRef(
   controllers.admin.Init.index(), HandlerDef(this, "controllers.admin.Init", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:75
// @LINE:72
// @LINE:70
class ReverseAdmin {
    


 
// @LINE:75
def run(actionName:String) = new play.api.mvc.HandlerRef(
   controllers.admin.Admin.run(actionName), HandlerDef(this, "controllers.admin.Admin", "run", Seq(classOf[String]))
)
                              
 
// @LINE:72
def selectAction(name:String) = new play.api.mvc.HandlerRef(
   controllers.admin.Admin.selectAction(name), HandlerDef(this, "controllers.admin.Admin", "selectAction", Seq(classOf[String]))
)
                              
 
// @LINE:70
def index() = new play.api.mvc.HandlerRef(
   controllers.admin.Admin.index(), HandlerDef(this, "controllers.admin.Admin", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:74
// @LINE:73
class ReverseClientCommunication {
    


 
// @LINE:73
def getPercentage(name:String) = new play.api.mvc.HandlerRef(
   controllers.admin.ClientCommunication.getPercentage(name), HandlerDef(this, "controllers.admin.ClientCommunication", "getPercentage", Seq(classOf[String]))
)
                              
 
// @LINE:74
def getMessage(name:String) = new play.api.mvc.HandlerRef(
   controllers.admin.ClientCommunication.getMessage(name), HandlerDef(this, "controllers.admin.ClientCommunication", "getMessage", Seq(classOf[String]))
)
                              

                      
    
}
                            
}
                    

// @LINE:77
// @LINE:76
package controllers.admin.scores.ref {

// @LINE:77
// @LINE:76
class ReversePublicationMatching {
    


 
// @LINE:76
def sameAsPublication() = new play.api.mvc.HandlerRef(
   controllers.admin.scores.PublicationMatching.sameAsPublication(), HandlerDef(this, "controllers.admin.scores.PublicationMatching", "sameAsPublication", Seq())
)
                              
 
// @LINE:77
def createPublication() = new play.api.mvc.HandlerRef(
   controllers.admin.scores.PublicationMatching.createPublication(), HandlerDef(this, "controllers.admin.scores.PublicationMatching", "createPublication", Seq())
)
                              

                      
    
}
                            
}
                    

// @LINE:67
// @LINE:66
// @LINE:63
// @LINE:62
// @LINE:59
// @LINE:58
// @LINE:40
// @LINE:39
package controllers.conference.ref {

// @LINE:40
// @LINE:39
class ReverseLinks {
    


 
// @LINE:39
def addLink() = new play.api.mvc.HandlerRef(
   controllers.conference.Links.addLink(), HandlerDef(this, "controllers.conference.Links", "addLink", Seq())
)
                              
 
// @LINE:40
def deleteLink(id:Long) = new play.api.mvc.HandlerRef(
   controllers.conference.Links.deleteLink(id), HandlerDef(this, "controllers.conference.Links", "deleteLink", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:63
// @LINE:62
class ReversePublishers {
    


 
// @LINE:62
def add() = new play.api.mvc.HandlerRef(
   controllers.conference.Publishers.add(), HandlerDef(this, "controllers.conference.Publishers", "add", Seq())
)
                              
 
// @LINE:63
def delete(id:Long) = new play.api.mvc.HandlerRef(
   controllers.conference.Publishers.delete(id), HandlerDef(this, "controllers.conference.Publishers", "delete", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:67
// @LINE:66
class ReverseScores {
    


 
// @LINE:67
def deleteVote() = new play.api.mvc.HandlerRef(
   controllers.conference.Scores.deleteVote(), HandlerDef(this, "controllers.conference.Scores", "deleteVote", Seq())
)
                              
 
// @LINE:66
def addVote() = new play.api.mvc.HandlerRef(
   controllers.conference.Scores.addVote(), HandlerDef(this, "controllers.conference.Scores", "addVote", Seq())
)
                              

                      
    
}
                            

// @LINE:59
// @LINE:58
class ReverseComments {
    


 
// @LINE:58
def addComment() = new play.api.mvc.HandlerRef(
   controllers.conference.Comments.addComment(), HandlerDef(this, "controllers.conference.Comments", "addComment", Seq())
)
                              
 
// @LINE:59
def deleteComment(id:Long) = new play.api.mvc.HandlerRef(
   controllers.conference.Comments.deleteComment(id), HandlerDef(this, "controllers.conference.Comments", "deleteComment", Seq(classOf[Long]))
)
                              

                      
    
}
                            
}
                    

// @LINE:80
// @LINE:54
// @LINE:53
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:80
class ReverseAssets {
    


 
// @LINE:80
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:54
// @LINE:53
class ReverseWidgets {
    


 
// @LINE:53
def getBadge(id:Int) = new play.api.mvc.HandlerRef(
   controllers.Widgets.getBadge(id), HandlerDef(this, "controllers.Widgets", "getBadge", Seq(classOf[Int]))
)
                              
 
// @LINE:54
def getHindex(id:Int) = new play.api.mvc.HandlerRef(
   controllers.Widgets.getHindex(id), HandlerDef(this, "controllers.Widgets", "getHindex", Seq(classOf[Int]))
)
                              

                      
    
}
                            

// @LINE:35
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReversePublication {
    


 
// @LINE:23
def publicationByName(name:String) = new play.api.mvc.HandlerRef(
   controllers.Publication.publicationByName(name), HandlerDef(this, "controllers.Publication", "publicationByName", Seq(classOf[String]))
)
                              
 
// @LINE:22
def publication(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Publication.publication(id), HandlerDef(this, "controllers.Publication", "publication", Seq(classOf[Long]))
)
                              
 
// @LINE:25
def editPublication(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Publication.editPublication(id), HandlerDef(this, "controllers.Publication", "editPublication", Seq(classOf[Long]))
)
                              
 
// @LINE:31
def getHistory(action:String, id:Long) = new play.api.mvc.HandlerRef(
   controllers.Publication.getHistory(action, id), HandlerDef(this, "controllers.Publication", "getHistory", Seq(classOf[String], classOf[Long]))
)
                              
 
// @LINE:35
def addPublication() = new play.api.mvc.HandlerRef(
   controllers.Publication.addPublication(), HandlerDef(this, "controllers.Publication", "addPublication", Seq())
)
                              
 
// @LINE:26
def updatePublication() = new play.api.mvc.HandlerRef(
   controllers.Publication.updatePublication(), HandlerDef(this, "controllers.Publication", "updatePublication", Seq())
)
                              

                      
    
}
                            

// @LINE:18
class ReverseStaticPage {
    


 
// @LINE:18
def widget() = new play.api.mvc.HandlerRef(
   controllers.StaticPage.widget(), HandlerDef(this, "controllers.StaticPage", "widget", Seq())
)
                              

                      
    
}
                            

// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:10
def test() = new play.api.mvc.HandlerRef(
   controllers.Application.test(), HandlerDef(this, "controllers.Application", "test", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:45
// @LINE:44
// @LINE:43
class ReverseUser {
    


 
// @LINE:45
def logout() = new play.api.mvc.HandlerRef(
   controllers.User.logout(), HandlerDef(this, "controllers.User", "logout", Seq())
)
                              
 
// @LINE:44
def add() = new play.api.mvc.HandlerRef(
   controllers.User.add(), HandlerDef(this, "controllers.User", "add", Seq())
)
                              
 
// @LINE:43
def login() = new play.api.mvc.HandlerRef(
   controllers.User.login(), HandlerDef(this, "controllers.User", "login", Seq())
)
                              

                      
    
}
                            

// @LINE:15
// @LINE:14
class ReverseRanking {
    


 
// @LINE:15
def page() = new play.api.mvc.HandlerRef(
   controllers.Ranking.page(), HandlerDef(this, "controllers.Ranking", "page", Seq())
)
                              
 
// @LINE:14
def byField(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Ranking.byField(id), HandlerDef(this, "controllers.Ranking", "byField", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:36
// @LINE:33
class ReverseSearch {
    


 
// @LINE:36
def search() = new play.api.mvc.HandlerRef(
   controllers.Search.search(), HandlerDef(this, "controllers.Search", "search", Seq())
)
                              
 
// @LINE:33
def json() = new play.api.mvc.HandlerRef(
   controllers.Search.json(), HandlerDef(this, "controllers.Search", "json", Seq())
)
                              

                      
    
}
                            

// @LINE:19
class ReverseHelp {
    


 
// @LINE:19
def section(name:String) = new play.api.mvc.HandlerRef(
   controllers.Help.section(name), HandlerDef(this, "controllers.Help", "section", Seq(classOf[String]))
)
                              

                      
    
}
                            

// @LINE:50
// @LINE:49
// @LINE:48
class ReverseIdeaBox {
    


 
// @LINE:49
def addIdea() = new play.api.mvc.HandlerRef(
   controllers.IdeaBox.addIdea(), HandlerDef(this, "controllers.IdeaBox", "addIdea", Seq())
)
                              
 
// @LINE:50
def vote(id:Long) = new play.api.mvc.HandlerRef(
   controllers.IdeaBox.vote(id), HandlerDef(this, "controllers.IdeaBox", "vote", Seq(classOf[Long]))
)
                              
 
// @LINE:48
def index() = new play.api.mvc.HandlerRef(
   controllers.IdeaBox.index(), HandlerDef(this, "controllers.IdeaBox", "index", Seq())
)
                              

                      
    
}
                            
}
                    
                