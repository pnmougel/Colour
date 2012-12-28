
package views.html.snippets.update

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
object updates extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Seq[Update],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(updates: Seq[Update]):play.api.templates.Html = {
        _display_ {import java.text.SimpleDateFormat

import java.util.Calendar


Seq[Any](format.raw/*1.24*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/updates/*6.9*/.map/*6.13*/ { update =>_display_(Seq[Any](format.raw/*6.25*/("""
<div>
    <h5>"""),_display_(Seq[Any](/*8.10*/update/*8.16*/.dateFormated)),format.raw/*8.29*/("""</h5>
    """),_display_(Seq[Any](/*9.6*/if(update.nameUpdate.isDefined)/*9.37*/ {_display_(Seq[Any](format.raw/*9.39*/(""" 
        """),_display_(Seq[Any](/*10.10*/snippets/*10.18*/.update.updateName(update.nameUpdate.get))),format.raw/*10.59*/(""" 
    """)))})),format.raw/*11.6*/("""
    """),_display_(Seq[Any](/*12.6*/if(update.shortnameUpdate.isDefined)/*12.42*/ {_display_(Seq[Any](format.raw/*12.44*/(""" 
        """),_display_(Seq[Any](/*13.10*/snippets/*13.18*/.update.updateShortName(update.shortnameUpdate.get))),format.raw/*13.69*/(""" 
    """)))})),format.raw/*14.6*/("""
    """),_display_(Seq[Any](/*15.6*/if(update.creationDateUpdate.isDefined)/*15.45*/ {_display_(Seq[Any](format.raw/*15.47*/(""" 
        """),_display_(Seq[Any](/*16.10*/snippets/*16.18*/.update.updateCreationYear(update.creationDateUpdate.get))),format.raw/*16.75*/(""" 
    """)))})),format.raw/*17.6*/("""
    """),_display_(Seq[Any](/*18.6*/if(update.ctypeUpdate.isDefined)/*18.38*/ {_display_(Seq[Any](format.raw/*18.40*/(""" 
        """),_display_(Seq[Any](/*19.10*/snippets/*19.18*/.update.updateCtype(update.ctypeUpdate.get))),format.raw/*19.61*/(""" 
    """)))})),format.raw/*20.6*/("""
    """),_display_(Seq[Any](/*21.6*/if(update.publisherUpdate.isDefined)/*21.42*/ {_display_(Seq[Any](format.raw/*21.44*/(""" 
        """),_display_(Seq[Any](/*22.10*/snippets/*22.18*/.update.updatePublisher(update.publisherUpdate.get))),format.raw/*22.69*/(""" 
    """)))})),format.raw/*23.6*/("""
    """),_display_(Seq[Any](/*24.6*/if(update.regionUpdate.isDefined)/*24.39*/ {_display_(Seq[Any](format.raw/*24.41*/(""" 
        """),_display_(Seq[Any](/*25.10*/snippets/*25.18*/.update.updateRegion(update.regionUpdate.get))),format.raw/*25.63*/(""" 
    """)))})),format.raw/*26.6*/("""
    """),_display_(Seq[Any](/*27.6*/if(update.descriptionUpdate.isDefined)/*27.44*/ {_display_(Seq[Any](format.raw/*27.46*/(""" 
        """),_display_(Seq[Any](/*28.10*/snippets/*28.18*/.update.updateDescription(update.descriptionUpdate.get))),format.raw/*28.73*/(""" 
    """)))})),format.raw/*29.6*/("""
    """),_display_(Seq[Any](/*30.6*/snippets/*30.14*/.update.updateAddSubfields(update.addSubfieldUpdates))),format.raw/*30.67*/(""" 
    """),_display_(Seq[Any](/*31.6*/snippets/*31.14*/.update.updateRemoveSubfields(update.removeSubfieldUpdates))),format.raw/*31.73*/("""
</div>
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(updates:Seq[Update]) = apply(updates)
    
    def f:((Seq[Update]) => play.api.templates.Html) = (updates) => apply(updates)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/update/updates.scala.html
                    HASH: 191e94614c0d92b1e2a9938f89607121ba643b42
                    MATRIX: 528->1|688->23|716->87|752->89|766->96|778->100|827->112|878->128|892->134|926->147|971->158|1010->189|1049->191|1096->202|1113->210|1176->251|1214->258|1255->264|1300->300|1340->302|1387->313|1404->321|1477->372|1515->379|1556->385|1604->424|1644->426|1691->437|1708->445|1787->502|1825->509|1866->515|1907->547|1947->549|1994->560|2011->568|2076->611|2114->618|2155->624|2200->660|2240->662|2287->673|2304->681|2377->732|2415->739|2456->745|2498->778|2538->780|2585->791|2602->799|2669->844|2707->851|2748->857|2795->895|2835->897|2882->908|2899->916|2976->971|3014->978|3055->984|3072->992|3147->1045|3189->1052|3206->1060|3287->1119|3327->1128
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|28->6|30->8|30->8|30->8|31->9|31->9|31->9|32->10|32->10|32->10|33->11|34->12|34->12|34->12|35->13|35->13|35->13|36->14|37->15|37->15|37->15|38->16|38->16|38->16|39->17|40->18|40->18|40->18|41->19|41->19|41->19|42->20|43->21|43->21|43->21|44->22|44->22|44->22|45->23|46->24|46->24|46->24|47->25|47->25|47->25|48->26|49->27|49->27|49->27|50->28|50->28|50->28|51->29|52->30|52->30|52->30|53->31|53->31|53->31|55->33
                    -- GENERATED --
                */
            