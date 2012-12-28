
package views.html.snippets

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
object scoreUser extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Int,Int,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(rankLetter: String, percentage: Int, nbVotes: Int):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.53*/("""

<div class="row">
    <div class="span1">
        """),_display_(Seq[Any](/*5.10*/nbVotes)),format.raw/*5.17*/(""" vote"""),_display_(Seq[Any](/*5.23*/if(nbVotes > 1)/*5.38*/ {_display_(Seq[Any](format.raw/*5.40*/("""s""")))})),format.raw/*5.42*/("""
    </div>
    <div class="span1">
        <div class="progress progress-info" style="width: 80px;">
            <div class="bar" style="width: """),_display_(Seq[Any](/*9.45*/percentage)),format.raw/*9.55*/("""%;"></div>
        </div>
    </div>
	<div class="span1">"""),_display_(Seq[Any](/*12.22*/percentage)),format.raw/*12.32*/("""%</div>
	<div class="span1">
        """),_display_(Seq[Any](/*14.10*/rankLetter match/*14.26*/ {/*15.13*/case "A" =>/*15.24*/ {_display_(Seq[Any](format.raw/*15.26*/("""
                <span class="badge badge-success" >"""),_display_(Seq[Any](/*16.53*/rankLetter)),format.raw/*16.63*/("""</span>
            """)))}/*18.13*/case "B" =>/*18.24*/ {_display_(Seq[Any](format.raw/*18.26*/("""
                <span class="badge badge-warning">"""),_display_(Seq[Any](/*19.52*/rankLetter)),format.raw/*19.62*/("""</span>
            """)))}/*21.13*/case "C" =>/*21.24*/ {_display_(Seq[Any](format.raw/*21.26*/("""
                <span class="badge badge-info">"""),_display_(Seq[Any](/*22.49*/rankLetter)),format.raw/*22.59*/("""</span>
            """)))}/*24.13*/case "X" =>/*24.24*/ {_display_(Seq[Any](format.raw/*24.26*/("""
                <span class="badge badge-important" >"""),_display_(Seq[Any](/*25.55*/rankLetter)),format.raw/*25.65*/("""</span>
            """)))}/*27.13*/case _ =>/*27.22*/ {_display_(Seq[Any](format.raw/*27.24*/("""
                <span class="badge" >?</span>
            """)))}})),format.raw/*31.10*/("""
    </div>
</div>
"""))}
    }
    
    def render(rankLetter:String,percentage:Int,nbVotes:Int) = apply(rankLetter,percentage,nbVotes)
    
    def f:((String,Int,Int) => play.api.templates.Html) = (rankLetter,percentage,nbVotes) => apply(rankLetter,percentage,nbVotes)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/scoreUser.scala.html
                    HASH: cf81d939ae33ac8693aecd597b02612b496acac0
                    MATRIX: 526->1|654->52|742->105|770->112|811->118|834->133|873->135|906->137|1087->283|1118->293|1212->351|1244->361|1318->399|1343->415|1354->430|1374->441|1414->443|1503->496|1535->506|1575->540|1595->551|1635->553|1723->605|1755->615|1795->649|1815->660|1855->662|1940->711|1972->721|2012->755|2032->766|2072->768|2163->823|2195->833|2235->867|2253->876|2293->878|2386->961
                    LINES: 19->1|22->1|26->5|26->5|26->5|26->5|26->5|26->5|30->9|30->9|33->12|33->12|35->14|35->14|35->15|35->15|35->15|36->16|36->16|37->18|37->18|37->18|38->19|38->19|39->21|39->21|39->21|40->22|40->22|41->24|41->24|41->24|42->25|42->25|43->27|43->27|43->27|45->31
                    -- GENERATED --
                */
            