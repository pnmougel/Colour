
package views.html.admin

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/()(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._

import java.text.NumberFormat

import java.util.Locale


Seq[Any](format.raw/*1.37*/("""

"""),format.raw/*7.1*/("""    
"""),_display_(Seq[Any](/*8.2*/mainAdmin("Home", request)/*8.28*/ {_display_(Seq[Any](format.raw/*8.30*/("""
    <div class="container">
        
    </div>
""")))})))}
    }
    
    def render(request:RequestHeader) = apply()(request)
    
    def f:(() => (RequestHeader) => play.api.templates.Html) = () => (request) => apply()(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/admin/index.scala.html
                    HASH: 1bcf67c950cbafd04b3359668d806e57ccaad6a4
                    MATRIX: 518->1|736->36|764->145|804->151|838->177|877->179
                    LINES: 19->1|29->1|31->7|32->8|32->8|32->8
                    -- GENERATED --
                */
            