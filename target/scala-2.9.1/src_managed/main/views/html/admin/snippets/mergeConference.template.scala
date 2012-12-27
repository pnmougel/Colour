
package views.html.admin.snippets

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
object mergeConference extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Int,controllers.admin.scores.ConferenceInformation,List[scala.Tuple2[Conference, Double]],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(mergeId : Int, conferenceInformation : controllers.admin.scores.ConferenceInformation, matchingConferences : List[(Conference, Double)]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.139*/("""

 <div id="merge_"""),_display_(Seq[Any](/*3.18*/mergeId)),format.raw/*3.25*/("""" style="-moz-border-radius: 6px;border-radius: 6px;border:1px solid #9BA5AD;background-color:#F8F8F8;background-clip: padding-box;-moz-background-clip: padding;-webkit-background-clip: padding-box;overflow: hidden;margin-top:10px;">
    <div style="font-weight:bold;color:#4794C4;border-bottom:1px solid #9BA5AD;padding:5px;background-color:#E5E8EB;background-clip: padding-box;-moz-background-clip: padding;-webkit-background-clip: padding-box;text-shadow: 1px 1px white;font-size:11pt;padding-left:10px;">
        <i class="icon-screenshot"></i> Select matching conference
    </div>
    <div style="padding:0px;">
    <table class="table table-condensed table-bordered" style="margin-bottom:0px;">
    <thead>
        <tr>
        <th class="span1"></th>
        <th>Conference Name</th>
        <th>Short Name</th>
        <th>Type</th>
        <th>Field</th>
        <th>Score</th>
        </tr>
    </thead>
    <tbody>
    <tr>
        <td><button class="btn btn-mini btn-success span1 createNewPublication" mergeId=""""),_display_(Seq[Any](/*21.91*/mergeId)),format.raw/*21.98*/("""">Add</button></td>
        <td>"""),_display_(Seq[Any](/*22.14*/conferenceInformation/*22.35*/.name)),format.raw/*22.40*/("""</td>
        <td>"""),_display_(Seq[Any](/*23.14*/if(conferenceInformation.shortName.isDefined)/*23.59*/ {_display_(Seq[Any](format.raw/*23.61*/(""" """),_display_(Seq[Any](/*23.63*/conferenceInformation/*23.84*/.shortName.get)),format.raw/*23.98*/(""" """)))})),format.raw/*23.100*/("""</td>
        <td>"""),_display_(Seq[Any](/*24.14*/if(conferenceInformation.ctype.isDefined)/*24.55*/ {_display_(Seq[Any](format.raw/*24.57*/(""" """),_display_(Seq[Any](/*24.59*/conferenceInformation/*24.80*/.ctype.get.name)),format.raw/*24.95*/(""" """)))})),format.raw/*24.97*/("""</td>
        <td>"""),_display_(Seq[Any](/*25.14*/if(conferenceInformation.field.isDefined)/*25.55*/ {_display_(Seq[Any](format.raw/*25.57*/(""" """),_display_(Seq[Any](/*25.59*/conferenceInformation/*25.80*/.field.get.name)),format.raw/*25.95*/(""" """)))})),format.raw/*25.97*/("""</td>
        <td></td>
    </tr>
    """),_display_(Seq[Any](/*28.6*/matchingConferences/*28.25*/.map/*28.29*/ { case (conference, score) =>_display_(Seq[Any](format.raw/*28.59*/("""
    <tr>
        <td><button class="btn btn-mini btn-primary span1 sameAsPublication" for=""""),_display_(Seq[Any](/*30.84*/conference/*30.94*/.id)),format.raw/*30.97*/("""" mergeId=""""),_display_(Seq[Any](/*30.109*/mergeId)),format.raw/*30.116*/("""">Same</button></td>
        <td>"""),_display_(Seq[Any](/*31.14*/conference/*31.24*/.name)),format.raw/*31.29*/("""</td>
        <td>"""),_display_(Seq[Any](/*32.14*/conference/*32.24*/.shortName)),format.raw/*32.34*/("""</td>
        <td>"""),_display_(Seq[Any](/*33.14*/conference/*33.24*/.ctype.name)),format.raw/*33.35*/("""</td>
        <td>"""),_display_(Seq[Any](/*34.14*/conference/*34.24*/.field.name)),format.raw/*34.35*/("""</td>
        <td>"""),_display_(Seq[Any](/*35.14*/score)),format.raw/*35.19*/("""</td>
    </tr>
    </tbody>
    """)))})),format.raw/*38.6*/("""
    </table>
    </div>
</div>
"""))}
    }
    
    def render(mergeId:Int,conferenceInformation:controllers.admin.scores.ConferenceInformation,matchingConferences:List[scala.Tuple2[Conference, Double]]) = apply(mergeId,conferenceInformation,matchingConferences)
    
    def f:((Int,controllers.admin.scores.ConferenceInformation,List[scala.Tuple2[Conference, Double]]) => play.api.templates.Html) = (mergeId,conferenceInformation,matchingConferences) => apply(mergeId,conferenceInformation,matchingConferences)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 14:45:52 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/admin/snippets/mergeConference.scala.html
                    HASH: 2c53f40b859e70a6924f97adf65e45d6f38767c5
                    MATRIX: 613->1|828->138|882->157|910->164|1972->1190|2001->1197|2070->1230|2100->1251|2127->1256|2182->1275|2236->1320|2276->1322|2314->1324|2344->1345|2380->1359|2415->1361|2470->1380|2520->1421|2560->1423|2598->1425|2628->1446|2665->1461|2699->1463|2754->1482|2804->1523|2844->1525|2882->1527|2912->1548|2949->1563|2983->1565|3057->1604|3085->1623|3098->1627|3166->1657|3295->1750|3314->1760|3339->1763|3388->1775|3418->1782|3488->1816|3507->1826|3534->1831|3589->1850|3608->1860|3640->1870|3695->1889|3714->1899|3747->1910|3802->1929|3821->1939|3854->1950|3909->1969|3936->1974|4001->2008
                    LINES: 19->1|22->1|24->3|24->3|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|44->23|44->23|44->23|44->23|45->24|45->24|45->24|45->24|45->24|45->24|45->24|46->25|46->25|46->25|46->25|46->25|46->25|46->25|49->28|49->28|49->28|49->28|51->30|51->30|51->30|51->30|51->30|52->31|52->31|52->31|53->32|53->32|53->32|54->33|54->33|54->33|55->34|55->34|55->34|56->35|56->35|59->38
                    -- GENERATED --
                */
            