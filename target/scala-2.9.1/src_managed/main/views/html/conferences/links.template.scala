
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
object links extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Link],Option[User],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(links: List[Link], user: Option[User]):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.41*/("""

"""),format.raw/*5.1*/("""
<!-- Links -->
<div class="row">
	<div class="span7"><h3>Links</h3></div>
	"""),_display_(Seq[Any](/*9.3*/if(user.isDefined)/*9.21*/ {_display_(Seq[Any](format.raw/*9.23*/("""
    <div class="span1">
    	<button id="btn_show_new_url" class="btn" type="submit" style="display:none;"><i class="icon-edit"></i> Add</button>
    </div>
    <form class="span8 form-inline add_url_form" style="display:none;margin-bottom:5px;">
		<div class="vertical-spacing-10"></div>
		<div class="span1" style="margin-left:0px;">
            <input type="text" class="input-mini" id="formAddUrlLabel" placeholder="Label">
        </div>
        <div class="span6" >
			<input type="text" class="input-xlarge span6" id="input_form_add_url" placeholder="Website URL">
		</div>
        <div class="span1">
			<a class="btn btn-mini" href="#" id="submit_add_url"><i class="icon-plus-sign"></i></a>
		</div>
		<div class="vertical-spacing-10"></div>
    </form>
	""")))})),format.raw/*26.3*/("""
</div>
"""),_display_(Seq[Any](/*28.2*/if(links.size == 0)/*28.21*/ {_display_(Seq[Any](format.raw/*28.23*/("""
    <p>There is no link related to this conference</p>
""")))}/*30.3*/else/*30.8*/{_display_(Seq[Any](format.raw/*30.9*/("""
<ul class="unstyled" id="confLinks">
"""),_display_(Seq[Any](/*32.2*/links/*32.7*/.map/*32.11*/ { link =>_display_(Seq[Any](format.raw/*32.21*/(""" 
    """),_display_(Seq[Any](/*33.6*/snippets/*33.14*/.link(link))),format.raw/*33.25*/("""
""")))})),format.raw/*34.2*/("""
""")))})),format.raw/*35.2*/("""
</ul>
                
"""))}
    }
    
    def render(links:List[Link],user:Option[User]) = apply(links,user)
    
    def f:((List[Link],Option[User]) => play.api.templates.Html) = (links,user) => apply(links,user)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/conferences/links.scala.html
                    HASH: c1f3dd76ed86f3021abe9ae379857390cd659351
                    MATRIX: 534->1|700->40|728->93|839->170|865->188|904->190|1701->956|1745->965|1773->984|1813->986|1888->1044|1900->1049|1938->1050|2012->1089|2025->1094|2038->1098|2086->1108|2128->1115|2145->1123|2178->1134|2211->1136|2244->1138
                    LINES: 19->1|25->1|27->5|31->9|31->9|31->9|48->26|50->28|50->28|50->28|52->30|52->30|52->30|54->32|54->32|54->32|54->32|55->33|55->33|55->33|56->34|57->35
                    -- GENERATED --
                */
            