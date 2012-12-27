
package views.html.help

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
object about extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<p>The colour ranking is based on the idea that no one knows better the quality of a journal or a conference than the members of its research community. 
Our objective is to gather this information through votes in order to provide an accurate score regarding the quality of a publication</p>
 
<h6>Collaborative ranking</h6>
 
We want this website to be as much collaborative and community oriented as possible. 
 
<h6>Scoring method</h6>

<p>To be as exhaustive as possible, the scores are based on two sources:
<ul>
    <li>User votes</li>
    <li>Scores from external ranking, e.g., Core, Microsoft Academic Research or Google Scholar</li>
</ul>

<p>You can get detailed information on how the scores are computed from this different sources by visiting the sections <a href="/help/user_scores">User scores</a> and 
<a href="/help/external_scores">External scores</a>.</p> 

<h6>Authors disclaimer</h6>

<p>The authors strongly believe that a research evaluation based only on the ranking of the journals or conferences leads to bad pratices. 
However, it remains a good indicator and as such we hope that the colour ranking will be helpful.</p> 
 """))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 20 16:53:53 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/help/about.scala.html
                    HASH: 782e1ac952d1871356040cd8f094c995122b1eb5
                    MATRIX: 574->1
                    LINES: 22->2
                    -- GENERATED --
                */
            