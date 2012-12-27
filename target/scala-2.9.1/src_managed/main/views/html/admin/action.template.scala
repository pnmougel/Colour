
package views.html.admin

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
object action extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[controllers.admin.action.AdminAction,RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(action : controllers.admin.action.AdminAction)(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._

import controllers.admin.action._

import controllers.admin.form._


Seq[Any](format.raw/*1.82*/("""

"""),format.raw/*7.1*/("""
    
"""),_display_(Seq[Any](/*9.2*/mainAdmin(action.label, request)/*9.34*/ {_display_(Seq[Any](format.raw/*9.36*/("""
	<div style="background-color:#9BA5AD;border-bottom:1px solid #556B7B;padding:4px;padding-left:20px;padding-right:20px;">
		<a href="#" class="btn" id="run" action=""""),_display_(Seq[Any](/*11.45*/action/*11.51*/.name)),format.raw/*11.56*/(""""><i class="icon-play"></i> Run</a>
		<div class="progress pull-right" style="width:150px;margin-top:4px;">
		  	<div id="actionProgress" class="bar" style="width: 0%;"></div>
		</div>
	</div>

	<div style="margin:20px;margin-right:20px;margin-top:0px;" id="mainContent">
	    """),_display_(Seq[Any](/*18.7*/snippets/*18.15*/.frame("Description", "icon-leaf")(Html(action.description)))),format.raw/*18.75*/("""
		"""),_display_(Seq[Any](/*19.4*/snippets/*19.12*/.options(action.form))),format.raw/*19.33*/("""
		"""),_display_(Seq[Any](/*20.4*/snippets/*20.12*/.frame("Messages", "icon-comment")(Html("""<div id="message_area"></div>""")))),format.raw/*20.89*/("""
	</div>
    
	<script src=""""),_display_(Seq[Any](/*23.16*/routes/*23.22*/.Assets.at("javascripts/clientServer.min.js"))),format.raw/*23.67*/("""" type="text/javascript"></script>
""")))})))}
    }
    
    def render(action:controllers.admin.action.AdminAction,request:RequestHeader) = apply(action)(request)
    
    def f:((controllers.admin.action.AdminAction) => (RequestHeader) => play.api.templates.Html) = (action) => (request) => apply(action)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 15:14:03 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/admin/action.scala.html
                    HASH: f5481d77cf7d91a65d39a35e4982d71d42230919
                    MATRIX: 556->1|831->81|859->202|900->209|940->241|979->243|1182->410|1197->416|1224->421|1537->699|1554->707|1636->767|1675->771|1692->779|1735->800|1774->804|1791->812|1890->889|1955->918|1970->924|2037->969
                    LINES: 19->1|29->1|31->7|33->9|33->9|33->9|35->11|35->11|35->11|42->18|42->18|42->18|43->19|43->19|43->19|44->20|44->20|44->20|47->23|47->23|47->23
                    -- GENERATED --
                */
            