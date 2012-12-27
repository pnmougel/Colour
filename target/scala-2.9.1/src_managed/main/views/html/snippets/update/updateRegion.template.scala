
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
object updateRegion extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[UpdateRegion,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(update: UpdateRegion):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.24*/("""
<div>
    Region updated <br/><i class="icon-chevron-left"></i> """),_display_(Seq[Any](/*3.60*/update/*3.66*/.regionBefore.name)),format.raw/*3.84*/("""<br/><i class="icon-chevron-right"></i> """),_display_(Seq[Any](/*3.125*/update/*3.131*/.regionAfter.name)),format.raw/*3.148*/("""
</div>"""))}
    }
    
    def render(update:UpdateRegion) = apply(update)
    
    def f:((UpdateRegion) => play.api.templates.Html) = (update) => apply(update)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 18 14:30:59 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/update/updateRegion.scala.html
                    HASH: 2c5e28f8eedfd54bf73cfde5f8582ae418c1a23a
                    MATRIX: 534->1|633->23|734->89|748->95|787->113|864->154|879->160|918->177
                    LINES: 19->1|22->1|24->3|24->3|24->3|24->3|24->3|24->3
                    -- GENERATED --
                */
            