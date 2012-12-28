
package views.html.admin.snippets

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
object frame extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,String,String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String, icon : String = "", bgColor : String = "#DBE1E5")(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.82*/("""

 <div style="-moz-border-radius: 6px;border-radius: 6px;border:1px solid #9BA5AD;background-color:"""),_display_(Seq[Any](/*3.100*/bgColor)),format.raw/*3.107*/(""";background-clip: padding-box;-moz-background-clip: padding;-webkit-background-clip: padding-box;overflow: hidden;margin-top:10px;">
    <div style="font-weight:bold;color:#4794C4;border-bottom:1px solid #9BA5AD;padding:5px;background-color:#E5E8EB;background-clip: padding-box;-moz-background-clip: padding;-webkit-background-clip: padding-box;text-shadow: 1px 1px white;font-size:11pt;padding-left:10px;">
        <i class=""""),_display_(Seq[Any](/*5.20*/icon)),format.raw/*5.24*/(""""></i> """),_display_(Seq[Any](/*5.32*/title)),format.raw/*5.37*/("""
    </div>
    <div style="padding:5px;padding-left:10px;">
        """),_display_(Seq[Any](/*8.10*/content)),format.raw/*8.17*/("""
    </div>
</div>"""))}
    }
    
    def render(title:String,icon:String,bgColor:String,content:Html) = apply(title,icon,bgColor)(content)
    
    def f:((String,String,String) => (Html) => play.api.templates.Html) = (title,icon,bgColor) => (content) => apply(title,icon,bgColor)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/admin/snippets/frame.scala.html
                    HASH: ad9143c9ea994ae0e5c48ba7e44fc91e3124e7c1
                    MATRIX: 539->1|696->81|833->182|862->189|1324->616|1349->620|1392->628|1418->633|1523->703|1551->710
                    LINES: 19->1|22->1|24->3|24->3|26->5|26->5|26->5|26->5|29->8|29->8
                    -- GENERATED --
                */
            