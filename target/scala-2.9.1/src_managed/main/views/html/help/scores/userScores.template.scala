
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
object userScores extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

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
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/help/scores/userScores.scala.html
                    HASH: 0bb4c458a66c75adb49f0af74bf97c988219044c
                    MATRIX: 586->1
                    LINES: 22->2
                    -- GENERATED --
                */
            