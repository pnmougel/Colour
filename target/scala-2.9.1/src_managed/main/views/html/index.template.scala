
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(nbConference: Long)(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._

import java.text.NumberFormat

import java.util.Locale


Seq[Any](format.raw/*1.55*/("""

"""),format.raw/*7.1*/("""    
"""),_display_(Seq[Any](/*8.2*/main(request)/*8.15*/ {_display_(Seq[Any](format.raw/*8.17*/("""
    <div class="container">
        <div class="vertical-spacing-200"></div>
        <div class="row">
            <div class="span6 offset4">
                <h1 style="font-size: 45pt">"""),_display_(Seq[Any](/*13.46*/Application/*13.57*/.name)),format.raw/*13.62*/("""</h1>
                <div class="vertical-spacing-30"></div>
                <span class="badge badge-success" style="font-size: 13pt;height: 20px;">&nbsp;</span>
                <span class="badge badge-warning" style="font-size: 13pt;height: 20px;">&nbsp;</span>
                <span class="badge badge-info" style="font-size: 13pt;height: 20px;">&nbsp;</span>
                <span class="badge badge-important" style="font-size: 13pt;height: 20px;">&nbsp;</span>
                <div class="vertical-spacing-20"></div>
                <h3>Collaborative<br/>Journals &amp; Conferences<br/>Ranking</h3>
                <div class="vertical-spacing-20"></div>
                
                """),_display_(Seq[Any](/*23.18*/snippets/*23.26*/.search())),format.raw/*23.35*/("""
                
				"""),_display_(Seq[Any](/*25.6*/NumberFormat/*25.18*/.getIntegerInstance(Locale.US).format(nbConference))),format.raw/*25.69*/(""" 
                conference"""),_display_(Seq[Any](/*26.28*/if(nbConference > 1)/*26.48*/ {_display_(Seq[Any](format.raw/*26.50*/("""s""")))})),format.raw/*26.52*/(""" and journal"""),_display_(Seq[Any](/*26.65*/if(nbConference > 1)/*26.85*/ {_display_(Seq[Any](format.raw/*26.87*/("""s""")))})),format.raw/*26.89*/(""" referenced
            </div>
        </div>
    </div>
""")))})))}
    }
    
    def render(nbConference:Long,request:RequestHeader) = apply(nbConference)(request)
    
    def f:((Long) => (RequestHeader) => play.api.templates.Html) = (nbConference) => (request) => apply(nbConference)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 21 18:09:44 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/index.scala.html
                    HASH: 4bc997bed875619f8de2d6764d7fb4eea72dbdbb
                    MATRIX: 517->1|753->54|781->163|821->169|842->182|881->184|1106->373|1126->384|1153->389|1886->1086|1903->1094|1934->1103|1992->1126|2013->1138|2086->1189|2151->1218|2180->1238|2220->1240|2254->1242|2303->1255|2332->1275|2372->1277|2406->1279
                    LINES: 19->1|29->1|31->7|32->8|32->8|32->8|37->13|37->13|37->13|47->23|47->23|47->23|49->25|49->25|49->25|50->26|50->26|50->26|50->26|50->26|50->26|50->26|50->26
                    -- GENERATED --
                */
            