
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
object doubleDisplay extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Double,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(value: Double):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.17*/("""

"""),_display_(Seq[Any](/*3.2*/if(value == value.toInt)/*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""
	"""),_display_(Seq[Any](/*4.3*/value/*4.8*/.toInt)),format.raw/*4.14*/("""
""")))}/*5.3*/else/*5.8*/{_display_(Seq[Any](format.raw/*5.9*/("""
    """),_display_(Seq[Any](/*6.6*/{"%1.1f" format value})),format.raw/*6.28*/("""
""")))})))}
    }
    
    def render(value:Double) = apply(value)
    
    def f:((Double) => play.api.templates.Html) = (value) => apply(value)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/doubleDisplay.scala.html
                    HASH: d5a646ba4b1b66c5f5857cd13ceada01a7922a75
                    MATRIX: 522->1|614->16|651->19|683->43|722->45|759->48|771->53|798->59|817->62|828->67|865->68|905->74|948->96
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|27->6|27->6
                    -- GENERATED --
                */
            