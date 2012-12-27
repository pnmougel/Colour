
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
object updatePublisher extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[UpdatePublisher,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(update: UpdatePublisher):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""
<div>
"""),_display_(Seq[Any](/*3.2*/if(update.before == None)/*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""
    Publisher added <br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*4.62*/update/*4.68*/.publisherAfter.get.name)),format.raw/*4.92*/("""
""")))})),format.raw/*5.2*/("""
"""),_display_(Seq[Any](/*6.2*/if(update.after == None)/*6.26*/ {_display_(Seq[Any](format.raw/*6.28*/("""
    Publisher removed <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*7.63*/update/*7.69*/.publisherBefore.get.name)),format.raw/*7.94*/("""
""")))})),format.raw/*8.2*/("""
"""),_display_(Seq[Any](/*9.2*/if(update.after != None && update.before != None)/*9.51*/ {_display_(Seq[Any](format.raw/*9.53*/("""
    Publisher updated <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*10.63*/update/*10.69*/.publisherBefore.get.name)),format.raw/*10.94*/("""<br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*10.135*/update/*10.141*/.publisherAfter.get.name)),format.raw/*10.165*/("""
""")))})),format.raw/*11.2*/("""
</div>"""))}
    }
    
    def render(update:UpdatePublisher) = apply(update)
    
    def f:((UpdatePublisher) => play.api.templates.Html) = (update) => apply(update)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 18 14:30:06 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/update/updatePublisher.scala.html
                    HASH: 0be8d4c7eac24b640b5ca014c76da4cce7766069
                    MATRIX: 540->1|642->26|684->34|717->59|756->61|853->123|867->129|912->153|944->155|980->157|1012->181|1051->183|1149->246|1163->252|1209->277|1241->279|1277->281|1334->330|1373->332|1472->395|1487->401|1534->426|1612->467|1628->473|1675->497|1708->499
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|27->6|27->6|27->6|28->7|28->7|28->7|29->8|30->9|30->9|30->9|31->10|31->10|31->10|31->10|31->10|31->10|32->11
                    -- GENERATED --
                */
            