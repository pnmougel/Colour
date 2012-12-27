
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
object message extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[controllers.admin.AdminMessage,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message : controllers.admin.AdminMessage):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.44*/("""

<div style="margin-bottom:8px;" class="logMessage"><span class="label label-"""),_display_(Seq[Any](/*3.78*/message/*3.85*/.messageType)),format.raw/*3.97*/("""">"""),_display_(Seq[Any](/*3.100*/message/*3.107*/.label)),format.raw/*3.113*/("""</span> """),_display_(Seq[Any](/*3.122*/message/*3.129*/.content)),format.raw/*3.137*/("""</div>

"""))}
    }
    
    def render(message:controllers.admin.AdminMessage) = apply(message)
    
    def f:((controllers.admin.AdminMessage) => play.api.templates.Html) = (message) => apply(message)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 11:12:26 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/admin/snippets/message.scala.html
                    HASH: 6c5340b081af41ab98ebfc4b6dbbfc2df999a4db
                    MATRIX: 546->1|665->43|779->122|794->129|827->141|866->144|882->151|910->157|955->166|971->173|1001->181
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|24->3|24->3|24->3|24->3|24->3
                    -- GENERATED --
                */
            