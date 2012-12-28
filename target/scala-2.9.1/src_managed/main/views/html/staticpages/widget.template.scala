
package views.html.staticpages

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
object widget extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[RequestHeader,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(implicit request: RequestHeader):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.35*/(""" """),_display_(Seq[Any](/*1.37*/main(request)/*1.50*/ {_display_(Seq[Any](format.raw/*1.52*/("""
<div class="container">
	<div class="vertical-spacing-20"></div>
	<div class="row">
		<div class="span8 offset2">
			<span style="font-size: 40pt;"><img
				src="/assets/images/icon2.svg"> Widget</span> <br /> <br />
			<p style="font-size: 15pt;">Display the colour ranking of a
				publication in your website</p>
			<br />
		</div>
	</div>
	<ul class="unstyled" id="widget">
		<li>
			<div class="row">
				<div class="span1 offset2 section">How can I use it?</div>
				<div class="span5 content">
					<p>
						To display the badge, go the page corresponding to the publication
						and click the
						<button class="btn">Get Badge</button>
						button. It will display a small script of the form
					</p>
					<code class="prettyprint lang-html">
						&lt;script src="http://colour.org/wid/<span class="nocode">ID</span>"&gt;&lt;script&gt;
					</code>
					<p style="margin-top: 8px;">
						where
						<code>
							<span class="nocode">ID</span></code> is the publication unique identifier.</p> 
							<span>Copy and paste the content in your webpage.</span>
				</div>
			</div>
		</li>

		<li>
			<div class="row">
				<div class="span1 offset2 section">Customize the widget</div>
				<div class="span5 content">
					
				</div>
			</div>
		</li>
		
        <li>
            <div class="row">
                <div class="span1 offset2 section">Check the rank</div>
                <div class="span5 content">
                    <p>It is is relatively easy to display a ranking which does not correspond to a publication. 
                    To ensure that the displayed badge corresponds to the colour ranking of the publication, click on the link available with the badge.</p> 
                    It should display the page corresponding to the publication in the colour website. 
                    If you have doubt, ensure that the url starts with <code>
                            <span class="nocode">colour-ranking.org</span></code> and that the publication names are matching. 
                </div>
            </div>
        </li>

		<li>
            <div class="row">
                <div class="span1 offset2 section">Using it with bibtex</div>
                <div class="span5 content">
                    <p>We are aware that many researchers display their list of publications using a bibtex file. 
                    Currently, it is not possible to add the colour ranking
                    The main problem is publications sharing the same name, which would lead to displaying a wrong ranking.
                    </p>
                    <p>
                    If you have any idea on how we could integrate nicely the coulour ranking in a bibtex file, do not hesitate to submit it in the <a href="/ideabox">idea box</a>.
                    </p>
                </div>
            </div>
        </li>
	</ul>
</div>
""")))})),format.raw/*74.2*/("""
"""))}
    }
    
    def render(request:RequestHeader) = apply(request)
    
    def f:((RequestHeader) => play.api.templates.Html) = (request) => apply(request)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/staticpages/widget.scala.html
                    HASH: b240ee687a4e42eb11007af3e4e9fb7388899ef0
                    MATRIX: 525->1|635->34|672->36|693->49|732->51|3631->2919
                    LINES: 19->1|22->1|22->1|22->1|22->1|95->74
                    -- GENERATED --
                */
            