
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
object link extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Link,Boolean,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(link: Link, removable : Boolean = false):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.43*/("""

<li id="link_"""),_display_(Seq[Any](/*3.15*/link/*3.19*/.id)),format.raw/*3.22*/("""" class="mlink">
    <div class="row" id="links">
        <div class="span1">
        """),_display_(Seq[Any](/*6.10*/if(removable)/*6.23*/ {_display_(Seq[Any](format.raw/*6.25*/("""
        <a class="btn btn-mini delete_link" href="#" onclick="deleteUrl("""),_display_(Seq[Any](/*7.74*/link/*7.78*/.id)),format.raw/*7.81*/(""");"><i class="icon-remove-sign"></i></a>
        """)))})),format.raw/*8.10*/("""
        <span class="label label-info">
        """),_display_(Seq[Any](/*10.10*/if(link.name.isDefined)/*10.33*/ {_display_(Seq[Any](format.raw/*10.35*/("""
			"""),_display_(Seq[Any](/*11.5*/if(link.name.get.trim().size == 0)/*11.39*/ {_display_(Seq[Any](format.raw/*11.41*/("""
	            """),_display_(Seq[Any](/*12.15*/if(link.url.matches("(?i).*informatik.uni-trier.de.*") || link.url.matches("(?i).*dblp.*"))/*12.106*/ {_display_(Seq[Any](format.raw/*12.108*/("""
	                DBLP
	            """)))}/*14.16*/else/*14.21*/{_display_(Seq[Any](format.raw/*14.22*/("""
	                """),_display_(Seq[Any](/*15.19*/if(link.url.matches("(?i).*google.*"))/*15.57*/ {_display_(Seq[Any](format.raw/*15.59*/("""
	                	Wikipedia
		            """)))}/*17.17*/else/*17.22*/{_display_(Seq[Any](format.raw/*17.23*/("""
		                Misc.
		            """)))})),format.raw/*19.16*/("""
	            """)))})),format.raw/*20.15*/("""
			""")))}/*21.6*/else/*21.11*/{_display_(Seq[Any](format.raw/*21.12*/("""
			    """),_display_(Seq[Any](/*22.9*/link/*22.13*/.name.get)),format.raw/*22.22*/("""
			""")))})),format.raw/*23.5*/("""
		""")))})),format.raw/*24.4*/("""
        </span></div>
        <div class="span"""),_display_(Seq[Any](/*26.26*/if(removable)/*26.39*/{_display_(Seq[Any](format.raw/*26.40*/("""3""")))}/*26.43*/else/*26.48*/{_display_(Seq[Any](format.raw/*26.49*/("""6""")))})),format.raw/*26.51*/(""""><a href=""""),_display_(Seq[Any](/*26.63*/link/*26.67*/.url)),format.raw/*26.71*/("""" target="_blank">"""),_display_(Seq[Any](/*26.90*/link/*26.94*/.url)),format.raw/*26.98*/("""</a></div>
    </div>
</li>

"""))}
    }
    
    def render(link:Link,removable:Boolean) = apply(link,removable)
    
    def f:((Link,Boolean) => play.api.templates.Html) = (link,removable) => apply(link,removable)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Dec 23 05:16:07 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/link.scala.html
                    HASH: 486ed74fa0dc2979e574093ffbb68a27f2d7a315
                    MATRIX: 519->1|637->42|688->58|700->62|724->65|846->152|867->165|906->167|1015->241|1027->245|1051->248|1132->298|1218->348|1250->371|1290->373|1330->378|1373->412|1413->414|1464->429|1565->520|1606->522|1662->560|1675->565|1714->566|1769->585|1816->623|1856->625|1919->670|1932->675|1971->676|2043->716|2090->731|2113->737|2126->742|2165->743|2209->752|2222->756|2253->765|2289->770|2324->774|2408->822|2430->835|2469->836|2490->839|2503->844|2542->845|2576->847|2624->859|2637->863|2663->867|2718->886|2731->890|2757->894
                    LINES: 19->1|22->1|24->3|24->3|24->3|27->6|27->6|27->6|28->7|28->7|28->7|29->8|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|35->14|35->14|35->14|36->15|36->15|36->15|38->17|38->17|38->17|40->19|41->20|42->21|42->21|42->21|43->22|43->22|43->22|44->23|45->24|47->26|47->26|47->26|47->26|47->26|47->26|47->26|47->26|47->26|47->26|47->26|47->26|47->26
                    -- GENERATED --
                */
            