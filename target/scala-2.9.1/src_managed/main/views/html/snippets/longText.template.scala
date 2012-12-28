
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
object longText extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Int,Int,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(text: String, size: Int = 256, key : Int = (math.random * 4096).toInt):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.73*/("""

"""),_display_(Seq[Any](/*3.2*/if(text.indexOf(" ", size) == -1)/*3.35*/ {_display_(Seq[Any](format.raw/*3.37*/("""
    <span>"""),_display_(Seq[Any](/*4.12*/text)),format.raw/*4.16*/("""</span>
""")))})),format.raw/*5.2*/("""
"""),_display_(Seq[Any](/*6.2*/if(text.indexOf(" ", size) != -1)/*6.35*/ {_display_(Seq[Any](format.raw/*6.37*/("""
    <span>"""),_display_(Seq[Any](/*7.12*/{text.substring(0, text.indexOf(" ", size))})),format.raw/*7.56*/("""<span id="longTextDots_"""),_display_(Seq[Any](/*7.80*/key)),format.raw/*7.83*/("""">...</span></span>
	<span id="longText_"""),_display_(Seq[Any](/*8.22*/key)),format.raw/*8.25*/("""" style="display:none;">"""),_display_(Seq[Any](/*8.50*/{text.substring(text.indexOf(" ", size), text.size)})),format.raw/*8.102*/("""</span>
	<a style="float:right;" href="#" id="longTextShow_"""),_display_(Seq[Any](/*9.53*/key)),format.raw/*9.56*/("""" onclick="window.toggleLongText("""),_display_(Seq[Any](/*9.90*/key)),format.raw/*9.93*/(""");">More</a>
""")))})),format.raw/*10.2*/("""
"""))}
    }
    
    def render(text:String,size:Int,key:Int) = apply(text,size,key)
    
    def f:((String,Int,Int) => play.api.templates.Html) = (text,size,key) => apply(text,size,key)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/longText.scala.html
                    HASH: 7bcde28b25f3f9ae80468c8855911d61ba1ef896
                    MATRIX: 525->1|673->72|710->75|751->108|790->110|837->122|862->126|901->135|937->137|978->170|1017->172|1064->184|1129->228|1188->252|1212->255|1288->296|1312->299|1372->324|1446->376|1541->436|1565->439|1634->473|1658->476|1703->490
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|26->5|27->6|27->6|27->6|28->7|28->7|28->7|28->7|29->8|29->8|29->8|29->8|30->9|30->9|30->9|30->9|31->10
                    -- GENERATED --
                */
            