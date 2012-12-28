
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
object scores extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Conference,Option[User],Option[UserVote],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(conference : Conference, user: Option[User], vote : Option[UserVote]):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.72*/("""

"""),format.raw/*5.1*/("""
<div class="vertical-spacing-20"></div>

<div class="row">
<div class="span7"><h3>Scores</h3></div>
"""),_display_(Seq[Any](/*10.2*/if(user.isDefined)/*10.20*/ {_display_(Seq[Any](format.raw/*10.22*/("""
<div class="span1"><a href="#" class="btn" id="show_vote_form"><i class="icon-thumbs-up"></i> Vote</a></div>
""")))})),format.raw/*12.2*/("""
</div>

<div class="row">
    <div class="alert alert-info span6 offset1" id="vote_remove" style="display:none;padding-right:0px;padding-left:0px;margin-top:10px;margin-bottom:10px;">
        <h4 style="text-align:center;">
            You have already voted """),_display_(Seq[Any](/*18.37*/{if(vote.isDefined) snippets.badge(Option(vote.get.score)) })),format.raw/*18.97*/(""". Do you want to 
            <a href="#" id="remove_vote">remove</a>
            your vote ?
        </h4>
    </div>
</div>

<div id="vote_form" style="display:none;margin-top:10px;">
    <div class="score span2 vote_rankA" id="vote_rankA">
        <div class="vertical-spacing-15 vote_rankA"></div>
        <span class="vote_rankA" style="font-size:18pt;">Rank </span>
        <span class="badge badge-success vote_rankA" style="font-size:18pt;">A</span>
        <div class="vertical-spacing-20 vote_rankA"></div>
        <span class="vote_rankA">Top venue in the domain. The accepted articles are both original and.<br/>Highly selective.</span>
    </div>
    <div class="score span2" id="vote_rankB">
        <div class="vertical-spacing-15"></div>
        <span style="font-size:18pt;">Rank </span><span class="badge badge-warning" style="font-size:18pt;">B</span>
        <div class="vertical-spacing-20"></div>
        Good conference. The accepted articles are usually good. <br/>Selective conference.
    </div>
    <div class="score span2" id="vote_rankC">
        <div class="vertical-spacing-15"></div>
        <span style="font-size:18pt;">Rank </span><span class="badge badge-info" style="font-size:18pt;">C</span>
        <div class="vertical-spacing-20"></div>
        The scientific content might not be very good, however it allows to meet the community.
    </div>
    <div class="score span2" id="vote_rankD">
        <div class="vertical-spacing-15"></div>
        <span style="font-size:18pt;">Rank </span><span class="badge badge-important" style="font-size:18pt;">X</span>
        <div class="vertical-spacing-20"></div>
        Poor scientific content. The organizers are know for scientific bad practice. Must be avoid.
    </div>
</div>  

<div class="row">
    <div id="external_scores">
        """),_display_(Seq[Any](/*55.10*/conferences/*55.21*/.scoresExternal(conference))),format.raw/*55.48*/("""
    </div>
    
    <div id="user_scores">
        """),_display_(Seq[Any](/*59.10*/conferences/*59.21*/.userScores(conference.userVotes))),format.raw/*59.54*/("""
    </div>
    
</div>
"""))}
    }
    
    def render(conference:Conference,user:Option[User],vote:Option[UserVote]) = apply(conference,user,vote)
    
    def f:((Conference,Option[User],Option[UserVote]) => play.api.templates.Html) = (conference,user,vote) => apply(conference,user,vote)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/conferences/scores.scala.html
                    HASH: 73adada42b311c222be91018ca8f2ef88b84cd6c
                    MATRIX: 552->1|749->71|777->124|914->226|941->244|981->246|1123->357|1420->618|1502->678|3364->2504|3384->2515|3433->2542|3522->2595|3542->2606|3597->2639
                    LINES: 19->1|25->1|27->5|32->10|32->10|32->10|34->12|40->18|40->18|77->55|77->55|77->55|81->59|81->59|81->59
                    -- GENERATED --
                */
            