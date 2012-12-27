
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
object updateRemoveSubfields extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[UpdateRemoveSubfield],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(updates: List[UpdateRemoveSubfield]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.39*/("""
"""),_display_(Seq[Any](/*2.2*/if(!updates.isEmpty)/*2.22*/ {_display_(Seq[Any](format.raw/*2.24*/("""
    <div>
        Subfield"""),_display_(Seq[Any](/*4.18*/if(updates.size > 1)/*4.38*/ {_display_(Seq[Any](format.raw/*4.40*/("""s""")))})),format.raw/*4.42*/(""" removed <br/>
        """),_display_(Seq[Any](/*5.10*/updates/*5.17*/.map/*5.21*/ { update =>_display_(Seq[Any](format.raw/*5.33*/("""
            <i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*6.48*/update/*6.54*/.subfield.name)),format.raw/*6.68*/("""<br/>
        """)))})),format.raw/*7.10*/("""
    </div>
""")))})))}
    }
    
    def render(updates:List[UpdateRemoveSubfield]) = apply(updates)
    
    def f:((List[UpdateRemoveSubfield]) => play.api.templates.Html) = (updates) => apply(updates)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 18 10:07:22 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/update/updateRemoveSubfields.scala.html
                    HASH: 323c5d7348b8e62e48806d8fd090252e045476d1
                    MATRIX: 557->1|671->38|707->40|735->60|774->62|837->90|865->110|904->112|937->114|996->138|1011->145|1023->149|1072->161|1155->209|1169->215|1204->229|1250->244
                    LINES: 19->1|22->1|23->2|23->2|23->2|25->4|25->4|25->4|25->4|26->5|26->5|26->5|26->5|27->6|27->6|27->6|28->7
                    -- GENERATED --
                */
            