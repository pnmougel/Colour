
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
object updateCreationYear extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[UpdateCreationDate,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(update: UpdateCreationDate):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.30*/("""
<div>
    """),_display_(Seq[Any](/*3.6*/if(update.before == 0)/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""
        Creation year added <br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*4.70*/update/*4.76*/.after)),format.raw/*4.82*/("""
    """)))})),format.raw/*5.6*/("""
    """),_display_(Seq[Any](/*6.6*/if(update.after == 0)/*6.27*/ {_display_(Seq[Any](format.raw/*6.29*/("""
        Creation year removed <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*7.71*/update/*7.77*/.before)),format.raw/*7.84*/("""
    """)))})),format.raw/*8.6*/("""
    """),_display_(Seq[Any](/*9.6*/if(update.after != 0 && update.before != 0)/*9.49*/ {_display_(Seq[Any](format.raw/*9.51*/("""
        Creation year updated <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*10.71*/update/*10.77*/.before)),format.raw/*10.84*/("""<br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*10.125*/update/*10.131*/.after)),format.raw/*10.137*/("""
    """)))})),format.raw/*11.6*/("""
</div>"""))}
    }
    
    def render(update:UpdateCreationDate) = apply(update)
    
    def f:((UpdateCreationDate) => play.api.templates.Html) = (update) => apply(update)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/update/updateCreationYear.scala.html
                    HASH: 90f849ecd1fb599ca3744e81aa3d2dfc455f5516
                    MATRIX: 546->1|651->29|697->41|727->63|766->65|871->135|885->141|912->147|948->153|988->159|1017->180|1056->182|1162->253|1176->259|1204->266|1240->272|1280->278|1331->321|1370->323|1477->394|1492->400|1521->407|1599->448|1615->454|1644->460|1681->466
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|27->6|27->6|27->6|28->7|28->7|28->7|29->8|30->9|30->9|30->9|31->10|31->10|31->10|31->10|31->10|31->10|32->11
                    -- GENERATED --
                */
            