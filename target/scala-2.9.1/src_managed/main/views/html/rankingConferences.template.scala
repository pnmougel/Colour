
package views.html

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
object rankingConferences extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[scala.Tuple2[Conference, Int]],Int,Int,Double,String,RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(conferences : List[(Conference, Int)], startIdx : Int, pageNum : Int, pageMax : Double, nameFilter : String)(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.144*/("""
<input type="hidden" id="pageNum" value=""""),_display_(Seq[Any](/*2.43*/pageNum)),format.raw/*2.50*/("""">

<div style="height:540px;">
"""),_display_(Seq[Any](/*5.2*/conferences/*5.13*/.map/*5.17*/ { case (conference, idx) =>_display_(Seq[Any](format.raw/*5.45*/("""
<div class="row confRank" style="margin-bottom:10px;">
	<div class="span1 offset1 rankOrder" style="font-size:12pt;font-weight:bold;text-align:right;"><span style="font-size:12pt;">
	"""),_display_(Seq[Any](/*8.3*/{if(nameFilter.trim().isEmpty) idx + startIdx else idx + 1})),format.raw/*8.62*/("""</span></div>
	<!-- <div class="span5" style="border-left:4px solid #088BCD;margin-left: 21px;padding-left: 5px;"> -->
	<div class="span5" style="margin-left: 0px;margin-left: 26px;padding-left: 5px;height:45px;">
		<h4 style="font-size:10pt;">
			<a href="/conference/"""),_display_(Seq[Any](/*12.26*/conference/*12.36*/.id)),format.raw/*12.39*/("""">
	    		"""),_display_(Seq[Any](/*13.9*/conference/*13.19*/.name)),format.raw/*13.24*/(""" 
    			"""),_display_(Seq[Any](/*14.9*/if(conference.shortName != "")/*14.39*/ {_display_(Seq[Any](format.raw/*14.41*/(""" ("""),_display_(Seq[Any](/*14.44*/conference/*14.54*/.shortName)),format.raw/*14.64*/(""") """)))})),format.raw/*14.67*/("""
	    	</a>
		</h4>
	    <h6>"""),_display_(Seq[Any](/*17.11*/conference/*17.21*/.ctype.name)),format.raw/*17.32*/(""" on """),_display_(Seq[Any](/*17.37*/conference/*17.47*/.field.name)),format.raw/*17.58*/("""</h6>
	</div>
	<div class="span1" style="text-align:right;">
	    <h5 style="font-size:12pt;">
	    """),_display_(Seq[Any](/*21.7*/if(conference.userScore.isDefined)/*21.41*/ {_display_(Seq[Any](format.raw/*21.43*/("""
	    	"""),_display_(Seq[Any](/*22.8*/snippets/*22.16*/.doubleDisplay(conference.userScore.get))),format.raw/*22.56*/("""
	    """)))}/*23.8*/else/*23.13*/{_display_(Seq[Any](format.raw/*23.14*/("""
	    	-&nbsp; 
	    """)))})),format.raw/*25.7*/("""
	    <h5>
	   </div>
	<div class="span1" style="text-align:right;">
	   	<h5 style="font-size:12pt;">
	   	"""),_display_(Seq[Any](/*30.7*/if(conference.externalScore.isDefined)/*30.45*/ {_display_(Seq[Any](format.raw/*30.47*/("""
	   		"""),_display_(Seq[Any](/*31.8*/snippets/*31.16*/.doubleDisplay(conference.externalScore.get))),format.raw/*31.60*/("""
	   	""")))}/*32.8*/else/*32.13*/{_display_(Seq[Any](format.raw/*32.14*/("""
	   		-&nbsp; 
	   	""")))})),format.raw/*34.7*/("""
	    <h5>
	</div>
	<div class="span1" style="text-align:right;">
	   	<h5 style="font-size:12pt;">
	   	"""),_display_(Seq[Any](/*39.7*/if(conference.avgScore.isDefined)/*39.40*/ {_display_(Seq[Any](format.raw/*39.42*/("""
	   		"""),_display_(Seq[Any](/*40.8*/snippets/*40.16*/.doubleDisplay(conference.avgScore.get))),format.raw/*40.55*/("""
	   	""")))}/*41.8*/else/*41.13*/{_display_(Seq[Any](format.raw/*41.14*/("""
	   		-&nbsp; 
	   	""")))})),format.raw/*43.7*/("""
	   	<h5>
	</div>
</div>
""")))})),format.raw/*47.2*/("""
</div>
<div class="pagination offset2 span8" style="margin-left: 200px;">
	<ul id="pagination">
		 <li class=""""),_display_(Seq[Any](/*51.16*/if(pageNum == 1)/*51.32*/ {_display_(Seq[Any](format.raw/*51.34*/("""disabled""")))})),format.raw/*51.43*/(""""><a href="#" onclick="getPage(1);">&laquo</a></li>
		 <li class=""""),_display_(Seq[Any](/*52.16*/if(pageNum == 1)/*52.32*/ {_display_(Seq[Any](format.raw/*52.34*/("""disabled""")))})),format.raw/*52.43*/(""""><a href="#" onclick="getPage("""),_display_(Seq[Any](/*52.75*/{scala.math.max(1, pageNum - 1).toInt})),format.raw/*52.113*/(""");">Prev</a></li>
		
		 """),_display_(Seq[Any](/*54.5*/scala/*54.10*/.math.max(1, pageNum -  3).until(math.min(scala.math.max(1, pageNum -  3) + 7, pageMax.toInt + 1)).map/*54.112*/ { p =>_display_(Seq[Any](format.raw/*54.119*/("""
			<li class=""""),_display_(Seq[Any](/*55.16*/if(pageNum == p)/*55.32*/ {_display_(Seq[Any](format.raw/*55.34*/("""disabled""")))})),format.raw/*55.43*/(""""><a href="#" onclick="getPage("""),_display_(Seq[Any](/*55.75*/p)),format.raw/*55.76*/(""");">"""),_display_(Seq[Any](/*55.81*/p)),format.raw/*55.82*/("""</a></li>
		""")))})),format.raw/*56.4*/("""

		 <li class=""""),_display_(Seq[Any](/*58.16*/if(pageNum == pageMax)/*58.38*/ {_display_(Seq[Any](format.raw/*58.40*/("""disabled""")))})),format.raw/*58.49*/(""""><a href="#" onclick="getPage("""),_display_(Seq[Any](/*58.81*/{scala.math.min(pageMax, pageNum + 1).toInt})),format.raw/*58.125*/(""");">Next</a></li>
		 <li class=""""),_display_(Seq[Any](/*59.16*/if(pageNum == pageMax)/*59.38*/ {_display_(Seq[Any](format.raw/*59.40*/("""disabled""")))})),format.raw/*59.49*/(""""><a href="#" onclick="getPage("""),_display_(Seq[Any](/*59.81*/pageMax)),format.raw/*59.88*/(""");">&raquo</a></li>
	</ul>

	<div class="input-append" style="float:right;">
	  <input class="span2" placeholder="Filter" id="nameFilter" value=""""),_display_(Seq[Any](/*63.70*/nameFilter)),format.raw/*63.80*/("""" size="16" type="text">
	  <button class="btn" type="button" onclick="getPage("""),_display_(Seq[Any](/*64.56*/pageNum)),format.raw/*64.63*/(""");"><i class="icon-refresh"></i></button>
	</div>
</div>


"""))}
    }
    
    def render(conferences:List[scala.Tuple2[Conference, Int]],startIdx:Int,pageNum:Int,pageMax:Double,nameFilter:String,request:RequestHeader) = apply(conferences,startIdx,pageNum,pageMax,nameFilter)(request)
    
    def f:((List[scala.Tuple2[Conference, Int]],Int,Int,Double,String) => (RequestHeader) => play.api.templates.Html) = (conferences,startIdx,pageNum,pageMax,nameFilter) => (request) => apply(conferences,startIdx,pageNum,pageMax,nameFilter)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:08 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/rankingConferences.scala.html
                    HASH: 29fd01562d45fb1cd2d27ef1af816ca23be4f811
                    MATRIX: 583->1|803->143|881->186|909->193|976->226|995->237|1007->241|1072->269|1291->454|1371->513|1677->783|1696->793|1721->796|1767->807|1786->817|1813->822|1858->832|1897->862|1937->864|1976->867|1995->877|2027->887|2062->890|2128->920|2147->930|2180->941|2221->946|2240->956|2273->967|2409->1068|2452->1102|2492->1104|2535->1112|2552->1120|2614->1160|2639->1168|2652->1173|2691->1174|2744->1196|2888->1305|2935->1343|2975->1345|3018->1353|3035->1361|3101->1405|3126->1413|3139->1418|3178->1419|3231->1441|3372->1547|3414->1580|3454->1582|3497->1590|3514->1598|3575->1637|3600->1645|3613->1650|3652->1651|3705->1673|3763->1700|3911->1812|3936->1828|3976->1830|4017->1839|4120->1906|4145->1922|4185->1924|4226->1933|4294->1965|4355->2003|4415->2028|4429->2033|4541->2135|4587->2142|4639->2158|4664->2174|4704->2176|4745->2185|4813->2217|4836->2218|4877->2223|4900->2224|4944->2237|4997->2254|5028->2276|5068->2278|5109->2287|5177->2319|5244->2363|5313->2396|5344->2418|5384->2420|5425->2429|5493->2461|5522->2468|5704->2614|5736->2624|5852->2704|5881->2711
                    LINES: 19->1|22->1|23->2|23->2|26->5|26->5|26->5|26->5|29->8|29->8|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|35->14|35->14|35->14|35->14|38->17|38->17|38->17|38->17|38->17|38->17|42->21|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|46->25|51->30|51->30|51->30|52->31|52->31|52->31|53->32|53->32|53->32|55->34|60->39|60->39|60->39|61->40|61->40|61->40|62->41|62->41|62->41|64->43|68->47|72->51|72->51|72->51|72->51|73->52|73->52|73->52|73->52|73->52|73->52|75->54|75->54|75->54|75->54|76->55|76->55|76->55|76->55|76->55|76->55|76->55|76->55|77->56|79->58|79->58|79->58|79->58|79->58|79->58|80->59|80->59|80->59|80->59|80->59|80->59|84->63|84->63|85->64|85->64
                    -- GENERATED --
                */
            