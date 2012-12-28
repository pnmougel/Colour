
package views.html.conferences

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
object userScores extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[UserVotes,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(userVotes : UserVotes):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.25*/("""

<div class="span4">
	<div class="row">
		<div class="span1"><h5>Users:</h5></div>
		<div class="span2"><h5>
		"""),_display_(Seq[Any](/*7.4*/if(userVotes.avgUserScore == -1)/*7.36*/ {_display_(Seq[Any](format.raw/*7.38*/("""
    		No votes yet 
		""")))}/*9.5*/else/*9.10*/{_display_(Seq[Any](format.raw/*9.11*/("""
		    """),_display_(Seq[Any](/*10.8*/snippets/*10.16*/.doubleDisplay(userVotes.avgUserScore))),format.raw/*10.54*/("""
			/ 5
		""")))})),format.raw/*12.4*/("""</h5></div>
	</div>
    	
    <div class="vertical-spacing-10"></div>
    <ul class="unstyled">
		<li>"""),_display_(Seq[Any](/*17.8*/snippets/*17.16*/.scoreUser("A", userVotes.voteA._2, userVotes.voteA._1))),format.raw/*17.71*/("""</li>
        <li>"""),_display_(Seq[Any](/*18.14*/snippets/*18.22*/.scoreUser("B", userVotes.voteB._2, userVotes.voteB._1))),format.raw/*18.77*/("""</li>
        <li>"""),_display_(Seq[Any](/*19.14*/snippets/*19.22*/.scoreUser("C", userVotes.voteC._2, userVotes.voteC._1))),format.raw/*19.77*/("""</li>
        <li>"""),_display_(Seq[Any](/*20.14*/snippets/*20.22*/.scoreUser("X", userVotes.voteD._2, userVotes.voteD._1))),format.raw/*20.77*/("""</li>
	</ul>
</div>
"""))}
    }
    
    def render(userVotes:UserVotes) = apply(userVotes)
    
    def f:((UserVotes) => play.api.templates.Html) = (userVotes) => apply(userVotes)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/conferences/userScores.scala.html
                    HASH: dc5d4108d6c5cc5e89f68b55d3704633ff52e0f7
                    MATRIX: 525->1|625->24|772->137|812->169|851->171|892->196|904->201|942->202|985->210|1002->218|1062->256|1104->267|1242->370|1259->378|1336->433|1391->452|1408->460|1485->515|1540->534|1557->542|1634->597|1689->616|1706->624|1783->679
                    LINES: 19->1|22->1|28->7|28->7|28->7|30->9|30->9|30->9|31->10|31->10|31->10|33->12|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|41->20|41->20|41->20
                    -- GENERATED --
                */
            