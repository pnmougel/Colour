
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
object privacy extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<p>The authors are concerned by personal privacy on the Internet. Consequently, by default your activity on the website will not be available to other. 
However, in order to avoid bad behaviors, our information system keep the following data about logged user:</p>
<ul>
    <li>Mail address</li>
    <li>Hashed password (we are unable to retrieve your password)</li>
    <li>Votes and date of vote</li>
    <li>Messages posted and the date</li>
    <li>Publication information updates and the date</li>
</ul>

<p>If you do not want these information to be kept, do not use an account.</p>

<h6>Cookies</h6>

<p>A cookie is stored on you computer in order to identify your session. If you do not accept cookies, you will not be able to log, other functionalities will remain available.</p>

<h6>Public profile</h6>

<p>If you accept that others might get access to your activity, <a href="">update your profile</a> and check the "Make your profile public" option. Your email address and password will never be divulgated.</p>
 
<p>Your data will be available to third users through the API and might be useful to other researchers in order to improve community and ranking systems. 
Note that we do not check the usage made of the collected data by third parties.</p> 
 
<h6>Cookies</h6>
 """))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:09 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/help/privacy.scala.html
                    HASH: b261598130675c3a914eb93074d1ce6ba620cc5d
                    MATRIX: 576->1
                    LINES: 22->2
                    -- GENERATED --
                */
            