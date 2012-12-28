
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
object comments extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Comment],Option[User],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(comments: List[Comment], user: Option[User]):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.47*/("""

"""),format.raw/*5.1*/("""
<!-- Comments -->
<div class="vertical-spacing-20"></div>
<div class="row">
	<div class="span8"><h3>Comments (<span id="nb_comments">"""),_display_(Seq[Any](/*9.59*/comments/*9.67*/.size)),format.raw/*9.72*/("""</span>)</h3></div>
    <div>
    """),_display_(Seq[Any](/*11.6*/if(user.isDefined)/*11.24*/ {_display_(Seq[Any](format.raw/*11.26*/("""
    	<div class="vertical-spacing-30"></div>
    	<form class="well span8" id="add_comment_form" style="padding:1px;">
            <textarea class="input span8" id="comment_field" rows="1" placeholder="Add a comment..." style="margin-bottom:0px;"></textarea>
			<button class="btn btn-mini" id="submit_add_comment" style="display:none;margin-top:5px;"><i class="icon-pencil"></i> Post</button>
		</form>
	""")))})),format.raw/*17.3*/("""
	</div>
</div>

<!-- List of comments -->
<ul class="unstyled" id="confComments">
    <p id="noComments" """),_display_(Seq[Any](/*23.25*/if(!comments.isEmpty)/*23.46*/ {_display_(Seq[Any](format.raw/*23.48*/(""" style="display:none;" """)))})),format.raw/*23.72*/(""">No comments to display</p>
<div class="vertical-spacing-10"></div>
	"""),_display_(Seq[Any](/*25.3*/comments/*25.11*/.map/*25.15*/ { comment =>_display_(Seq[Any](format.raw/*25.28*/(""" 
   		"""),_display_(Seq[Any](/*26.7*/snippets/*26.15*/.comment(comment, user))),format.raw/*26.38*/("""
    """)))})),format.raw/*27.6*/("""
</ul>"""))}
    }
    
    def render(comments:List[Comment],user:Option[User]) = apply(comments,user)
    
    def f:((List[Comment],Option[User]) => play.api.templates.Html) = (comments,user) => apply(comments,user)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/conferences/comments.scala.html
                    HASH: c9679dab92f8ef26dfb420152db9155ab0612f50
                    MATRIX: 540->1|712->46|740->99|910->234|926->242|952->247|1022->282|1049->300|1089->302|1527->709|1670->816|1700->837|1740->839|1796->863|1901->933|1918->941|1931->945|1982->958|2025->966|2042->974|2087->997|2124->1003
                    LINES: 19->1|25->1|27->5|31->9|31->9|31->9|33->11|33->11|33->11|39->17|45->23|45->23|45->23|45->23|47->25|47->25|47->25|47->25|48->26|48->26|48->26|49->27
                    -- GENERATED --
                */
            