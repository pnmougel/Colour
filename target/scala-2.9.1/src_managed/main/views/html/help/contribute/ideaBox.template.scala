
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
object ideaBox extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<p>As a collaborative website, you can participate by proposing new features which could improve user experience. 
You can also vote for the ideas that you like the most. 
Ideas with the highest number of votes are the most likely to be added in a future version of the website.</p>

<p>Only logged users can propose new features and vote for them.</p>

<h6>Proposing a new idea</h6>

<p>Before adding a new idea, ensures that it has not been proposed before. 
As the number of votes will decide which features will be added first, 
duplicates might reduce the visibility of an idea you like.</p>

<p>To display the new feature form, click on the <a href="#">propose</a> link at the top of the webpage. 
Enter a short name describing your idea in the first field.
</p>
<p>In the description field, do not hesitate to add as much details as you want, and be as much precise as possible. 
Remember that adding a feature can take some time, and it might not be possible to change the way it works after it has been implemented.
</p>

<h6>Vote for an idea</h6>

<p>In order to vote, just click the <button class="btn btn-mini"><i class="icon-thumbs-up"></i></button> button below the number of votes. 
Note that you cannot vote several times for the same idea.</p>

<h6>Selection of the features that will be added</h6>

<p>While we will try our best to do so, the authors might choose not to add first the feature having the highest number of votes if its too complex. 
</p>"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/help/contribute/ideaBox.scala.html
                    HASH: 67c90f389433f65a21003de0dcf2c3529b916fff
                    MATRIX: 587->1
                    LINES: 22->2
                    -- GENERATED --
                */
            