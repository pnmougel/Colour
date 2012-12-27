
package views.html.conferences

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
object edit extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Conference,RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(conference: Conference)(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.59*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(request)/*6.15*/ {_display_(Seq[Any](format.raw/*6.17*/("""
    <div class="container">
        <div class="row">
            <div class="span5 offset2">
<div class="row">
    <div class="span5">
        <form class="form-horizontal" method="POST" action="/conference/update">
            <input type="hidden" name="id" id="id" value=""""),_display_(Seq[Any](/*13.60*/conference/*13.70*/.id)),format.raw/*13.73*/("""" />
            
            <!-- Short name Edition-->
            <div>
                <input type="text" id="shortName" name="shortName" placeholder="Short name" class="span2" value=""""),_display_(Seq[Any](/*17.115*/conference/*17.125*/.shortName)),format.raw/*17.135*/("""" prev=""""),_display_(Seq[Any](/*17.144*/conference/*17.154*/.shortName)),format.raw/*17.164*/("""" style="font-size: 24px;line-height: 36px;height:28px;font-weight:bold;margin-bottom:7px;"></input>
                <span id="label_name_updated" style="display:none;" class="label label-info pull-right">Updated</span>
            </div>

            <!-- Full name Edition-->
            <div>
                <!-- <textarea class="input span6" type="text" id="name" name="name" placeholder="Full name" class="span6" prev=""""),_display_(Seq[Any](/*23.131*/conference/*23.141*/.description)),format.raw/*23.153*/("""" rows="2" prev=""""),_display_(Seq[Any](/*23.171*/conference/*23.181*/.name)),format.raw/*23.186*/("""" style="font-size: 14px;font-weight:bold;" placeholder="Full name">"""),_display_(Seq[Any](/*23.255*/conference/*23.265*/.name)),format.raw/*23.270*/("""</textarea> -->
                <input type="text" id="name" name="name" placeholder="Full name" class="span5" value=""""),_display_(Seq[Any](/*24.104*/conference/*24.114*/.name)),format.raw/*24.119*/("""" prev=""""),_display_(Seq[Any](/*24.128*/conference/*24.138*/.name)),format.raw/*24.143*/("""" style="font-size: 14px;height:20px;font-weight:bold;"></input>
            </div>

            <!-- General information -->
            <div class="accordion" id="accordion2" style="margin-top:15px;">
              <div class="accordion-group">
                <div class="accordion-heading">
                  <a class="accordion-toggle grayGradient" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                    General information
                  </a>
                </div>
                <div id="collapseOne" class="accordion-body collapse in">
                  <div class="accordion-inner">

            <!-- Type Edition-->
            <label class="control-label" for="type" style="text-align:left;"><h5>Type</h5></label>
            <div class="controls">
                <select id="type" name="type" prev=""""),_display_(Seq[Any](/*41.54*/conference/*41.64*/.ctypeId)),format.raw/*41.72*/("""">
                """),_display_(Seq[Any](/*42.18*/models/*42.24*/.CType.all().map/*42.40*/ { ctype =>_display_(Seq[Any](format.raw/*42.51*/("""
                    <option value=""""),_display_(Seq[Any](/*43.37*/ctype/*43.42*/.id)),format.raw/*43.45*/("""" """),_display_(Seq[Any](/*43.48*/if(ctype.id == conference.ctypeId)/*43.82*/ {_display_(Seq[Any](format.raw/*43.84*/(""" selected="selected" """)))})),format.raw/*43.106*/(""">"""),_display_(Seq[Any](/*43.108*/ctype/*43.113*/.name)),format.raw/*43.118*/("""</option>
                """)))})),format.raw/*44.18*/("""
                </select>
                <span id="type_label_updated" style="display:none;" class="label label-info pull-right">Updated</span>
            </div>
            <div class="vertical-spacing-10"></div>
            
            <!-- Region Edition -->
            <label class="control-label" for="region" style="text-align:left;"><h5>Region</h5></label>
            <div class="controls">
                <select id="region" name="region" prev=""""),_display_(Seq[Any](/*53.58*/conference/*53.68*/.regionId)),format.raw/*53.77*/("""">
                    <optgroup label="International">
                    """),_display_(Seq[Any](/*55.22*/models/*55.28*/.Region.getInternationalRegions.map/*55.63*/ { region =>_display_(Seq[Any](format.raw/*55.75*/("""
                        <option value=""""),_display_(Seq[Any](/*56.41*/region/*56.47*/.id)),format.raw/*56.50*/("""" """),_display_(Seq[Any](/*56.53*/if(region.id == conference.regionId)/*56.89*/ {_display_(Seq[Any](format.raw/*56.91*/(""" selected="selected" """)))})),format.raw/*56.113*/(""">"""),_display_(Seq[Any](/*56.115*/region/*56.121*/.name)),format.raw/*56.126*/("""</option>
                    """)))})),format.raw/*57.22*/("""
                    </optgroup>
                    <optgroup label="Freq. Countries">
                    """),_display_(Seq[Any](/*60.22*/models/*60.28*/.Region.getFrequentCountries.map/*60.60*/ { region =>_display_(Seq[Any](format.raw/*60.72*/("""
                        <option value=""""),_display_(Seq[Any](/*61.41*/region/*61.47*/.id)),format.raw/*61.50*/("""">"""),_display_(Seq[Any](/*61.53*/region/*61.59*/.name)),format.raw/*61.64*/("""</option>
                    """)))})),format.raw/*62.22*/("""
                    </optgroup>
                    <optgroup label="All Countries">
                    """),_display_(Seq[Any](/*65.22*/models/*65.28*/.Region.getCountries().map/*65.54*/ { region =>_display_(Seq[Any](format.raw/*65.66*/("""
                        <option value=""""),_display_(Seq[Any](/*66.41*/region/*66.47*/.id)),format.raw/*66.50*/("""" """),_display_(Seq[Any](/*66.53*/if(region.id == conference.regionId)/*66.89*/ {_display_(Seq[Any](format.raw/*66.91*/(""" selected="selected" """)))})),format.raw/*66.113*/(""">"""),_display_(Seq[Any](/*66.115*/region/*66.121*/.name)),format.raw/*66.126*/("""</option>
                    """)))})),format.raw/*67.22*/("""
                    </optgroup>
                </select>
                <span id="region_label_updated" class="label label-info pull-right" style="display:none;" >Updated</span>
            </div>
            <div class="vertical-spacing-10"></div>
            
            
            <!-- Subfields Edition-->
            <label class="control-label" for="subFields" style="text-align:left;"><h5>Subfields</h5></label>
            <div class="controls">
                <input type="hidden" id="subFields" name="subFields" value=""""),_display_(Seq[Any](/*78.78*/conference/*78.88*/.subfields.map(_.id).mkString(","))),format.raw/*78.122*/("""" 
                prev=""""),_display_(Seq[Any](/*79.24*/conference/*79.34*/.subfields.map(_.id).mkString(","))),format.raw/*79.68*/("""" />
                <span id="subFields_label_updated" style="display:none;" class="label label-info pull-right">Updated</span>
                <div id="subFieldList" style="width:220px;">
                    """),_display_(Seq[Any](/*82.22*/conference/*82.32*/.subfields.map/*82.46*/ { subField =>_display_(Seq[Any](format.raw/*82.60*/("""
                    <div class="subfield" id="subfield_"""),_display_(Seq[Any](/*83.57*/subField/*83.65*/.id)),format.raw/*83.68*/("""">
                        """),_display_(Seq[Any](/*84.26*/subField/*84.34*/.name)),format.raw/*84.39*/("""
                        <button type="button" class="close" data-dismiss="alert" onclick="removeSubfield("""),_display_(Seq[Any](/*85.107*/subField/*85.115*/.id)),format.raw/*85.118*/(""");">×</button>
                    </div>
                    """)))})),format.raw/*87.22*/("""
                </div>
                
                <select id="subfield_field">
                    <option disabled selected="selected" style="display:none;" value="-1">Select a subfield</option>
                """),_display_(Seq[Any](/*92.18*/SubField/*92.26*/.getByField(conference.fieldId).map/*92.61*/ { subfield =>_display_(Seq[Any](format.raw/*92.75*/("""
                    <option value=""""),_display_(Seq[Any](/*93.37*/subfield/*93.45*/.id)),format.raw/*93.48*/("""">"""),_display_(Seq[Any](/*93.51*/subfield/*93.59*/.name)),format.raw/*93.64*/("""</option>
                """)))})),format.raw/*94.18*/("""
                </select>
                    <!-- <span><a id="addSubbFieldButton" class="btn" href="#"><i class="icon-plus"></i> Add</a></span> -->
            </div>
            <div class="vertical-spacing-10"></div>

            <!-- Year starting Edition-->
            <label class="control-label" for="startedOn" style="text-align:left;"><h5>Started in</h5></label>
            <div class="controls">
                <select id="startedOn" name="startedOn" class="span1" prev=""""),_display_(Seq[Any](/*103.78*/conference/*103.88*/.yearSince)),format.raw/*103.98*/("""">
                    <option value="0" style="display:none;">Year</option>
                    """),_display_(Seq[Any](/*105.22*/Range(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), 1800, -1)/*105.100*/.map/*105.104*/ { year =>_display_(Seq[Any](format.raw/*105.114*/("""
                    <option value=""""),_display_(Seq[Any](/*106.37*/year)),format.raw/*106.41*/("""" """),_display_(Seq[Any](/*106.44*/if(conference.yearSince.isDefined && conference.yearSince.get == year)/*106.114*/ {_display_(Seq[Any](format.raw/*106.116*/(""" selected="selected" """)))})),format.raw/*106.138*/(""" >"""),_display_(Seq[Any](/*106.141*/year)),format.raw/*106.145*/("""</option>
                    """)))})),format.raw/*107.22*/("""
                </select>
                <!--
                <input type="number" maxlength="4" minlength="4" value=""""),_display_(Seq[Any](/*110.74*/conference/*110.84*/.yearSince)),format.raw/*110.94*/("""" min="0" max="2100" step="1" class="input-mini" id="startedOn" name="startedOn" placeholder="Year" prev=""""),_display_(Seq[Any](/*110.201*/conference/*110.211*/.yearSince)),format.raw/*110.221*/(""""></input>
                -->
                <a class="btn" id="resetYear"><i class="icon-remove-circle"></i> Remove</a>
                <span id="startedOn_label_updated" style="display:none;" class="label label-info pull-right">Updated</span>
            </div>
            <div class="vertical-spacing-10"></div>

            <!-- Publisher Edition-->
            <label class="control-label" for="publisher" style="text-align:left;"><h5>Published by</h5></label>
            <div class="controls">
                <input id="publisher" name="publisher" type="text" value=""""),_display_(Seq[Any](/*120.76*/if(conference.publisher.isDefined)/*120.110*/ {_display_(Seq[Any](_display_(Seq[Any](/*120.113*/conference/*120.123*/.publisher.get.name))))})),format.raw/*120.143*/("""" prev=""""),_display_(Seq[Any](/*120.152*/if(conference.publisher.isDefined)/*120.186*/ {_display_(Seq[Any](_display_(Seq[Any](/*120.189*/conference/*120.199*/.publisher.get.name))))})),format.raw/*120.219*/("""" data-provide="typeahead" data-items="4" data-source=""""),_display_(Seq[Any](/*120.275*/models/*120.281*/.Publisher.all().map(_.name).mkString("[\"", "\",\"", "\"]"))),format.raw/*120.341*/(""""></input>
                <span id="publisher_label_updated" style="display:none;" class="label label-info pull-right">Updated</span>
            </div>
            <div class="vertical-spacing-10"></div>

            
            <!-- Description Edition-->
            <label class="control-label" for="description" style="text-align:left;"><h5>Description</h5></label>
            <span id="description_label_updated" style="display:none;" class="label label-info pull-right">Updated</span>
            <textarea class="input" style="width:430px;" id="description" name="description" prev=""""),_display_(Seq[Any](/*129.101*/conference/*129.111*/.description)),format.raw/*129.123*/("""" rows="5" placeholder="Description of the conference or journal">"""),_display_(Seq[Any](/*129.190*/conference/*129.200*/.description)),format.raw/*129.212*/("""</textarea>
            </div>
    </div>
  </div>

  <!-- Links -->
  <div class="accordion-group">
    <div class="accordion-heading">
      <a class="accordion-toggle grayGradient" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
        Links
      </a>
    </div>
    <div id="collapseTwo" class="accordion-body collapse">
      <div class="accordion-inner">
                <h5>Add a new link</h5>
                <div class="vertical-spacing-10"></div>
                <input type="text" id="formAddUrlLabel" name="formAddUrlLabel" placeholder="Label"  style="width:50pt;"></input>
                <input type="text" id="input_form_add_url" name="input_form_add_url" placeholder="Url" style="width:230pt;"></input>
                <button class="btn" id="submit_add_url"><i class="icon-plus-sign"></i></button>
                <p>If not set, the label will be generated from the url.</p>
                """),_display_(Seq[Any](/*149.18*/if(!conference.links.isEmpty)/*149.47*/ {_display_(Seq[Any](format.raw/*149.49*/("""
                <h5>Remove links</h5>
                <div class="vertical-spacing-10"></div>
                """)))})),format.raw/*152.18*/("""
                
        <ul class="unstyled">
        """),_display_(Seq[Any](/*155.10*/conference/*155.20*/.links.map/*155.30*/ { link =>_display_(Seq[Any](format.raw/*155.40*/("""
            """),_display_(Seq[Any](/*156.14*/snippets/*156.22*/.link(link, true))),format.raw/*156.39*/("""
        """)))})),format.raw/*157.10*/("""
        </ul>
      </div>
    </div>
  </div>
</div>
            <!-- Button -->
            <button class="btn btn-primary" type="submit">Save</button>
            <a href="/conference/"""),_display_(Seq[Any](/*165.35*/conference/*165.45*/.id)),format.raw/*165.48*/("""" class="btn btn-info">Cancel</a>
        </form>
    </div>
    
    </div></div><div class="span3" >
        <h2>Change History</h2>
        <div id="history">
        """),_display_(Seq[Any](/*172.10*/snippets/*172.18*/.update.updates(conference.updates))),format.raw/*172.53*/("""
        </div>
        """),_display_(Seq[Any](/*174.10*/if(conference.updates.size >= Update.defaultHistorySize)/*174.66*/ {_display_(Seq[Any](format.raw/*174.68*/("""
        s<a href="#" id="showHistory">View all</a>
        """)))})),format.raw/*176.10*/("""
        
    </div></div>
</div>
                
                <script src=""""),_display_(Seq[Any](/*181.31*/routes/*181.37*/.Assets.at("javascripts/edit.min.js"))),format.raw/*181.74*/("""" type="text/javascript"></script>
""")))})))}
    }
    
    def render(conference:Conference,request:RequestHeader) = apply(conference)(request)
    
    def f:((Conference) => (RequestHeader) => play.api.templates.Html) = (conference) => (request) => apply(conference)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Dec 23 05:19:44 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Confer/app/views/conferences/edit.scala.html
                    HASH: 0cf4bbd5ef3850ade1a425328e4f956e6a87bb31
                    MATRIX: 534->1|718->58|746->111|782->113|803->126|842->128|1155->405|1174->415|1199->418|1425->607|1445->617|1478->627|1524->636|1544->646|1577->656|2040->1082|2060->1092|2095->1104|2150->1122|2170->1132|2198->1137|2304->1206|2324->1216|2352->1221|2508->1340|2528->1350|2556->1355|2602->1364|2622->1374|2650->1379|3539->2232|3558->2242|3588->2250|3644->2270|3659->2276|3684->2292|3733->2303|3806->2340|3820->2345|3845->2348|3884->2351|3927->2385|3967->2387|4022->2409|4061->2411|4076->2416|4104->2421|4163->2448|4660->2909|4679->2919|4710->2928|4823->3005|4838->3011|4882->3046|4932->3058|5009->3099|5024->3105|5049->3108|5088->3111|5133->3147|5173->3149|5228->3171|5267->3173|5283->3179|5311->3184|5374->3215|5519->3324|5534->3330|5575->3362|5625->3374|5702->3415|5717->3421|5742->3424|5781->3427|5796->3433|5823->3438|5886->3469|6029->3576|6044->3582|6079->3608|6129->3620|6206->3661|6221->3667|6246->3670|6285->3673|6330->3709|6370->3711|6425->3733|6464->3735|6480->3741|6508->3746|6571->3777|7144->4314|7163->4324|7220->4358|7282->4384|7301->4394|7357->4428|7604->4639|7623->4649|7646->4663|7698->4677|7791->4734|7808->4742|7833->4745|7897->4773|7914->4781|7941->4786|8085->4893|8103->4901|8129->4904|8224->4967|8480->5187|8497->5195|8541->5230|8593->5244|8666->5281|8683->5289|8708->5292|8747->5295|8764->5303|8791->5308|8850->5335|9374->5822|9394->5832|9427->5842|9562->5940|9651->6018|9666->6022|9716->6032|9790->6069|9817->6073|9857->6076|9938->6146|9980->6148|10036->6170|10077->6173|10105->6177|10169->6208|10327->6329|10347->6339|10380->6349|10525->6456|10546->6466|10580->6476|11196->7055|11241->7089|11292->7092|11313->7102|11361->7122|11408->7131|11453->7165|11504->7168|11525->7178|11573->7198|11667->7254|11684->7260|11768->7320|12401->7915|12422->7925|12458->7937|12563->8004|12584->8014|12620->8026|13590->8959|13629->8988|13670->8990|13815->9102|13909->9159|13929->9169|13949->9179|13998->9189|14049->9203|14067->9211|14107->9228|14150->9238|14376->9427|14396->9437|14422->9440|14630->9611|14648->9619|14706->9654|14768->9679|14834->9735|14875->9737|14969->9798|15087->9879|15103->9885|15163->9922
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|35->13|35->13|35->13|39->17|39->17|39->17|39->17|39->17|39->17|45->23|45->23|45->23|45->23|45->23|45->23|45->23|45->23|45->23|46->24|46->24|46->24|46->24|46->24|46->24|63->41|63->41|63->41|64->42|64->42|64->42|64->42|65->43|65->43|65->43|65->43|65->43|65->43|65->43|65->43|65->43|65->43|66->44|75->53|75->53|75->53|77->55|77->55|77->55|77->55|78->56|78->56|78->56|78->56|78->56|78->56|78->56|78->56|78->56|78->56|79->57|82->60|82->60|82->60|82->60|83->61|83->61|83->61|83->61|83->61|83->61|84->62|87->65|87->65|87->65|87->65|88->66|88->66|88->66|88->66|88->66|88->66|88->66|88->66|88->66|88->66|89->67|100->78|100->78|100->78|101->79|101->79|101->79|104->82|104->82|104->82|104->82|105->83|105->83|105->83|106->84|106->84|106->84|107->85|107->85|107->85|109->87|114->92|114->92|114->92|114->92|115->93|115->93|115->93|115->93|115->93|115->93|116->94|125->103|125->103|125->103|127->105|127->105|127->105|127->105|128->106|128->106|128->106|128->106|128->106|128->106|128->106|128->106|129->107|132->110|132->110|132->110|132->110|132->110|132->110|142->120|142->120|142->120|142->120|142->120|142->120|142->120|142->120|142->120|142->120|142->120|142->120|142->120|151->129|151->129|151->129|151->129|151->129|151->129|171->149|171->149|171->149|174->152|177->155|177->155|177->155|177->155|178->156|178->156|178->156|179->157|187->165|187->165|187->165|194->172|194->172|194->172|196->174|196->174|196->174|198->176|203->181|203->181|203->181
                    -- GENERATED --
                */
            