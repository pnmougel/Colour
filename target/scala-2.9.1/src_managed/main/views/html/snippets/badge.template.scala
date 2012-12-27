
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
object badge extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Option[Double],Int,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(score: Option[Double], size: Int = 10):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""

"""),_display_(Seq[Any](/*3.2*/{if(score.isDefined) {
    if(score.get >= 4.5) {
	    <span class="badge badge-success" style="font-size:@{size}pt">A</span>
	} else if(score.get >= 3.5) {
	    <span class="badge badge-warning" style="font-size:@{size}pt">B</span>
	} else if(score.get >= 2) {
	    <span class="badge badge-info" style="font-size:@{size}pt">C</span>
	} else if(score.get < 0) {
	    <span class="badge" style="font-size:@{size}pt">?</span>
	} else {
	    <span class="badge badge-important" style="font-size:@{size}pt">D</span>
	}
} else {
    <span class="badge" style="font-size:@{size}pt">?</span>
}})),format.raw/*17.3*/("""
"""))}
    }
    
    def render(score:Option[Double],size:Int) = apply(score,size)
    
    def f:((Option[Double],Int) => play.api.templates.Html) = (score,size) => apply(score,size)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 17 21:15:12 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/badge.scala.html
                    HASH: 39a32517f456e29bd2c84d84a67382067f8e8443
                    MATRIX: 526->1|642->40|679->43|1288->631
                    LINES: 19->1|22->1|24->3|38->17
                    -- GENERATED --
                */
            