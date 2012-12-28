
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
object scoresExternal extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Conference,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(conference : Conference):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""

<div class="span4">
	<div class="row">
		<div class="span1"><h5>External:</h5></div>
		"""),_display_(Seq[Any](/*6.4*/if(conference.externalScore.isDefined)/*6.42*/ {_display_(Seq[Any](format.raw/*6.44*/("""
    		<div class="span1"><h5>"""),_display_(Seq[Any](/*7.31*/snippets/*7.39*/.doubleDisplay(conference.externalScore.get))),format.raw/*7.83*/(""" / 5</h5></div>
		""")))})),format.raw/*8.4*/("""
	</div>
<div class="vertical-spacing-10"></div>
	<ul class="unstyled">
		"""),_display_(Seq[Any](/*12.4*/conference/*12.14*/.externalScores.map/*12.33*/ { externalScore =>_display_(Seq[Any](format.raw/*12.52*/("""
		    <li>
				<div class="row" style="padding-bottom:18px;">
					<div class="span2">
					   <a href=""""),_display_(Seq[Any](/*16.19*/externalScore/*16.32*/.externalRanking.url)),format.raw/*16.52*/("""" style="font-weight:bold;color:black;">"""),_display_(Seq[Any](/*16.93*/externalScore/*16.106*/.externalRanking.name)),format.raw/*16.127*/(""" ("""),_display_(Seq[Any](/*16.130*/externalScore/*16.143*/.externalRanking.scoreType.name)),format.raw/*16.174*/(""")</a>
					   <i class="icon-info-sign" onclick="$('#scoreInfo_"""),_display_(Seq[Any](/*17.59*/externalScore/*17.72*/.externalRanking.id)),format.raw/*17.91*/("""').toggle();"></i>
					</div>
					<div class="span1">"""),_display_(Seq[Any](/*19.26*/externalScore/*19.39*/.scoreText)),format.raw/*19.49*/("""</div>
					<div class="span1">"""),_display_(Seq[Any](/*20.26*/snippets/*20.34*/.badge(Option[Double](externalScore.score)))),format.raw/*20.77*/("""</div>
				</div>
				<div class="row" style="display:none;" id="scoreInfo_"""),_display_(Seq[Any](/*22.59*/externalScore/*22.72*/.externalRanking.id)),format.raw/*22.91*/("""">
				    <span class="span4">"""),_display_(Seq[Any](/*23.30*/externalScore/*23.43*/.externalRanking.description)),format.raw/*23.71*/("""</span>
				    <span class="span4">Source: <a href=""""),_display_(Seq[Any](/*24.47*/externalScore/*24.60*/.externalRanking.url)),format.raw/*24.80*/("""">"""),_display_(Seq[Any](/*24.83*/externalScore/*24.96*/.externalRanking.url)),format.raw/*24.116*/("""</a></span>
                    <span class="span4"><a href="/help/"""),_display_(Seq[Any](/*25.57*/externalScore/*25.70*/.externalRanking.name)),format.raw/*25.91*/("""">More information</a></span>
				</div>
			</li>
		""")))})),format.raw/*28.4*/("""
	</ul>
</div>
"""))}
    }
    
    def render(conference:Conference) = apply(conference)
    
    def f:((Conference) => play.api.templates.Html) = (conference) => apply(conference)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/conferences/scoresExternal.scala.html
                    HASH: 59a506743dd756a0d7df8ddd6fc84b039c1808eb
                    MATRIX: 530->1|632->26|756->116|802->154|841->156|907->187|923->195|988->239|1037->258|1147->333|1166->343|1194->362|1251->381|1393->487|1415->500|1457->520|1534->561|1557->574|1601->595|1641->598|1664->611|1718->642|1818->706|1840->719|1881->738|1973->794|1995->807|2027->817|2095->849|2112->857|2177->900|2289->976|2311->989|2352->1008|2420->1040|2442->1053|2492->1081|2582->1135|2604->1148|2646->1168|2685->1171|2707->1184|2750->1204|2854->1272|2876->1285|2919->1306|3003->1359
                    LINES: 19->1|22->1|27->6|27->6|27->6|28->7|28->7|28->7|29->8|33->12|33->12|33->12|33->12|37->16|37->16|37->16|37->16|37->16|37->16|37->16|37->16|37->16|38->17|38->17|38->17|40->19|40->19|40->19|41->20|41->20|41->20|43->22|43->22|43->22|44->23|44->23|44->23|45->24|45->24|45->24|45->24|45->24|45->24|46->25|46->25|46->25|49->28
                    -- GENERATED --
                */
            