
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
object results extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,List[scala.Tuple2[Conference, Double]],Long,RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(query: String, conferences : List[(Conference, Double)], nbResults : Long)(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.110*/("""

"""),_display_(Seq[Any](/*3.2*/main(request)/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
    <div class="container">
		"""),_display_(Seq[Any](/*5.4*/if(conferences.size == 0)/*5.29*/ {_display_(Seq[Any](format.raw/*5.31*/("""
		<div class="vertical-spacing-150"></div>
		""")))}/*7.5*/else/*7.10*/{_display_(Seq[Any](format.raw/*7.11*/("""
		<div class="vertical-spacing-30"></div>
		""")))})),format.raw/*9.4*/("""

        <div class="row">
			"""),_display_(Seq[Any](/*12.5*/if(conferences.size == 0)/*12.30*/ {_display_(Seq[Any](format.raw/*12.32*/("""
		    <div class="span6 offset4">
				<h1 style="font-size: 45pt">Sorry,</h1>
                <div class="vertical-spacing-30"></div>
                <p>No conference or journal matched your query</p>
			""")))}/*17.6*/else/*17.11*/{_display_(Seq[Any](format.raw/*17.12*/("""
		    <div class="span6 offset3">
				<h4>Your query "<span style="font-size:14pt">"""),_display_(Seq[Any](/*19.51*/query)),format.raw/*19.56*/("""</span>" matched<span style="font-size:14pt"> """),_display_(Seq[Any](/*19.103*/nbResults)),format.raw/*19.112*/("""</span> results</h4>
				"""),_display_(Seq[Any](/*20.6*/if(nbResults > 200)/*20.25*/ {_display_(Seq[Any](format.raw/*20.27*/("""
				    For performance reasons, only the first 200 results are available
				""")))})),format.raw/*22.6*/("""
				<div class="vertical-spacing-30"></div>
				<div id="page_container">
	                <ul class="content unstyled">
	                """),_display_(Seq[Any](/*26.19*/conferences/*26.30*/.map/*26.34*/ { case (conference, matchingScore) =>_display_(Seq[Any](format.raw/*26.72*/("""
	                    """),_display_(Seq[Any](/*27.23*/snippets/*27.31*/.conferenceResult(conference))),format.raw/*27.60*/("""
	                """)))})),format.raw/*28.19*/("""
	                </ul>
	                <span class="page_navigation pagination "></span>
                </div>
                <div class="vertical-spacing-30"></div>
                <p>You tried to find a conference or a journal and its not here ?</p>
            """)))})),format.raw/*34.14*/("""
                <button class="btn btn-primary btn-large" type="submit" id="btn_show_new_conf">Add a new one</button>
                <div class="vertical-spacing-20"></div>
                """),_display_(Seq[Any](/*37.18*/helper/*37.24*/.form(routes.Publication.addPublication, 
                    'class -> "well form-horizontal", 
                    'id -> "form_new_conf", 
                    'style -> "display:none;")/*40.47*/ {_display_(Seq[Any](format.raw/*40.49*/("""
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label"  for="fullName">Full Name</label>
                            <div class="controls">
                                <input type="text" class="input" id="fullName" name="fullName" value=""""),_display_(Seq[Any](/*45.104*/query)),format.raw/*45.109*/("""">
                                <p class="help-block">e.g., Very Large Data Bases</p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="shortName">Short Name</label>
                            <div class="controls">
                                <input type="text" class="input" id="shortName" name="shortName" placeholder="Short name">
                                <p class="help-block">e.g., VLDB</p> 
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="type" >Type</label>
                            <div class="controls">
                                <select id="type" name="type" >
                    				"""),_display_(Seq[Any](/*60.26*/CType/*60.31*/.all().map/*60.41*/ { ctype =>_display_(Seq[Any](format.raw/*60.52*/("""
                    				    <option value=""""),_display_(Seq[Any](/*61.45*/ctype/*61.50*/.id)),format.raw/*61.53*/("""">"""),_display_(Seq[Any](/*61.56*/ctype/*61.61*/.name)),format.raw/*61.66*/("""</option>
                    				""")))})),format.raw/*62.26*/("""
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="field">Field</label>
                            <div class="controls">
                                <select id="field" name="field" >
                                    """),_display_(Seq[Any](/*70.38*/models/*70.44*/.Field.all().map/*70.60*/ { field =>_display_(Seq[Any](format.raw/*70.71*/("""
                                        <option value=""""),_display_(Seq[Any](/*71.57*/field/*71.62*/.id)),format.raw/*71.65*/("""">"""),_display_(Seq[Any](/*71.68*/field/*71.73*/.name)),format.raw/*71.78*/("""</option>
                                    """)))})),format.raw/*72.38*/("""
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn">Create</button>
                            </div>
                        </div>
                    </fieldset>
                """)))})),format.raw/*82.18*/("""
                <p>Or try a new search</p>
                """),_display_(Seq[Any](/*84.18*/snippets/*84.26*/.search())),format.raw/*84.35*/("""
            </div>
        </div>
    </div>
    <script src=""""),_display_(Seq[Any](/*88.19*/routes/*88.25*/.Assets.at("javascripts/jquery.pajinate.js"))),format.raw/*88.69*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*89.19*/routes/*89.25*/.Assets.at("javascripts/search.min.js"))),format.raw/*89.64*/("""" type="text/javascript"></script>
""")))})))}
    }
    
    def render(query:String,conferences:List[scala.Tuple2[Conference, Double]],nbResults:Long,request:RequestHeader) = apply(query,conferences,nbResults)(request)
    
    def f:((String,List[scala.Tuple2[Conference, Double]],Long) => (RequestHeader) => play.api.templates.Html) = (query,conferences,nbResults) => (request) => apply(query,conferences,nbResults)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:08 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/results.scala.html
                    HASH: ff663a2838e5dc9659270beafa6ddeb24a12b1a0
                    MATRIX: 565->1|751->109|788->112|809->125|848->127|914->159|947->184|986->186|1050->234|1062->239|1100->240|1176->286|1243->318|1277->343|1317->345|1541->552|1554->557|1593->558|1714->643|1741->648|1825->695|1857->704|1918->730|1946->749|1986->751|2097->831|2273->971|2293->982|2306->986|2382->1024|2441->1047|2458->1055|2509->1084|2560->1103|2861->1372|3089->1564|3104->1570|3301->1758|3341->1760|3707->2089|3735->2094|4654->2977|4668->2982|4687->2992|4736->3003|4817->3048|4831->3053|4856->3056|4895->3059|4909->3064|4936->3069|5003->3104|5437->3502|5452->3508|5477->3524|5526->3535|5619->3592|5633->3597|5658->3600|5697->3603|5711->3608|5738->3613|5817->3660|6258->4069|6355->4130|6372->4138|6403->4147|6503->4211|6518->4217|6584->4261|6673->4314|6688->4320|6749->4359
                    LINES: 19->1|22->1|24->3|24->3|24->3|26->5|26->5|26->5|28->7|28->7|28->7|30->9|33->12|33->12|33->12|38->17|38->17|38->17|40->19|40->19|40->19|40->19|41->20|41->20|41->20|43->22|47->26|47->26|47->26|47->26|48->27|48->27|48->27|49->28|55->34|58->37|58->37|61->40|61->40|66->45|66->45|81->60|81->60|81->60|81->60|82->61|82->61|82->61|82->61|82->61|82->61|83->62|91->70|91->70|91->70|91->70|92->71|92->71|92->71|92->71|92->71|92->71|93->72|103->82|105->84|105->84|105->84|109->88|109->88|109->88|110->89|110->89|110->89
                    -- GENERATED --
                */
            