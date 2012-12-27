
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
object updateAddSubfields extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[UpdateAddSubfield],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(updates: List[UpdateAddSubfield]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""
"""),_display_(Seq[Any](/*2.2*/if(!updates.isEmpty)/*2.22*/ {_display_(Seq[Any](format.raw/*2.24*/("""
    <div>
        Subfield"""),_display_(Seq[Any](/*4.18*/if(updates.size > 1)/*4.38*/ {_display_(Seq[Any](format.raw/*4.40*/("""s""")))})),format.raw/*4.42*/(""" added <br/>
        """),_display_(Seq[Any](/*5.10*/updates/*5.17*/.map/*5.21*/ { update =>_display_(Seq[Any](format.raw/*5.33*/("""
            <i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*6.49*/update/*6.55*/.subfield.name)),format.raw/*6.69*/("""<br/>
        """)))})),format.raw/*7.10*/("""
    </div>
""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(updates:List[UpdateAddSubfield]) = apply(updates)
    
    def f:((List[UpdateAddSubfield]) => play.api.templates.Html) = (updates) => apply(updates)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 18 10:07:45 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/update/updateAddSubfields.scala.html
                    HASH: 386560b3575c2bb3786772800a45bd5f7244e5bc
                    MATRIX: 551->1|662->35|698->37|726->57|765->59|828->87|856->107|895->109|928->111|985->133|1000->140|1012->144|1061->156|1145->205|1159->211|1194->225|1240->240|1283->253
                    LINES: 19->1|22->1|23->2|23->2|23->2|25->4|25->4|25->4|25->4|26->5|26->5|26->5|26->5|27->6|27->6|27->6|28->7|30->9
                    -- GENERATED --
                */
            