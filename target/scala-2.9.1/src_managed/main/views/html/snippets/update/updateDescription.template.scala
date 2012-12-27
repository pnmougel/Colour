
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
object updateDescription extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[UpdateDescription,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(update: UpdateDescription):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.29*/("""
<div>
"""),_display_(Seq[Any](/*3.2*/if(update.before == None)/*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""
    Description added <br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*4.64*/update/*4.70*/.after.get)),format.raw/*4.80*/("""
""")))})),format.raw/*5.2*/("""
"""),_display_(Seq[Any](/*6.2*/if(update.after == None)/*6.26*/ {_display_(Seq[Any](format.raw/*6.28*/("""
    Description removed <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*7.65*/update/*7.71*/.before.get)),format.raw/*7.82*/("""
""")))})),format.raw/*8.2*/("""
"""),_display_(Seq[Any](/*9.2*/if(update.after != None && update.before != None)/*9.51*/ {_display_(Seq[Any](format.raw/*9.53*/("""
    Description updated <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*10.65*/update/*10.71*/.before.get)),format.raw/*10.82*/("""<br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*10.123*/update/*10.129*/.after.get)),format.raw/*10.139*/("""
""")))})),format.raw/*11.2*/("""
</div>"""))}
    }
    
    def render(update:UpdateDescription) = apply(update)
    
    def f:((UpdateDescription) => play.api.templates.Html) = (update) => apply(update)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 18 14:38:26 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/update/updateDescription.scala.html
                    HASH: 62d0786aa591271957cb04b60860fb09c33b833c
                    MATRIX: 544->1|648->28|690->36|723->61|762->63|861->127|875->133|906->143|938->145|974->147|1006->171|1045->173|1145->238|1159->244|1191->255|1223->257|1259->259|1316->308|1355->310|1456->375|1471->381|1504->392|1582->433|1598->439|1631->449|1664->451
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|27->6|27->6|27->6|28->7|28->7|28->7|29->8|30->9|30->9|30->9|31->10|31->10|31->10|31->10|31->10|31->10|32->11
                    -- GENERATED --
                */
            