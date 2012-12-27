
package views.html.help.contribute

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
object vote extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<p>In order to vote you must first <a href="/help/create_an_account">create an account</a> and be logged. 
Then in the page corresponding to the publication, click on the <button>Vote</button> button.     
</p>

<p>You will be displayed a choice between four votes</p>
<ul>
    <li>Rank A: </li>
    <li>Rank B: </li>
    <li>Rank C: </li>
    <li>Rank D: A D vote means that you consider the publication to avoid and should be counted negatively for the authors who submit their. 
    Please, bear in mind that such choice might have a strong negative impact. Before voting ensures that this choice is based on real facts, and do not hesitate to explain the reasons of your vote by adding a comment.
    </li>
</ul>

<h6>Update your vote</h6>

As the quality of a publication might change over time, hopefully in a better way, or you might get new knowledge about it, you can always update your vote. 
 """))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Dec 22 19:14:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/help/contribute/vote.scala.html
                    HASH: 4fd3b0af43d896ed3a94e829c3f315607f899fe2
                    MATRIX: 584->1
                    LINES: 22->2
                    -- GENERATED --
                */
            