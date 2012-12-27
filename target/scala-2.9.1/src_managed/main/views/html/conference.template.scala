
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
object conference extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Conference,Option[UserVote],Option[User],RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(conference: Conference, vote : Option[UserVote], user : Option[User])(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.105*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(request)/*6.15*/ {_display_(Seq[Any](format.raw/*6.17*/("""
    <div class="container">
        <div class="row">
            <div class="span8 offset2">
                <input type="hidden" id="conference_id" value=""""),_display_(Seq[Any](/*10.65*/conference/*10.75*/.id)),format.raw/*10.78*/("""">
                <input type="hidden" id="hasVoted" value=""""),_display_(Seq[Any](/*11.60*/vote/*11.64*/.isDefined)),format.raw/*11.74*/("""">

                <!-- Conference information -->
                """),_display_(Seq[Any](/*14.18*/conferences/*14.29*/.information(conference, user))),format.raw/*14.59*/("""

                <!-- Scores -->
                <div id="scores_container">
                    """),_display_(Seq[Any](/*18.22*/conferences/*18.33*/.scores(conference, user, vote))),format.raw/*18.64*/("""
                </div>

                <!-- Links -->
                <div id="links_container">
                    """),_display_(Seq[Any](/*23.22*/conferences/*23.33*/.links(conference.links, user))),format.raw/*23.63*/("""
                </div>

                <!-- Comments -->
                """),_display_(Seq[Any](/*27.18*/conferences/*27.29*/.comments(conference.comments, user))),format.raw/*27.65*/("""
            </div>
        </div>
    </div>
    <script src=""""),_display_(Seq[Any](/*31.19*/routes/*31.25*/.Assets.at("javascripts/conference.min.js"))),format.raw/*31.68*/("""" type="text/javascript"></script>
""")))})))}
    }
    
    def render(conference:Conference,vote:Option[UserVote],user:Option[User],request:RequestHeader) = apply(conference,vote,user)(request)
    
    def f:((Conference,Option[UserVote],Option[User]) => (RequestHeader) => play.api.templates.Html) = (conference,vote,user) => (request) => apply(conference,vote,user)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 21 16:06:43 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/conference.scala.html
                    HASH: 9e3b5127bc83395c8ffc191a0167c5ee141708f5
                    MATRIX: 558->1|789->104|817->157|853->159|874->172|913->174|1108->333|1127->343|1152->346|1250->408|1263->412|1295->422|1400->491|1420->502|1472->532|1607->631|1627->642|1680->673|1836->793|1856->804|1908->834|2020->910|2040->921|2098->957|2198->1021|2213->1027|2278->1070
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|32->10|32->10|32->10|33->11|33->11|33->11|36->14|36->14|36->14|40->18|40->18|40->18|45->23|45->23|45->23|49->27|49->27|49->27|53->31|53->31|53->31
                    -- GENERATED --
                */
            