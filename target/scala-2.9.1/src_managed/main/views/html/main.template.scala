
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[RequestHeader,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(request: RequestHeader)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""

<!DOCTYPE html>
<html lang="en">

<html>
    <head>
		<meta charset="utf-8">
        <title>"""),_display_(Seq[Any](/*9.17*/Application/*9.28*/.name)),format.raw/*9.33*/("""</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="Collaborative Journals and Conferences Ranking">
		<meta name="author" content="Pierre-Nicolas Mougel">
		
		<!-- CSS files -->
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*15.48*/routes/*15.54*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*15.97*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*16.48*/routes/*16.54*/.Assets.at("stylesheets/bootstrap-responsive.min.css"))),format.raw/*16.108*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*17.54*/routes/*17.60*/.Assets.at("stylesheets/main.css"))),format.raw/*17.94*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*18.48*/routes/*18.54*/.Assets.at("stylesheets/prettify.css"))),format.raw/*18.92*/("""">
		
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*20.48*/routes/*20.54*/.Assets.at("stylesheets/help.css"))),format.raw/*20.88*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*21.54*/routes/*21.60*/.Assets.at("stylesheets/widget.css"))),format.raw/*21.96*/("""">

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

		<!-- Le fav and touch icons -->
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*29.59*/routes/*29.65*/.Assets.at("images/favicon_16.png"))),format.raw/*29.100*/("""">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
        <script src=""""),_display_(Seq[Any](/*34.23*/routes/*34.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*34.74*/("""" type="text/javascript"></script>
    </head>
    <body>
		<!-- Comments -->
		"""),_display_(Seq[Any](/*38.4*/snippets/*38.12*/.topMenu(request))),format.raw/*38.29*/("""
		
		<!-- Message Area and Login Form -->
		<div id="messageAreaTop">
			<form class="well form-inline" id="form_login" style="display:none;margin-bottom:0px;" method="POST" action="/user/add">
				<input type="text" class="input" placeholder="Email" id="email" name="email">
				<input type="password" class="input-small" placeholder="Password" id="password" name="password">
				<a href="#" class="btn" id="form_login_sign_in">Sign in</a>
				or
				<a href="#" class="btn" id="form_login_add_user">Create Account</a>
			</form>
		</div>
		"""),_display_(Seq[Any](/*50.4*/content)),format.raw/*50.11*/("""
        <div id="footer">
            by <a href="">Pierre-Nicolas Mougel</a> and <a href="">Arnaud Renard</a>
        </div>
        
		<!-- javascript ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src=""""),_display_(Seq[Any](/*57.17*/routes/*57.23*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*57.65*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*58.17*/routes/*58.23*/.Assets.at("javascripts/jquery.eComboBox.js"))),format.raw/*58.68*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*59.17*/routes/*59.23*/.Assets.at("javascripts/main.min.js"))),format.raw/*59.60*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*60.17*/routes/*60.23*/.Assets.at("javascripts/comments.min.js"))),format.raw/*60.64*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*61.17*/routes/*61.23*/.Assets.at("javascripts/links.min.js"))),format.raw/*61.61*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*62.17*/routes/*62.23*/.Assets.at("javascripts/scores.min.js"))),format.raw/*62.62*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*63.17*/routes/*63.23*/.Assets.at("javascripts/publisher.min.js"))),format.raw/*63.65*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*64.17*/routes/*64.23*/.Assets.at("javascripts/authentification.min.js"))),format.raw/*64.72*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*65.17*/routes/*65.23*/.Assets.at("javascripts/jquery.timeago.js"))),format.raw/*65.66*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*66.17*/routes/*66.23*/.Assets.at("javascripts/prettify.js"))),format.raw/*66.60*/("""" type="text/javascript"></script>
    </body>
</html>
"""))}
    }
    
    def render(request:RequestHeader,content:Html) = apply(request)(content)
    
    def f:((RequestHeader) => (Html) => play.api.templates.Html) = (request) => (content) => apply(request)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 25 17:35:28 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/main.scala.html
                    HASH: 1e78547d82477f0c430d73e6a8a9a8e2f43e282d
                    MATRIX: 516->1|632->40|762->135|781->146|807->151|1136->444|1151->450|1216->493|1302->543|1317->549|1394->603|1486->659|1501->665|1557->699|1643->749|1658->755|1718->793|1807->846|1822->852|1878->886|1970->942|1985->948|2043->984|2348->1253|2363->1259|2421->1294|2894->1731|2909->1737|2976->1782|3092->1863|3109->1871|3148->1888|3727->2432|3756->2439|4087->2734|4102->2740|4166->2782|4253->2833|4268->2839|4335->2884|4422->2935|4437->2941|4496->2978|4583->3029|4598->3035|4661->3076|4748->3127|4763->3133|4823->3171|4910->3222|4925->3228|4986->3267|5073->3318|5088->3324|5152->3366|5239->3417|5254->3423|5325->3472|5412->3523|5427->3529|5492->3572|5579->3623|5594->3629|5653->3666
                    LINES: 19->1|22->1|30->9|30->9|30->9|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|41->20|41->20|41->20|42->21|42->21|42->21|50->29|50->29|50->29|55->34|55->34|55->34|59->38|59->38|59->38|71->50|71->50|78->57|78->57|78->57|79->58|79->58|79->58|80->59|80->59|80->59|81->60|81->60|81->60|82->61|82->61|82->61|83->62|83->62|83->62|84->63|84->63|84->63|85->64|85->64|85->64|86->65|86->65|86->65|87->66|87->66|87->66
                    -- GENERATED --
                */
            