
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
object updateShortName extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[UpdateShortname,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(update: UpdateShortname):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""
<div>
    Short Name updated <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*3.64*/update/*3.70*/.before)),format.raw/*3.77*/("""<br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*3.118*/update/*3.124*/.after)),format.raw/*3.130*/("""
</div>"""))}
    }
    
    def render(update:UpdateShortname) = apply(update)
    
    def f:((UpdateShortname) => play.api.templates.Html) = (update) => apply(update)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/update/updateShortName.scala.html
                    HASH: 4f34a5b4ae66d04892320314b2c19fc14817afd4
                    MATRIX: 540->1|642->26|747->96|761->102|789->109|866->150|881->156|909->162
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|24->3|24->3
                    -- GENERATED --
                */
            