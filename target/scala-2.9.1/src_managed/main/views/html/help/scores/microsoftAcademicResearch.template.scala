
package views.html.help.scores

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
object microsoftAcademicResearch extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""You can get information on the way Google Scholar works on the <a href="http://scholar.google.com/intl/en/scholar/about.html">Google Scholar page</a> """))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Dec 22 19:15:45 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/help/scores/microsoftAcademicResearch.scala.html
                    HASH: 0bb4c458a66c75adb49f0af74bf97c988219044c
                    MATRIX: 601->1
                    LINES: 22->2
                    -- GENERATED --
                */
            