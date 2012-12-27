
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
object options extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[controllers.admin.form.AdminForm,RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form : controllers.admin.form.AdminForm)(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.76*/("""

"""),_display_(Seq[Any](/*3.2*/frame("Configuration", "icon-wrench")/*3.39*/ {_display_(Seq[Any](format.raw/*3.41*/("""
    """),_display_(Seq[Any](/*4.6*/if(form.size == 0)/*4.24*/ {_display_(Seq[Any](format.raw/*4.26*/("""
        Nothing to configure
    """)))}/*6.7*/else/*6.12*/{_display_(Seq[Any](format.raw/*6.13*/("""
        """),_display_(Seq[Any](/*7.10*/Html(form.toHtml()))),format.raw/*7.29*/("""
    """)))})),format.raw/*8.6*/("""
""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(form:controllers.admin.form.AdminForm,request:RequestHeader) = apply(form)(request)
    
    def f:((controllers.admin.form.AdminForm) => (RequestHeader) => play.api.templates.Html) = (form) => (request) => apply(form)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Dec 23 07:51:35 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/admin/snippets/options.scala.html
                    HASH: 98671cf06df391006a907d7933e2b274776ca3ee
                    MATRIX: 562->1|713->75|750->78|795->115|834->117|874->123|900->141|939->143|991->179|1003->184|1041->185|1086->195|1126->214|1162->220|1194->222
                    LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|27->6|27->6|27->6|28->7|28->7|29->8|30->9
                    -- GENERATED --
                */
            