
package views.html.snippets

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
object search extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/helper/*1.8*/.form(routes.Search.search, 'class -> "form-inline")/*1.60*/ {_display_(Seq[Any](format.raw/*1.62*/("""
    <div class="input-append">
        <input type="text" id="query" name="query" value="" class="span3 typeAhead" placeholder="Search a conference...">
        <button class="btn" type="submit"><i class="icon-search"></i></button>
        <br/>
        <a href="#" style="color:#333;" id="displayAdvancedSearch">Advanced search</a>
        <div id="advancedSearch" style="display:none;">
            <fieldset class="well">
            <div class="control-group">
                <label class="control-label" for="shortName">Short Name</label>
                <div class="controls">
                    <input type="text" class="input" id="shortName" name="shortName" placeholder="Short name">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="type" >Type</label>
                <div class="controls">
                    <select id="type" name="type" class="" style="background-color:white;">
                       <option value="-1">Any</option>
                        """),_display_(Seq[Any](/*20.26*/CType/*20.31*/.all().map/*20.41*/ { ctype =>_display_(Seq[Any](format.raw/*20.52*/("""
                            <option value=""""),_display_(Seq[Any](/*21.45*/ctype/*21.50*/.id)),format.raw/*21.53*/("""">"""),_display_(Seq[Any](/*21.56*/ctype/*21.61*/.name)),format.raw/*21.66*/("""</option>
                        """)))})),format.raw/*22.26*/("""
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="field">Field</label>
                <div class="controls">
                    <select id="field" name="field" class=""  style="background-color:white;">
                       <option value="-1">Any</option>
                        """),_display_(Seq[Any](/*31.26*/models/*31.32*/.Field.all().map/*31.48*/ { field =>_display_(Seq[Any](format.raw/*31.59*/("""
                            <option value=""""),_display_(Seq[Any](/*32.45*/field/*32.50*/.id)),format.raw/*32.53*/("""">"""),_display_(Seq[Any](/*32.56*/field/*32.61*/.name)),format.raw/*32.66*/("""</option>
                        """)))})),format.raw/*33.26*/("""
                    </select>
                </div>
            </div>
            </fieldset>
        </div>
    </div>
""")))})))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 28 12:49:10 NCT 2012
                    SOURCE: /home/nico/Dropbox/workspace_scala/Colour/app/views/snippets/search.scala.html
                    HASH: e8830a5cd68a6db008db08922312ef0ad27d061f
                    MATRIX: 588->1|601->7|661->59|700->61|1795->1120|1809->1125|1828->1135|1877->1146|1958->1191|1972->1196|1997->1199|2036->1202|2050->1207|2077->1212|2144->1247|2578->1645|2593->1651|2618->1667|2667->1678|2748->1723|2762->1728|2787->1731|2826->1734|2840->1739|2867->1744|2934->1779
                    LINES: 22->1|22->1|22->1|22->1|41->20|41->20|41->20|41->20|42->21|42->21|42->21|42->21|42->21|42->21|43->22|52->31|52->31|52->31|52->31|53->32|53->32|53->32|53->32|53->32|53->32|54->33
                    -- GENERATED --
                */
            