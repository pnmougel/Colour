
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
object widget extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Option[Double],Int,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(score: Option[Double], size: Int = 8):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.40*/("""

"""),_display_(Seq[Any](/*3.2*/if(score.isDefined)/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
    """),_display_(Seq[Any](/*4.6*/if(score.get >= 4.5)/*4.26*/ {_display_(Seq[Any](format.raw/*4.28*/("""
	    <span style="padding: 1px 9px 2px;-webkit-border-radius: 9px;-moz-border-radius: 9px;border-radius: 9px;border-top-left-radius: 9px;border-top-right-radius: 9px;border-bottom-right-radius: 9px;border-bottom-left-radius: 9px;font-size:"""),_display_(Seq[Any](/*5.241*/size)),format.raw/*5.245*/(""" pt;font-weight: bold;color: white;text-shadow:0 -1px 0 rgba(0, 0, 0, 0.25);background-color: #468847;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;" >A</span>
	""")))})),format.raw/*6.3*/(""" 
	"""),_display_(Seq[Any](/*7.3*/if(score.get >= 3.5 && score.get < 4.5)/*7.42*/ {_display_(Seq[Any](format.raw/*7.44*/("""
	    <span style="padding: 1px 9px 2px;-webkit-border-radius: 9px;-moz-border-radius: 9px;border-radius: 9px;border-top-left-radius: 9px;border-top-right-radius: 9px;border-bottom-right-radius: 9px;border-bottom-left-radius: 9px;font-size:"""),_display_(Seq[Any](/*8.241*/size)),format.raw/*8.245*/(""" pt;font-weight: bold;color: white;text-shadow:0 -1px 0 rgba(0, 0, 0, 0.25);background-color: #F89406;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;" >B</span>
	""")))})),format.raw/*9.3*/(""" 
	"""),_display_(Seq[Any](/*10.3*/if(score.get >= 2 && score.get < 3.5)/*10.40*/ {_display_(Seq[Any](format.raw/*10.42*/("""
	    <span style="padding: 1px 9px 2px;-webkit-border-radius: 9px;-moz-border-radius: 9px;border-radius: 9px;border-top-left-radius: 9px;border-top-right-radius: 9px;border-bottom-right-radius: 9px;border-bottom-left-radius: 9px;font-size:"""),_display_(Seq[Any](/*11.241*/size)),format.raw/*11.245*/(""" pt;font-weight: bold;color: white;text-shadow:0 -1px 0 rgba(0, 0, 0, 0.25);background-color: #3A87AD;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;" >C</span>
	""")))})),format.raw/*12.3*/(""" 
	"""),_display_(Seq[Any](/*13.3*/if(score.get >= 0 && score.get < 2)/*13.38*/ {_display_(Seq[Any](format.raw/*13.40*/("""
	    <span style="padding: 1px 9px 2px;-webkit-border-radius: 9px;-moz-border-radius: 9px;border-radius: 9px;border-top-left-radius: 9px;border-top-right-radius: 9px;border-bottom-right-radius: 9px;border-bottom-left-radius: 9px;font-size:"""),_display_(Seq[Any](/*14.241*/size)),format.raw/*14.245*/(""" pt;font-weight: bold;color: white;text-shadow:0 -1px 0 rgba(0, 0, 0, 0.25);background-color: #B94A48;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;" >D</span>
	""")))})),format.raw/*15.3*/("""
	"""),_display_(Seq[Any](/*16.3*/if(score.get < 0)/*16.20*/ {_display_(Seq[Any](format.raw/*16.22*/("""
	    <span style="padding: 1px 9px 2px;-webkit-border-radius: 9px;-moz-border-radius: 9px;border-radius: 9px;border-top-left-radius: 9px;border-top-right-radius: 9px;border-bottom-right-radius: 9px;border-bottom-left-radius: 9px;font-size:"""),_display_(Seq[Any](/*17.241*/size)),format.raw/*17.245*/(""" pt;font-weight: bold;color: white;text-shadow:0 -1px 0 rgba(0, 0, 0, 0.25);background-color: #999;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;" >?</span>
	""")))})),format.raw/*18.3*/("""
""")))}/*19.3*/else/*19.8*/{_display_(Seq[Any](format.raw/*19.9*/("""
    <span style="padding: 1px 9px 2px;-webkit-border-radius: 9px;-moz-border-radius: 9px;border-radius: 9px;border-top-left-radius: 9px;border-top-right-radius: 9px;border-bottom-right-radius: 9px;border-bottom-left-radius: 9px;font-size:"""),_display_(Seq[Any](/*20.240*/size)),format.raw/*20.244*/(""" pt;font-weight: bold;color: white;text-shadow:0 -1px 0 rgba(0, 0, 0, 0.25);background-color: #999;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;" >?</span>
""")))})),format.raw/*21.2*/("""
"""))}
    }
    
    def render(score:Option[Double],size:Int) = apply(score,size)
    
    def f:((Option[Double],Int) => play.api.templates.Html) = (score,size) => apply(score,size)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Dec 17 00:45:14 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/snippets/widget.scala.html
                    HASH: 10221c0c9d081a3202d21abe0e9b380634c3d3cd
                    MATRIX: 527->1|642->39|679->42|706->61|745->63|785->69|813->89|852->91|1129->332|1155->336|1360->511|1398->515|1445->554|1484->556|1761->797|1787->801|1992->976|2031->980|2077->1017|2117->1019|2395->1260|2422->1264|2628->1439|2667->1443|2711->1478|2751->1480|3029->1721|3056->1725|3262->1900|3300->1903|3326->1920|3366->1922|3644->2163|3671->2167|3874->2339|3894->2342|3906->2347|3944->2348|4221->2588|4248->2592|4450->2763
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|27->6|28->7|28->7|28->7|29->8|29->8|30->9|31->10|31->10|31->10|32->11|32->11|33->12|34->13|34->13|34->13|35->14|35->14|36->15|37->16|37->16|37->16|38->17|38->17|39->18|40->19|40->19|40->19|41->20|41->20|42->21
                    -- GENERATED --
                */
            