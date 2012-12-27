
package views.html.admin.snippets

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object actionsMenu extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[scala.collection.mutable.HashMap[String, scala.collection.mutable.ListBuffer[controllers.admin.action.AdminAction]],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(actionsByCategory : scala.collection.mutable.HashMap[String, scala.collection.mutable.ListBuffer[controllers.admin.action.AdminAction]]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.139*/("""


<ul class="nav nav-list">
	"""),_display_(Seq[Any](/*5.3*/actionsByCategory/*5.20*/.map/*5.24*/ { case (category, actions) =>_display_(Seq[Any](format.raw/*5.54*/("""
    <li class="nav-header">"""),_display_(Seq[Any](/*6.29*/category)),format.raw/*6.37*/("""</li>
    	"""),_display_(Seq[Any](/*7.7*/actions/*7.14*/.map/*7.18*/ { action =>_display_(Seq[Any](format.raw/*7.30*/("""
    		<li><a href="/admin/action/"""),_display_(Seq[Any](/*8.35*/action/*8.41*/.name)),format.raw/*8.46*/(""""><i class="icon-"""),_display_(Seq[Any](/*8.64*/action/*8.70*/.icon)),format.raw/*8.75*/(""""></i> """),_display_(Seq[Any](/*8.83*/action/*8.89*/.label)),format.raw/*8.95*/("""</a></li>
    	""")))})),format.raw/*9.7*/("""
    """)))})),format.raw/*10.6*/("""
</ul>
"""))}
    }
    
    def render(actionsByCategory:scala.collection.mutable.HashMap[String, scala.collection.mutable.ListBuffer[controllers.admin.action.AdminAction]]) = apply(actionsByCategory)
    
    def f:((scala.collection.mutable.HashMap[String, scala.collection.mutable.ListBuffer[controllers.admin.action.AdminAction]]) => play.api.templates.Html) = (actionsByCategory) => apply(actionsByCategory)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 17 00:45:13 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/admin/snippets/actionsMenu.scala.html
                    HASH: 71cd0d28c15f22efec8628fcbf38b6b94ff1f583
                    MATRIX: 635->1|850->138|915->169|940->186|952->190|1019->220|1083->249|1112->257|1158->269|1173->276|1185->280|1234->292|1304->327|1318->333|1344->338|1397->356|1411->362|1437->367|1480->375|1494->381|1521->387|1567->403|1604->409
                    LINES: 19->1|22->1|26->5|26->5|26->5|26->5|27->6|27->6|28->7|28->7|28->7|28->7|29->8|29->8|29->8|29->8|29->8|29->8|29->8|29->8|29->8|30->9|31->10
                    -- GENERATED --
                */
            