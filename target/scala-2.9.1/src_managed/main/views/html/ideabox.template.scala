
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
object ideabox extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Idea],Option[User],RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(ideas : List[Idea], user : Option[User])(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.76*/(""" """),_display_(Seq[Any](/*1.78*/main(request)/*1.91*/ {_display_(Seq[Any](format.raw/*1.93*/("""
<div class="container">
	<div class="vertical-spacing-20"></div>
	<div class="row">
		<div class="span8 offset2">
			<span style="font-size: 40pt;"><img
				src="/assets/images/icon2.svg"> Idea Box</span> <br /> <br />
			<p style="font-size: 15pt;">
				Vote for the features you would like or
				"""),_display_(Seq[Any](/*10.6*/if(user.isDefined)/*10.24*/ {_display_(Seq[Any](format.raw/*10.26*/("""
				<a href="#" id="toggleShowNewIdea">propose</a>
				 """)))}/*12.8*/else/*12.13*/{_display_(Seq[Any](format.raw/*12.14*/("""propose""")))})),format.raw/*12.22*/(""" a new idea
			</p>
			"""),_display_(Seq[Any](/*14.5*/if(!user.isDefined)/*14.24*/ {_display_(Seq[Any](format.raw/*14.26*/("""
			<p>Only logged users can propose new features or vote.
			""")))})),format.raw/*16.5*/("""
			<br />
		</div>
		<div id="newIdea" class="span6 offset2" style="display: none;">
			"""),_display_(Seq[Any](/*20.5*/helper/*20.11*/.form(routes.IdeaBox.addIdea)/*20.40*/ {_display_(Seq[Any](format.raw/*20.42*/(""" <input type="text" id="name"
				name="name" value="" class="span6" placeholder="Idea name">
			<textarea class="input span6" id="description" name="description"
				rows="5" placeholder="Description"></textarea>
			<br />
			<button type="submit" class="btn btn-primary pull-right">Submit
				a new idea</button>
			""")))})),format.raw/*27.5*/("""
			<div class="vertical-spacing-30"></div>
		</div>

		<div class="span8 offset2">
			<form>
				<div class="input-append">
					<input type="text" id="query" name="query" value="" class="span6"
						placeholder="Search feature">
					<button class="btn" type="submit">
						<i class="icon-search"></i>
					</button>
				</div>
			</form>
			<div class="vertical-spacing-20"></div>
		</div>

		<div id="page_container" style="display:none;">
			<ul class="content unstyled">
				"""),_display_(Seq[Any](/*46.6*/ideas/*46.11*/.map/*46.15*/ { idea =>_display_(Seq[Any](format.raw/*46.25*/("""
				<li>
					<div class="idea row" style="padding-left: 20px;">
						<div class="span1 offset2" style="text-align: right;">
							<span style="font-size: 16pt;" id="nbVotes_"""),_display_(Seq[Any](/*50.52*/idea/*50.56*/.id)),format.raw/*50.59*/("""">"""),_display_(Seq[Any](/*50.62*/idea/*50.66*/.nbVotes)),format.raw/*50.74*/("""</span><br /> <span
								style="font-size: 12pt;">vote"""),_display_(Seq[Any](/*51.39*/if(idea.nbVotes > 1)/*51.59*/ {_display_(Seq[Any](format.raw/*51.61*/("""s""")))})),format.raw/*51.63*/("""</span>
							<div class="vertical-spacing-5"></div>
							"""),_display_(Seq[Any](/*53.9*/if(user.isDefined)/*53.27*/ {_display_(Seq[Any](format.raw/*53.29*/("""
							"""),_display_(Seq[Any](/*54.9*/if(!user.get.ideaLiked.contains(idea.id))/*54.50*/ {_display_(Seq[Any](format.raw/*54.52*/("""
							<button class="btn btn-mini voteUp" for=""""),_display_(Seq[Any](/*55.50*/idea/*55.54*/.id)),format.raw/*55.57*/("""">
								<i class="icon-thumbs-up"></i>
							</button>
							""")))}/*58.10*/else/*58.15*/{_display_(Seq[Any](format.raw/*58.16*/("""
							<button class="btn btn-mini disabled">
                                <i class="icon-heart"></i>
                            </button>
							""")))}))))})),format.raw/*62.10*/("""
						</div>
						<div class="span5"
							style="border-left: 2px solid #333; padding-left: 20px;">
							<p style="font-size: 16pt;">"""),_display_(Seq[Any](/*66.37*/idea/*66.41*/.name)),format.raw/*66.46*/("""</p>
							"""),_display_(Seq[Any](/*67.9*/snippets/*67.17*/.longText(idea.description, 256))),format.raw/*67.49*/("""
							<h6>Proposed <time class="timeago" datetime=""""),_display_(Seq[Any](/*68.54*/idea/*68.58*/.isoDate)),format.raw/*68.66*/(""""></time></h6>
						</div>
					</div>
					
					<div class="vertical-spacing-30"></div>
				</li>
				""")))})),format.raw/*74.6*/("""
			</ul>
			<div class="offset2 span7">
			<span class="page_navigation pagination "></span>
			<div data-toggle="buttons-radio" class="pull-right">
			     Sort by 
			     <button type="button" class="btn">Vote</button>
                 <button type="button" class="btn">Date</button>
                 """),_display_(Seq[Any](/*82.19*/if(user.isDefined)/*82.37*/ {_display_(Seq[Any](format.raw/*82.39*/("""
                 <button type="button" class="btn">I like</button>
                 """)))})),format.raw/*84.19*/("""
			</div>
			</div>
		</div>

	</div>
</div>

<script src=""""),_display_(Seq[Any](/*92.15*/routes/*92.21*/.Assets.at("javascripts/jquery.pajinate.js"))),format.raw/*92.65*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*93.15*/routes/*93.21*/.Assets.at("javascripts/ideabox.min.js"))),format.raw/*93.61*/("""" type="text/javascript"></script>
""")))})),format.raw/*94.2*/("""
"""))}
    }
    
    def render(ideas:List[Idea],user:Option[User],request:RequestHeader) = apply(ideas,user)(request)
    
    def f:((List[Idea],Option[User]) => (RequestHeader) => play.api.templates.Html) = (ideas,user) => (request) => apply(ideas,user)(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:08 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/ideabox.scala.html
                    HASH: f604def8aa87b07380f342061ea38e0bcc356916
                    MATRIX: 538->1|689->75|726->77|747->90|786->92|1122->393|1149->411|1189->413|1265->472|1278->477|1317->478|1357->486|1416->510|1444->529|1484->531|1578->594|1703->684|1718->690|1756->719|1796->721|2146->1040|2665->1524|2679->1529|2692->1533|2740->1543|2954->1721|2967->1725|2992->1728|3031->1731|3044->1735|3074->1743|3168->1801|3197->1821|3237->1823|3271->1825|3368->1887|3395->1905|3435->1907|3479->1916|3529->1957|3569->1959|3655->2009|3668->2013|3693->2016|3779->2084|3792->2089|3831->2090|4020->2243|4196->2383|4209->2387|4236->2392|4284->2405|4301->2413|4355->2445|4445->2499|4458->2503|4488->2511|4625->2617|4967->2923|4994->2941|5034->2943|5152->3029|5249->3090|5264->3096|5330->3140|5415->3189|5430->3195|5492->3235|5559->3271
                    LINES: 19->1|22->1|22->1|22->1|22->1|31->10|31->10|31->10|33->12|33->12|33->12|33->12|35->14|35->14|35->14|37->16|41->20|41->20|41->20|41->20|48->27|67->46|67->46|67->46|67->46|71->50|71->50|71->50|71->50|71->50|71->50|72->51|72->51|72->51|72->51|74->53|74->53|74->53|75->54|75->54|75->54|76->55|76->55|76->55|79->58|79->58|79->58|83->62|87->66|87->66|87->66|88->67|88->67|88->67|89->68|89->68|89->68|95->74|103->82|103->82|103->82|105->84|113->92|113->92|113->92|114->93|114->93|114->93|115->94
                    -- GENERATED --
                */
            