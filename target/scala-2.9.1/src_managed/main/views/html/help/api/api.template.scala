
package views.html.help.api

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
object api extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<p>This website is collaborative, 
</p> 

"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Dec 22 19:16:57 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/help/api/api.scala.html
                    HASH: 8776c20988e419c31d69b79a5c962ac8be06f1e0
                    MATRIX: 576->1
                    LINES: 22->2
                    -- GENERATED --
                */
            