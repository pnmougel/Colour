
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
object ranking extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template7[Long,List[scala.Tuple2[Conference, Int]],List[models.SubField],Int,Double,String,RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(fieldId : Long, conferences : List[(Conference, Int)], subFields: List[models.SubField], pageNum : Int, pageMax : Double, nameFilter : String)(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.178*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(request)/*5.15*/ {_display_(Seq[Any](format.raw/*5.17*/("""
    <style>
        .buttontext """),format.raw("""{"""),format.raw/*7.22*/("""
        width: 110px;
        overflow: hidden;
        white-space: nowrap;
        display: block;
        text-overflow: ellipsis;
        text-align:center;
        """),format.raw("""}"""),format.raw/*14.10*/("""
    </style>​
        <div class="container">
            <!-- Filter buttons -->
            <div class="row">
                <div class="span9 offset2">
                    <div class="btn-group" style="display:inline;">
                        <button class="btn" id="showSelectFields" style="margin-bottom:5px;display:inline;">
                            <i class="icon-chevron-down">
                            </i> Select fields
                        </button>
                        <button class="btn" id="selectAll" style="margin-bottom:5px;">All</button>
                        <button class="btn" id="selectNone" style="margin-bottom:5px;margin-right:10px;">None</button>
                    </div>
                    
                    <div class="btn-group" style="display:inline;">
                        <button class="btn radio active" id="national" data-toggle="buttons-checkbox" style="margin-bottom:5px;">National</button>
                        <button class="btn radio active" id="international" data-toggle="buttons-checkbox" style="margin-bottom:5px;margin-right:10px;">International</button>
                    </div>
                    
                    <div class="btn-group" data-toggle="buttons-checkbox" style="display:inline;">
                        <button class="btn radio active" id="conference" style="margin-bottom:5px;">Conferences</button>
                        <button class="btn radio active" id="journal" style="margin-bottom:5px;">Journals</button>
                        <button class="btn radio active" id="workshop" style="margin-bottom:5px;">Workshops</button>
                    </div>
                    
                    <br/>
                    <br/>
                    
                    <div id="subFields" style="display:none;">
                        """),_display_(Seq[Any](/*44.26*/subFields/*44.35*/.zipWithIndex.map/*44.52*/ { case (subField, idx) =>_display_(Seq[Any](format.raw/*44.78*/("""
                        """),_display_(Seq[Any](/*45.26*/if(idx % 6 == 0)/*45.42*/ {_display_(Seq[Any](format.raw/*45.44*/("""
                            <span class="btn-group" data-toggle="buttons-checkbox">
                                """)))})),format.raw/*47.34*/("""
                                    <button class="btn btn-inverse radio active" id="sf_"""),_display_(Seq[Any](/*48.90*/subField/*48.98*/.id)),format.raw/*48.101*/("""" style="width:130px;margin-bottom:5px;">
                                        <span class="buttontext">"""),_display_(Seq[Any](/*49.67*/subField/*49.75*/.name)),format.raw/*49.80*/("""</span>
                                    </button>
                                    """),_display_(Seq[Any](/*51.38*/if((idx + 1) % 6 == 0)/*51.60*/ {_display_(Seq[Any](format.raw/*51.62*/("""
                                </span>
                                """)))})),format.raw/*53.34*/("""
                                """)))})),format.raw/*54.34*/("""
                            </div>
                        </div>
                    </div>
                    
                    <!-- List headers -->
                    <div class="vertical-spacing-20">
                    </div>
                    <div class="row">
                        <div class="span5 offset2" style="text-align:left;">
                            <h6 style="font-size:9pt;">Name</h6>
                        </div>
                        <div id="userSort" class="span1" style="text-align:right;">
                            <h6 style="font-size:9pt;">
                                <i class="icon-circle-arrow-down">
                                </i> 
                                <a href="#" style="color:#9B9B9B">User</a>
                            </h6>
                        </div>
                        <div id="extSort" class="span1" style="text-align:right;">
                            <h6 style="font-size:9pt;">
                                <i class="">
                                </i>
                                <a href="#" style="color:#9B9B9B">Ext.</a>
                            </h6>
                        </div>
                        <div id="avgSort" class="span1" style="text-align:right;">
                            <h6 style="font-size:9pt;">
                                <i class="">
                                </i>
                                <a href="#" style="color:#9B9B9B">Avg.</a>
                            </h6>
                        </div>
                    </div>
                    <div class="vertical-spacing-10">
                    </div>
                    
                    <!-- List of conferences and pagination -->
                    <input type="hidden" id="orderBy" value="user" />
                    <input type="hidden" id="sort" value="desc" />
                    <input type="hidden" id="fieldId" value=""""),_display_(Seq[Any](/*94.63*/fieldId)),format.raw/*94.70*/("""" />
                    <div id="conferenceList">
                        """),_display_(Seq[Any](/*96.26*/rankingConferences(conferences, 1, pageNum, pageMax, nameFilter))),format.raw/*96.90*/("""
                    </div>
                </div>
                <script src=""""),_display_(Seq[Any](/*99.31*/routes/*99.37*/.Assets.at("javascripts/paginate.js"))),format.raw/*99.74*/("""" type="text/javascript">
                </script>
                """)))})))}
    }
    
    def render(fieldId:Long,conferences:List[scala.Tuple2[Conference, Int]],subFields:List[models.SubField],pageNum:Int,pageMax:Double,nameFilter:String,request:RequestHeader) = apply(fieldId,conferences,subFields,pageNum,pageMax,nameFilter)(request)
    
    def f:((Long,List[scala.Tuple2[Conference, Int]],List[models.SubField],Int,Double,String) => (RequestHeader) => play.api.templates.Html) = (fieldId,conferences,subFields,pageNum,pageMax,nameFilter) => (request) => apply(fieldId,conferences,subFields,pageNum,pageMax,nameFilter)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 19 20:55:34 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/ranking.scala.html
                    HASH: c8352be9a1124e4c213e48559448abf73f606949
                    MATRIX: 595->1|865->177|893->196|929->198|950->211|989->213|1069->247|1287->418|3161->2256|3179->2265|3205->2282|3269->2308|3331->2334|3356->2350|3396->2352|3546->2470|3672->2560|3689->2568|3715->2571|3859->2679|3876->2687|3903->2692|4030->2783|4061->2805|4101->2807|4207->2881|4273->2915|6257->4863|6286->4870|6398->4946|6484->5010|6601->5091|6616->5097|6675->5134
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|28->7|35->14|65->44|65->44|65->44|65->44|66->45|66->45|66->45|68->47|69->48|69->48|69->48|70->49|70->49|70->49|72->51|72->51|72->51|74->53|75->54|115->94|115->94|117->96|117->96|120->99|120->99|120->99
                    -- GENERATED --
                */
            