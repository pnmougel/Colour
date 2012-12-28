
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
object comment extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Comment,Option[User],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(comment: Comment, user: Option[User]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.40*/("""

<li id="comment_"""),_display_(Seq[Any](/*3.18*/comment/*3.25*/.id)),format.raw/*3.28*/("""">
	<div class="row">
		<div class="span7" style="margin-bottom: 5px;padding-left:10px;">
			<h6><time class="timeago" datetime=""""),_display_(Seq[Any](/*6.41*/comment/*6.48*/.isoDate)),format.raw/*6.56*/(""""></time>
			"""),_display_(Seq[Any](/*7.5*/if(comment.user.isPublic)/*7.30*/ {_display_(Seq[Any](format.raw/*7.32*/(""" 
			 by """),_display_(Seq[Any](/*8.9*/comment/*8.16*/.user.pseudo.get)),format.raw/*8.32*/("""
			 """)))})),format.raw/*9.6*/(""" :</h6>
		</div>
		<div class="well span8" style="padding:5px;padding-left:10px;margin-bottom: 15px;">
			"""),_display_(Seq[Any](/*12.5*/if(user.getOrElse(None) == comment.user)/*12.45*/ {_display_(Seq[Any](format.raw/*12.47*/("""
			<a class="close" href="#" onclick="deleteComment("""),_display_(Seq[Any](/*13.54*/comment/*13.61*/.id)),format.raw/*13.64*/(""");return false;">&times;</a>
			""")))})),format.raw/*14.5*/("""
			<span>"""),_display_(Seq[Any](/*15.11*/comment/*15.18*/.content)),format.raw/*15.26*/("""</span>
		</div>
	</div>
</li>

"""))}
    }
    
    def render(comment:Comment,user:Option[User]) = apply(comment,user)
    
    def f:((Comment,Option[User]) => play.api.templates.Html) = (comment,user) => apply(comment,user)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/comment.scala.html
                    HASH: e0da4de919702847f69e0e3edaf834587ae2e8d8
                    MATRIX: 530->1|645->39|699->58|714->65|738->68|903->198|918->205|947->213|995->227|1028->252|1067->254|1111->264|1126->271|1163->287|1199->293|1341->400|1390->440|1430->442|1520->496|1536->503|1561->506|1625->539|1672->550|1688->557|1718->565
                    LINES: 19->1|22->1|24->3|24->3|24->3|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|33->12|33->12|33->12|34->13|34->13|34->13|35->14|36->15|36->15|36->15
                    -- GENERATED --
                */
            