
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
object updateName extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[UpdateName,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(update: UpdateName):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""
<div>
    Name updated <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*3.58*/update/*3.64*/.before)),format.raw/*3.71*/("""<br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*3.112*/update/*3.118*/.after)),format.raw/*3.124*/("""
</div>"""))}
    }
    
    def render(update:UpdateName) = apply(update)
    
    def f:((UpdateName) => play.api.templates.Html) = (update) => apply(update)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 18 09:35:25 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/update/updateName.scala.html
                    HASH: d3ab21d6909892ee82190f2f1c29e152eb3779d1
                    MATRIX: 530->1|627->21|726->85|740->91|768->98|845->139|860->145|888->151
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|24->3|24->3
                    -- GENERATED --
                */
            