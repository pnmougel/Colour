
package views.html.snippets.update

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
object updateCtype extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[UpdateCtype,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(update: UpdateCtype):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""
<div>
    Type updated <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*3.58*/update/*3.64*/.ctypeBefore.name)),format.raw/*3.81*/("""<br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*3.122*/update/*3.128*/.ctypeAfter.name)),format.raw/*3.144*/("""
</div>"""))}
    }
    
    def render(update:UpdateCtype) = apply(update)
    
    def f:((UpdateCtype) => play.api.templates.Html) = (update) => apply(update)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/update/updateCtype.scala.html
                    HASH: 1bf24bcd7f4dbeb6a6a3979b093c5cee77daebbb
                    MATRIX: 532->1|630->22|729->86|743->92|781->109|858->150|873->156|911->172
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|24->3|24->3
                    -- GENERATED --
                */
            