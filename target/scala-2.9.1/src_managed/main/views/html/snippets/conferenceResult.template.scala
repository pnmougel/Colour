
package views.html.snippets

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
object conferenceResult extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Conference,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(conference: Conference):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.26*/("""

<li>
    <div style="height: 60px;">
        <h4><a href="/conference/"""),_display_(Seq[Any](/*5.35*/conference/*5.45*/.id)),format.raw/*5.48*/("""">
        """),_display_(Seq[Any](/*6.10*/conference/*6.20*/.name)),format.raw/*6.25*/(""" 
           """),_display_(Seq[Any](/*7.13*/if(conference.shortName != "")/*7.43*/ {_display_(Seq[Any](format.raw/*7.45*/("""
           	("""),_display_(Seq[Any](/*8.15*/conference/*8.25*/.shortName)),format.raw/*8.35*/(""")
           """)))})),format.raw/*9.13*/("""
        </a>
        </h4>
        <h6>"""),_display_(Seq[Any](/*12.14*/conference/*12.24*/.ctype.name)),format.raw/*12.35*/(""" on """),_display_(Seq[Any](/*12.40*/conference/*12.50*/.field.name)),format.raw/*12.61*/("""</h6>
    </div>
</li>

"""))}
    }
    
    def render(conference:Conference) = apply(conference)
    
    def f:((Conference) => play.api.templates.Html) = (conference) => apply(conference)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Dec 23 01:40:56 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/conferenceResult.scala.html
                    HASH: 3e68eeb9d9797f842386f6ba91f34cd18c5f1da2
                    MATRIX: 529->1|630->25|738->98|756->108|780->111|827->123|845->133|871->138|920->152|958->182|997->184|1047->199|1065->209|1096->219|1141->233|1218->274|1237->284|1270->295|1311->300|1330->310|1363->321
                    LINES: 19->1|22->1|26->5|26->5|26->5|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|33->12|33->12|33->12|33->12|33->12|33->12
                    -- GENERATED --
                */
            