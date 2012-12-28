
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
object information extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Conference,Option[User],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(conference: Conference, user : Option[User]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

<div class="row">
	<div id="conference_name" class="span7">
		<h2 id="test">
		"""),_display_(Seq[Any](/*6.4*/if(conference.shortName.trim.size > 0)/*6.42*/ {_display_(Seq[Any](format.raw/*6.44*/("""
			"""),_display_(Seq[Any](/*7.5*/conference/*7.15*/.shortName)),format.raw/*7.25*/("""
			<h4>"""),_display_(Seq[Any](/*8.9*/conference/*8.19*/.name)),format.raw/*8.24*/("""</h4>
		""")))}/*9.5*/else/*9.10*/{_display_(Seq[Any](format.raw/*9.11*/("""
			"""),_display_(Seq[Any](/*10.5*/conference/*10.15*/.name)),format.raw/*10.20*/("""
		""")))})),format.raw/*11.4*/("""
		</h2>
	</div>
	
    """),_display_(Seq[Any](/*15.6*/if(user.isDefined)/*15.24*/ {_display_(Seq[Any](format.raw/*15.26*/("""
	<div class="span1">
		<a href="/conference/edit/"""),_display_(Seq[Any](/*17.30*/conference/*17.40*/.id)),format.raw/*17.43*/("""" style="float:right;" class="btn" type="submit"><i class="icon-pencil"></i> Edit</a>
	</div>
	""")))})),format.raw/*19.3*/("""
</div>
<hr/>
<div class="row">
	<div class="span2">
		<div id="information_show">
    		<h5>"""),_display_(Seq[Any](/*25.12*/conference/*25.22*/.ctype.name)),format.raw/*25.33*/(""" on """),_display_(Seq[Any](/*25.38*/conference/*25.48*/.field.name)),format.raw/*25.59*/("""</h5>
			"""),_display_(Seq[Any](/*26.5*/if(!conference.subfields.isEmpty)/*26.38*/ {_display_(Seq[Any](format.raw/*26.40*/("""
			    <ul class="unstyled">
					"""),_display_(Seq[Any](/*28.7*/conference/*28.17*/.subfields.map/*28.31*/ { subField =>_display_(Seq[Any](format.raw/*28.45*/("""
					    <li><i class="icon-play"></i> """),_display_(Seq[Any](/*29.41*/subField/*29.49*/.name)),format.raw/*29.54*/("""</li>
					""")))})),format.raw/*30.7*/("""
				</ul>
			""")))})),format.raw/*32.5*/("""

			"""),_display_(Seq[Any](/*34.5*/if(!conference.relatedConferences.isEmpty)/*34.47*/ {_display_(Seq[Any](format.raw/*34.49*/("""
			    <h5>Related to:<h5>
			    <ul>
					"""),_display_(Seq[Any](/*37.7*/conference/*37.17*/.relatedConferences.map/*37.40*/ { relatedConference =>_display_(Seq[Any](format.raw/*37.63*/("""
					    <li><a href="/conference/"""),_display_(Seq[Any](/*38.36*/relatedConference/*38.53*/.id)),format.raw/*38.56*/("""">"""),_display_(Seq[Any](/*38.59*/relatedConference/*38.76*/.name)),format.raw/*38.81*/("""</a></li>
					""")))})),format.raw/*39.7*/("""
				</ul>
			""")))})),format.raw/*41.5*/("""

			"""),_display_(Seq[Any](/*43.5*/if(conference.yearSince.isDefined && conference.yearSince.get != 0)/*43.72*/ {_display_(Seq[Any](format.raw/*43.74*/("""
			<h5>First edition in """),_display_(Seq[Any](/*44.26*/conference/*44.36*/.yearSince)),format.raw/*44.46*/("""</h5>
			""")))})),format.raw/*45.5*/("""
			"""),_display_(Seq[Any](/*46.5*/if(conference.publisher.isDefined && conference.publisher.get.name != "")/*46.78*/ {_display_(Seq[Any](format.raw/*46.80*/("""
			    <h5>Published by """),_display_(Seq[Any](/*47.26*/conference/*47.36*/.publisher.get.name)),format.raw/*47.55*/("""</h5>
			""")))})),format.raw/*48.5*/("""
			
		</div>
	</div>
	<div class="span4">
        <p style="padding-right:20px;margin-left:0px;">"""),_display_(Seq[Any](/*53.57*/conference/*53.67*/.description)),format.raw/*53.79*/("""</p>
	</div>
	



	<div class="span2 well" style="padding:12px;margin:0px;">
		<h5>Scores</h5>
	    <div class="row">
	    	<div class="span1">Avg. Rank</div>
            <div class="span1">"""),_display_(Seq[Any](/*63.33*/snippets/*63.41*/.badge(conference.avgScore))),format.raw/*63.68*/("""</div>
		</div>
        <div class="row">
			"""),_display_(Seq[Any](/*66.5*/if(conference.avgScore.isDefined)/*66.38*/ {_display_(Seq[Any](format.raw/*66.40*/("""
			    <div class="span1">Avg. Score</div>
				<div class="span1"><h4>"""),_display_(Seq[Any](/*68.29*/snippets/*68.37*/.doubleDisplay(conference.avgScore.get))),format.raw/*68.76*/(""" / 5</h4></div>
			""")))})),format.raw/*69.5*/("""
		</div>
	    <div class="vertical-spacing-10"></div>
	    """),_display_(Seq[Any](/*72.7*/if(!conference.bibliometrics.isEmpty)/*72.44*/ {_display_(Seq[Any](format.raw/*72.46*/("""
	    <h5>Bibliometrics</h5>
	       """),_display_(Seq[Any](/*74.10*/conference/*74.20*/.bibliometrics.map/*74.38*/ { bibliometric =>_display_(Seq[Any](format.raw/*74.56*/("""
	       <div class="row">
            <div class="span1">"""),_display_(Seq[Any](/*76.33*/bibliometric/*76.45*/.name)),format.raw/*76.50*/("""</div>
            <div class="span1"><h4>"""),_display_(Seq[Any](/*77.37*/snippets/*77.45*/.doubleDisplay(bibliometric.value))),format.raw/*77.79*/("""</h4></div>
            </div>
	       """)))})),format.raw/*79.10*/("""
	    """)))})),format.raw/*80.7*/("""
		<div class="vertical-spacing-10"></div>
   <a href="#myModal" id="getTheBadge" class="btn">Get the Badge</a>
	</div>
</div>

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">Badge URL</h3>
  </div>
  <div class="modal-body">
    <p>Copy and paste this url to your webpage</p>
    <a id="widgetUrl" href="http://colour.org/wid/"""),_display_(Seq[Any](/*93.52*/conference/*93.62*/.id)),format.raw/*93.65*/("""/">http://colour.org/wid/"""),_display_(Seq[Any](/*93.91*/conference/*93.101*/.id)),format.raw/*93.104*/("""</a>
  </div>
  <div class="modal-footer">
    <button class="btn" id="selectUrl">Select URL</button>
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
  </div>
</div>"""))}
    }
    
    def render(conference:Conference,user:Option[User]) = apply(conference,user)
    
    def f:((Conference,Option[User]) => play.api.templates.Html) = (conference,user) => apply(conference,user)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/conferences/information.scala.html
                    HASH: 76b8038650fcbc5d7732b8ee38ee86a4baf80a94
                    MATRIX: 540->1|662->46|778->128|824->166|863->168|902->173|920->183|951->193|994->202|1012->212|1038->217|1064->227|1076->232|1114->233|1154->238|1173->248|1200->253|1235->257|1294->281|1321->299|1361->301|1448->352|1467->362|1492->365|1619->461|1749->555|1768->565|1801->576|1842->581|1861->591|1894->602|1939->612|1981->645|2021->647|2092->683|2111->693|2134->707|2186->721|2263->762|2280->770|2307->775|2350->787|2396->802|2437->808|2488->850|2528->852|2609->898|2628->908|2660->931|2721->954|2793->990|2819->1007|2844->1010|2883->1013|2909->1030|2936->1035|2983->1051|3029->1066|3070->1072|3146->1139|3186->1141|3248->1167|3267->1177|3299->1187|3340->1197|3380->1202|3462->1275|3502->1277|3564->1303|3583->1313|3624->1332|3665->1342|3800->1441|3819->1451|3853->1463|4080->1654|4097->1662|4146->1689|4227->1735|4269->1768|4309->1770|4417->1842|4434->1850|4495->1889|4546->1909|4642->1970|4688->2007|4728->2009|4802->2047|4821->2057|4848->2075|4904->2093|4999->2152|5020->2164|5047->2169|5126->2212|5143->2220|5199->2254|5271->2294|5309->2301|5893->2849|5912->2859|5937->2862|5999->2888|6019->2898|6045->2901
                    LINES: 19->1|22->1|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|36->15|36->15|36->15|38->17|38->17|38->17|40->19|46->25|46->25|46->25|46->25|46->25|46->25|47->26|47->26|47->26|49->28|49->28|49->28|49->28|50->29|50->29|50->29|51->30|53->32|55->34|55->34|55->34|58->37|58->37|58->37|58->37|59->38|59->38|59->38|59->38|59->38|59->38|60->39|62->41|64->43|64->43|64->43|65->44|65->44|65->44|66->45|67->46|67->46|67->46|68->47|68->47|68->47|69->48|74->53|74->53|74->53|84->63|84->63|84->63|87->66|87->66|87->66|89->68|89->68|89->68|90->69|93->72|93->72|93->72|95->74|95->74|95->74|95->74|97->76|97->76|97->76|98->77|98->77|98->77|100->79|101->80|114->93|114->93|114->93|114->93|114->93|114->93
                    -- GENERATED --
                */
            