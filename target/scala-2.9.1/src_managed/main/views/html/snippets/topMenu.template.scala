
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
object topMenu extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(request: RequestHeader):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.26*/("""
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<a class="brand" href="/">"""),_display_(Seq[Any](/*11.33*/Application/*11.44*/.name)),format.raw/*11.49*/("""</a>
					<div class="pull-left">
						<a id="btn_show_login" class="btn"  
                        """),_display_(Seq[Any](/*14.26*/if(!request.session.get("userKey").getOrElse("").isEmpty)/*14.83*/ {_display_(Seq[Any](format.raw/*14.85*/("""
                            style="display:none;"
                        """)))})),format.raw/*16.26*/("""
                             href="#">
                                <i class="icon-user"></i> 
                                Login
                        </a>
					</div>
					<div class="btn-group pull-left">  
						<a id="btn_show_logout" class="btn dropdown-toggle logged" data-toggle="dropdown"
						"""),_display_(Seq[Any](/*24.8*/{println(request.session.get("userKey").getOrElse(""))})),format.raw/*24.63*/("""
						"""),_display_(Seq[Any](/*25.8*/if(request.session.get("userKey").getOrElse("").isEmpty)/*25.64*/ {_display_(Seq[Any](format.raw/*25.66*/("""
                            style="display:none;"
                            """)))})),format.raw/*27.30*/("""
                            
                             href="#">
              					<i class="icon-user"></i> 
              					Logged
                                <span class="caret"></span>
            				</a>
                            <ul class="dropdown-menu logged">
                            	<li><a href="#">Profile</a></li>
                            	<li class="divider"></li>
                            	<li><a href="#" id="logout">Sign Out</a></li>
                            </ul>
          				</div>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Rankings by Field<b class="caret"></b></a>
							<ul class="dropdown-menu">
								"""),_display_(Seq[Any](/*43.10*/models/*43.16*/.Field.all().map/*43.32*/ { field =>_display_(Seq[Any](format.raw/*43.43*/("""
								    <li><a href="/ranking/field/"""),_display_(Seq[Any](/*44.42*/field/*44.47*/.id)),format.raw/*44.50*/("""">"""),_display_(Seq[Any](/*44.53*/field/*44.58*/.name)),format.raw/*44.63*/("""</a></li>
								""")))})),format.raw/*45.10*/("""
							</ul>
                        </li>
						<li><a href="/page/widget">Widget</a></li>
                        <li><a href="/ideabox">Idea Box</a></li>
						<li><a href="/help/about">Help</a></li>
						
						<!-- 
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Help <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="/page/help">Help</a></li>
								<li><a href="/page/about">About</a></li>
							</ul>
                        </li>
                         -->
		                
                        
					</ul>
					<ul class="nav pull-right">
						"""),_display_(Seq[Any](/*64.8*/helper/*64.14*/.form(routes.Search.search, 'class -> "navbar-form pull-left")/*64.76*/ {_display_(Seq[Any](format.raw/*64.78*/("""
                            <input type="hidden" name="shortName" id="shortName" value="" />
                            <input type="hidden" name="type" id="type" value="-1" />
                            <input type="hidden" name="field" id="field" value="-1" />
								<input type="text" id="query" name="query" value="" class="span2 typeAhead" placeholder="Search">
						""")))})),format.raw/*69.8*/("""
						<li class="divider-vertical"></li>
						<li style="padding: 5px;"><img src=""""),_display_(Seq[Any](/*71.44*/routes/*71.50*/.Assets.at("images/icon3.svg"))),format.raw/*71.80*/("""" /></li>
					</ul>
				</div>
			</div>
		</div>
	</div>"""))}
    }
    
    def render(request:RequestHeader) = apply(request)
    
    def f:((RequestHeader) => play.api.templates.Html) = (request) => apply(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/topMenu.scala.html
                    HASH: 85868f8d9857500229a6b827f6b048f16dc54ea4
                    MATRIX: 523->1|624->25|1028->393|1048->404|1075->409|1213->511|1279->568|1319->570|1427->646|1776->960|1853->1015|1896->1023|1961->1079|2001->1081|2113->1161|2859->1871|2874->1877|2899->1893|2948->1904|3026->1946|3040->1951|3065->1954|3104->1957|3118->1962|3145->1967|3196->1986|3868->2623|3883->2629|3954->2691|3994->2693|4404->3072|4525->3157|4540->3163|4592->3193
                    LINES: 19->1|22->1|32->11|32->11|32->11|35->14|35->14|35->14|37->16|45->24|45->24|46->25|46->25|46->25|48->27|64->43|64->43|64->43|64->43|65->44|65->44|65->44|65->44|65->44|65->44|66->45|85->64|85->64|85->64|85->64|90->69|92->71|92->71|92->71
                    -- GENERATED --
                */
            