
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
object mainAdmin extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,RequestHeader,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title : String, request: RequestHeader)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.57*/("""


<!DOCTYPE html>
<html lang="en">

<html>
    <head>
		<meta charset="utf-8">
        <title>"""),_display_(Seq[Any](/*10.17*/Application/*10.28*/.name)),format.raw/*10.33*/(""" - Admin</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="Collaborative Journals and Conferences Ranking">
		<meta name="author" content="Pierre-Nicolas Mougel">
		
		<!-- CSS files -->
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*16.48*/routes/*16.54*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*16.97*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*17.48*/routes/*17.54*/.Assets.at("stylesheets/bootstrap-responsive.min.css"))),format.raw/*17.108*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*18.54*/routes/*18.60*/.Assets.at("stylesheets/main.css"))),format.raw/*18.94*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*19.48*/routes/*19.54*/.Assets.at("stylesheets/prettify.css"))),format.raw/*19.92*/("""">

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

		<!-- Le fav and touch icons -->
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*27.59*/routes/*27.65*/.Assets.at("images/favicon_16.png"))),format.raw/*27.100*/("""">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
        <script src=""""),_display_(Seq[Any](/*32.23*/routes/*32.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*32.74*/("""" type="text/javascript"></script>
    </head>
    <body style="margin:0;padding:0;display: block;border: 0;outline: 0;background-color:#eee;overflow: hidden;">
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div style="padding-left:10px;">
                    <img src=""""),_display_(Seq[Any](/*38.32*/routes/*38.38*/.Assets.at("images/icon3.svg"))),format.raw/*38.68*/("""" />
                    <a class="brand" href="/">"""),_display_(Seq[Any](/*39.48*/Application/*39.59*/.name)),format.raw/*39.64*/(""" / Admin</a>
                    <a class="btn pull-right" style="margin-right:10px;"><i class="icon-off"></i> Logout</a>
                </div>
            </div>
        </div>
        <nav id="column1" style="position:absolute;display: block;width: 210px; background: #eee; border-right: 1px solid #606D78;top:40px;bottom:0;box-sizing: border-box;padding: 10px 0 0;">
            """),_display_(Seq[Any](/*45.14*/snippets/*45.22*/.actionsMenu(controllers.admin.Admin.actionsByCategory))),format.raw/*45.77*/("""
        </nav>
        <!-- <div id="column2" style="position: absolute;background-color:#C7D1D8;top:40px;left:210px;right:0px;bottom:0;overflow: auto;"> -->
        <div style="position: absolute;top:40px;left:210px;right:0px;height:39px;background-image:url('/assets/images/breadcrumb.png');background-repeat:repeat;padding-left:10px;border-bottom: 1px solid #606D78;">
            <h2 style="text-shadow: 1px 1px #E5E8EB;color:#556B7B;">"""),_display_(Seq[Any](/*49.70*/title)),format.raw/*49.75*/("""</h2>
        </div>
            <div style="position: absolute;top:80px;left:210px;right:0px;bottom:0;overflow: auto;background-color:#C7D1D8;">
                """),_display_(Seq[Any](/*52.18*/content)),format.raw/*52.25*/("""
            </div>
        </div>
        
		<!-- javascript ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
        <script src=""""),_display_(Seq[Any](/*58.23*/routes/*58.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*58.71*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*59.17*/routes/*59.23*/.Assets.at("javascripts/main.min.js"))),format.raw/*59.60*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*60.17*/routes/*60.23*/.Assets.at("javascripts/comments.min.js"))),format.raw/*60.64*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*61.17*/routes/*61.23*/.Assets.at("javascripts/links.min.js"))),format.raw/*61.61*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*62.17*/routes/*62.23*/.Assets.at("javascripts/jquery.timeago.js"))),format.raw/*62.66*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*63.17*/routes/*63.23*/.Assets.at("javascripts/prettify.js"))),format.raw/*63.60*/("""" type="text/javascript"></script>
    </body>
</html>
"""))}
    }
    
    def render(title:String,request:RequestHeader,content:Html) = apply(title,request)(content)
    
    def f:((String,RequestHeader) => (Html) => play.api.templates.Html) = (title,request) => (content) => apply(title,request)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 12:29:28 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/admin/mainAdmin.scala.html
                    HASH: 666c94d660b76c29498a69e8e1af326a1b1d4920
                    MATRIX: 534->1|666->56|798->152|818->163|845->168|1182->469|1197->475|1262->518|1348->568|1363->574|1440->628|1532->684|1547->690|1603->724|1689->774|1704->780|1764->818|2069->1087|2084->1093|2142->1128|2615->1565|2630->1571|2697->1616|3059->1942|3074->1948|3126->1978|3214->2030|3234->2041|3261->2046|3681->2430|3698->2438|3775->2493|4253->2935|4280->2940|4479->3103|4508->3110|4753->3319|4768->3325|4832->3367|4919->3418|4934->3424|4993->3461|5080->3512|5095->3518|5158->3559|5245->3610|5260->3616|5320->3654|5407->3705|5422->3711|5487->3754|5574->3805|5589->3811|5648->3848
                    LINES: 19->1|22->1|31->10|31->10|31->10|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|48->27|48->27|48->27|53->32|53->32|53->32|59->38|59->38|59->38|60->39|60->39|60->39|66->45|66->45|66->45|70->49|70->49|73->52|73->52|79->58|79->58|79->58|80->59|80->59|80->59|81->60|81->60|81->60|82->61|82->61|82->61|83->62|83->62|83->62|84->63|84->63|84->63
                    -- GENERATED --
                */
            