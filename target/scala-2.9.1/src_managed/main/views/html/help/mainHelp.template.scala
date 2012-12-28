
package views.html.help

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
object mainHelp extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[RequestHeader,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(implicit request: RequestHeader, sectionName : String):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._

import org.apache.commons.lang3.text.WordUtils


Seq[Any](format.raw/*1.57*/("""

"""),format.raw/*6.1*/("""    
"""),_display_(Seq[Any](/*7.2*/main(request)/*7.15*/ {_display_(Seq[Any](format.raw/*7.17*/("""
    <div class="container">
        <div class="vertical-spacing-15"></div>
        <div class="row" id="helpContent">
            <div class="span6 offset4">
                <h3>"""),_display_(Seq[Any](/*12.22*/Help/*12.26*/.linktoName(sectionName))),format.raw/*12.50*/("""</h3>
                <hr/>
            </div> 
        </div>
        <div class="row">
            <div class="span3 offset1">
                <ul class="unstyled helpMenu">
                """),_display_(Seq[Any](/*19.18*/Help/*19.22*/.menuSections.map/*19.39*/ { case (section, subSections) =>_display_(Seq[Any](format.raw/*19.72*/("""
                    <li """),_display_(Seq[Any](/*20.26*/if(sectionName == Help.nametoLink(section))/*20.69*/ {_display_(Seq[Any](format.raw/*20.71*/("""class="selected"""")))})),format.raw/*20.88*/(""" ><a href=""""),_display_(Seq[Any](/*20.100*/Help/*20.104*/.nametoLink(section))),format.raw/*20.124*/("""">"""),_display_(Seq[Any](/*20.127*/section)),format.raw/*20.134*/("""</a></li>
                    """),_display_(Seq[Any](/*21.22*/if(!subSections.isEmpty)/*21.46*/ {_display_(Seq[Any](format.raw/*21.48*/("""
                        <ul class="unstyled">
                        """),_display_(Seq[Any](/*23.26*/subSections/*23.37*/.map/*23.41*/ { subSection =>_display_(Seq[Any](format.raw/*23.57*/("""
                            <li """),_display_(Seq[Any](/*24.34*/if(sectionName == Help.nametoLink(subSection))/*24.80*/ {_display_(Seq[Any](format.raw/*24.82*/("""class="selected"""")))})),format.raw/*24.99*/("""><a href=""""),_display_(Seq[Any](/*24.110*/Help/*24.114*/.nametoLink(subSection))),format.raw/*24.137*/("""">"""),_display_(Seq[Any](/*24.140*/subSection)),format.raw/*24.150*/("""</a></li>
                        """)))})),format.raw/*25.26*/("""
                        </ul>
                    """)))})),format.raw/*27.22*/("""
                """)))})),format.raw/*28.18*/("""
                </ul>
            </div>
            <div class="span6">
                """),_display_(Seq[Any](/*32.18*/{sectionName match { 
                    case "about" => help.about()
                    case "create_an_account" => help.account.createAnAccount()
                    case "update_your_profile" => help.account.updateYourProfile()
                    case "contribute" => help.contribute.contribute()
                    
                    case "vote" => help.contribute.vote()
                    case "edit_publication" => help.contribute.editPublication()
                    case "idea_box" => help.contribute.ideaBox()
                    
                    case "user_scores" => help.scores.userScores()
                    case "external_scores" => help.scores.externalScores()
                    case "core" => help.scores.core()
                    case "google_scholar" => help.scores.googleScholar()
                    case "microsoft_academic_research" => help.scores.microsoftAcademicResearch()
                    
                    case "api" => help.api.api()
                    case "access" => help.api.access()
                    case "basic_usage" => help.api.basicUsages()
                    case "examples" => help.api.examples()

                    case "contact_us" => help.contactUs()
                    case "privacy" => help.privacy()
                    case _ => help.about()
                }})),format.raw/*56.19*/("""
            </div>
        </div>
    </div>
""")))})))}
    }
    
    def render(request:RequestHeader,sectionName:String) = apply(request,sectionName)
    
    def f:((RequestHeader,String) => play.api.templates.Html) = (request,sectionName) => apply(request,sectionName)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/help/mainHelp.scala.html
                    HASH: 61043653e81dd01f907fda29f5695edd900f1b40
                    MATRIX: 527->1|757->56|785->157|825->163|846->176|885->178|1102->359|1115->363|1161->387|1390->580|1403->584|1429->601|1500->634|1562->660|1614->703|1654->705|1703->722|1752->734|1766->738|1809->758|1849->761|1879->768|1946->799|1979->823|2019->825|2127->897|2147->908|2160->912|2214->928|2284->962|2339->1008|2379->1010|2428->1027|2476->1038|2490->1042|2536->1065|2576->1068|2609->1078|2676->1113|2760->1165|2810->1183|2937->1274|4297->2612
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|35->12|35->12|35->12|42->19|42->19|42->19|42->19|43->20|43->20|43->20|43->20|43->20|43->20|43->20|43->20|43->20|44->21|44->21|44->21|46->23|46->23|46->23|46->23|47->24|47->24|47->24|47->24|47->24|47->24|47->24|47->24|47->24|48->25|50->27|51->28|55->32|79->56
                    -- GENERATED --
                */
            