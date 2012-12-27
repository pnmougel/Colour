package controllers.admin

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import controllers.package$
import models.Conference

object Init extends Controller {
    
    def index = Action {
        /* Build the types */
        models.CType.getOrCreate("Journal")
        models.CType.getOrCreate("Conference")
        models.CType.getOrCreate("Workshop")

        /* Build the regions */
        models.Region.getOrCreate("Worldwide", Option("Worldwide"), true)
        
        models.Region.getOrCreate("North America", Option("North American"), true)
        models.Region.getOrCreate("Central America", Option("Central American"), true)
        models.Region.getOrCreate("South America", Option("South American"), true)

        models.Region.getOrCreate("Europe", Option("European"), true)
        models.Region.getOrCreate("Asia",Option("Asian"),  true)
        // models.Region.getOrCreate("Eastern Europe", Option("Eastern European"), true)
        // models.Region.getOrCreate("Scandinavia", Option("Scandinavian"), true)
        models.Region.getOrCreate("Middle East", Option("Middle East"), true)

        // models.Region.getOrCreate("South Asia", Option("South Asian"), true)
        // models.Region.getOrCreate("East Asia", Option("East Asian"), true)
        models.Region.getOrCreate("Oceania", Option("Oceanian"), true)
        models.Region.getOrCreate("Africa", Option("African"), true)
        models.Region.getOrCreate("Other", Option("Other"), true)
        // models.Region.getOrCreate("South Africa", Option("South African"), true)
        // models.Region.getOrCreate("North Africa", Option("North African"), true)
        // models.Region.getOrCreate("Arabia", Option("Arabian"), true)
        
        models.Region.getOrCreate("Afghanistan", Option("Afghan"), false)
        models.Region.getOrCreate("Albania", None, false)
        models.Region.getOrCreate("Algeria", Option("Algerian"), false)
        models.Region.getOrCreate("Andorra", None, false)
        models.Region.getOrCreate("Angola", None, false)
        models.Region.getOrCreate("Antigua and Barbuda", None, false)
        models.Region.getOrCreate("Argentina", None, false)
        models.Region.getOrCreate("Armenia", Option("Armenian"), false)
        models.Region.getOrCreate("Australia", Option("Australian"), false)
        models.Region.getOrCreate("Austria", None, false)
        models.Region.getOrCreate("Azerbaijan", None, false)
        models.Region.getOrCreate("Bahamas", None, false)
        models.Region.getOrCreate("Bahrain", None, false)
        models.Region.getOrCreate("Bangladesh", None, false)
        models.Region.getOrCreate("Barbados", None, false)
        models.Region.getOrCreate("Belarus", None, false)
        models.Region.getOrCreate("Belgium", Option("Belgian"), false)
        models.Region.getOrCreate("Belize", None, false)
        models.Region.getOrCreate("Benin", None, false)
        models.Region.getOrCreate("Bhutan", None, false)
        models.Region.getOrCreate("Bolivia", Option("Bolivian"), false)
        models.Region.getOrCreate("Bosnia and Herzegovina", None, false)
        models.Region.getOrCreate("Botswana", None, false)
        models.Region.getOrCreate("Brazil", Option("Brazilian"), false)
        models.Region.getOrCreate("Brunei", None, false)
        models.Region.getOrCreate("Bulgaria", None, false)
        models.Region.getOrCreate("Burkina Faso", None, false)
        models.Region.getOrCreate("Burundi", None, false)
        models.Region.getOrCreate("Cambodia", None, false)
        models.Region.getOrCreate("Cameroon", None, false)
        models.Region.getOrCreate("Canada", Option("Canadian"), false)
        models.Region.getOrCreate("Cape Verde", None, false)
        models.Region.getOrCreate("Central African Republic", None, false)
        models.Region.getOrCreate("Chad", None, false)
        models.Region.getOrCreate("Chile", Option("Chilian"), false)
        models.Region.getOrCreate("China", Option("Chinese"), false)
        models.Region.getOrCreate("Colombia", Option("Colombian"), false)
        models.Region.getOrCreate("Comoros", None, false)
        models.Region.getOrCreate("Congo", None, false)
        models.Region.getOrCreate("Costa Rica", Option("Costa Rican"), false)
        models.Region.getOrCreate("Cote d'Ivoire", None, false)
        models.Region.getOrCreate("Croatia", Option("Croatian"), false)
        models.Region.getOrCreate("Cuba", Option("Cuban"), false)
        models.Region.getOrCreate("Cyprus", None, false)
        models.Region.getOrCreate("Czech Republic", None, false)
        models.Region.getOrCreate("Denmark", None, false)
        models.Region.getOrCreate("Djibouti", None, false)
        models.Region.getOrCreate("Dominica", None, false)
        models.Region.getOrCreate("Dominican Republic", None, false)
        models.Region.getOrCreate("Ecuador", None, false)
        models.Region.getOrCreate("Egypt", Option("Egyptian"), false)
        models.Region.getOrCreate("El Salvador", None, false)
        models.Region.getOrCreate("Equatorial Guinea", None, false)
        models.Region.getOrCreate("Eritrea", None, false)
        models.Region.getOrCreate("Estonia", None, false)
        models.Region.getOrCreate("Ethiopia", Option("Ethiopian"), false)
        models.Region.getOrCreate("Fiji", None, false)
        models.Region.getOrCreate("Finland", None, false)
        models.Region.getOrCreate("France", Option("French"), false)
        models.Region.getOrCreate("Gabon", None, false)
        models.Region.getOrCreate("Gambia", None, false)
        models.Region.getOrCreate("Georgia", None, false)
        models.Region.getOrCreate("Germany", Option("German"), false)
        models.Region.getOrCreate("Ghana", None, false)
        models.Region.getOrCreate("Greece", Option("Greek"), false)
        models.Region.getOrCreate("Grenada", None, false)
        models.Region.getOrCreate("Guatemala", None, false)
        models.Region.getOrCreate("Guinea", None, false)
        models.Region.getOrCreate("Guinea-Bissau", None, false)
        models.Region.getOrCreate("Guyana", None, false)
        models.Region.getOrCreate("Haiti", None, false)
        models.Region.getOrCreate("Honduras", None, false)
        models.Region.getOrCreate("Hungary", None, false)
        models.Region.getOrCreate("Iceland", None, false)
        models.Region.getOrCreate("India", Option("Indian"), false)
        models.Region.getOrCreate("Indonesia", Option("Indonesian"), false)
        models.Region.getOrCreate("Iran", None, false)
        models.Region.getOrCreate("Iraq", None, false)
        models.Region.getOrCreate("Ireland", Option("Irish"), false)
        models.Region.getOrCreate("Israel", None, false)
        models.Region.getOrCreate("Italy", Option("Italian"), false)
        models.Region.getOrCreate("Jamaica", Option("Jamaican"), false)
        models.Region.getOrCreate("Japan", Option("Japanese"), false)
        models.Region.getOrCreate("Jordan", None, false)
        models.Region.getOrCreate("Kazakhstan", None, false)
        models.Region.getOrCreate("Kenya", None, false)
        models.Region.getOrCreate("Kiribati", None, false)
        models.Region.getOrCreate("North Korea", None, false)
        models.Region.getOrCreate("South Korea", None, false)
        models.Region.getOrCreate("Kuwait", None, false)
        models.Region.getOrCreate("Kyrgyzstan", None, false)
        models.Region.getOrCreate("Laos", None, false)
        models.Region.getOrCreate("Latvia", None, false)
        models.Region.getOrCreate("Lebanon", None, false)
        models.Region.getOrCreate("Lesotho", None, false)
        models.Region.getOrCreate("Liberia", None, false)
        models.Region.getOrCreate("Libya", None, false)
        models.Region.getOrCreate("Liechtenstein", None, false)
        models.Region.getOrCreate("Lithuania", None, false)
        models.Region.getOrCreate("Luxembourg", None, false)
        models.Region.getOrCreate("Macedonia", None, false)
        models.Region.getOrCreate("Madagascar", None, false)
        models.Region.getOrCreate("Malawi", None, false)
        models.Region.getOrCreate("Malaysia", None, false)
        models.Region.getOrCreate("Maldives", None, false)
        models.Region.getOrCreate("Mali", None, false)
        models.Region.getOrCreate("Malta", None, false)
        models.Region.getOrCreate("Marshall Islands", None, false)
        models.Region.getOrCreate("Mauritania", None, false)
        models.Region.getOrCreate("Mauritius", None, false)
        models.Region.getOrCreate("Mexico", None, false)
        models.Region.getOrCreate("Micronesia", None, false)
        models.Region.getOrCreate("Moldova", None, false)
        models.Region.getOrCreate("Monaco", None, false)
        models.Region.getOrCreate("Mongolia", None, false)
        models.Region.getOrCreate("Montenegro", None, false)
        models.Region.getOrCreate("Morocco", None, false)
        models.Region.getOrCreate("Mozambique", None, false)
        models.Region.getOrCreate("Myanmar", None, false)
        models.Region.getOrCreate("Namibia", None, false)
        models.Region.getOrCreate("Nauru", None, false)
        models.Region.getOrCreate("Nepal", None, false)
        models.Region.getOrCreate("Netherlands", None, false)
        models.Region.getOrCreate("New Zealand", None, false)
        models.Region.getOrCreate("Nicaragua", None, false)
        models.Region.getOrCreate("Niger", None, false)
        models.Region.getOrCreate("Nigeria", None, false)
        models.Region.getOrCreate("Norway", None, false)
        models.Region.getOrCreate("Oman", None, false)
        models.Region.getOrCreate("Pakistan", None, false)
        models.Region.getOrCreate("Palau", None, false)
        models.Region.getOrCreate("Panama", None, false)
        models.Region.getOrCreate("Papua New Guinea", None, false)
        models.Region.getOrCreate("Paraguay", None, false)
        models.Region.getOrCreate("Peru", None, false)
        models.Region.getOrCreate("Philippines", None, false)
        models.Region.getOrCreate("Poland", None, false)
        models.Region.getOrCreate("Portugal", None, false)
        models.Region.getOrCreate("Qatar", None, false)
        models.Region.getOrCreate("Romania", None, false)
        models.Region.getOrCreate("Russia", Option("Russian"), false)
        models.Region.getOrCreate("Rwanda", None, false)
        models.Region.getOrCreate("Saint Kitts and Nevis", None, false)
        models.Region.getOrCreate("Saint Lucia", None, false)
        models.Region.getOrCreate("Saint Vincent and the Grenadines", None, false)
        models.Region.getOrCreate("Samoa", None, false)
        models.Region.getOrCreate("San Marino", None, false)
        models.Region.getOrCreate("Sao Tome and Principe", None, false)
        models.Region.getOrCreate("Saudi Arabia", None, false)
        models.Region.getOrCreate("Senegal", None, false)
        models.Region.getOrCreate("Serbia", None, false)
        models.Region.getOrCreate("Seychelles", None, false)
        models.Region.getOrCreate("Sierra Leone", None, false)
        models.Region.getOrCreate("Singapore", None, false)
        models.Region.getOrCreate("Slovakia", None, false)
        models.Region.getOrCreate("Slovenia", None, false)
        models.Region.getOrCreate("Solomon Islands", None, false)
        models.Region.getOrCreate("Somalia", None, false)
        models.Region.getOrCreate("South Africa", None, false)
        models.Region.getOrCreate("Spain", None, false)
        models.Region.getOrCreate("Sri Lanka", None, false)
        models.Region.getOrCreate("Sudan", None, false)
        models.Region.getOrCreate("Suriname", None, false)
        models.Region.getOrCreate("Swaziland", None, false)
        models.Region.getOrCreate("Sweden", Option("Swedesh"), false)
        models.Region.getOrCreate("Switzerland", Option("Swiss"), false)
        models.Region.getOrCreate("Syria", None, false)
        models.Region.getOrCreate("Tajikistan", None, false)
        models.Region.getOrCreate("Tanzania", None, false)
        models.Region.getOrCreate("Thailand", None, false)
        models.Region.getOrCreate("Timor-Leste", None, false)
        models.Region.getOrCreate("Togo", None, false)
        models.Region.getOrCreate("Tonga", None, false)
        models.Region.getOrCreate("Trinidad and Tobago", None, false)
        models.Region.getOrCreate("Tunisia", None, false)
        models.Region.getOrCreate("Turkey", None, false)
        models.Region.getOrCreate("Turkmenistan", None, false)
        models.Region.getOrCreate("Tuvalu", None, false)
        models.Region.getOrCreate("Uganda", None, false)
        models.Region.getOrCreate("Ukraine", None, false)
        models.Region.getOrCreate("United Arab Emirates", None, false)
        models.Region.getOrCreate("United Kingdom", None, false)
        models.Region.getOrCreate("United States", Option("United States"), false)
        models.Region.getOrCreate("Uruguay", None, false)
        models.Region.getOrCreate("Uzbekistan", None, false)
        models.Region.getOrCreate("Vanuatu", None, false)
        models.Region.getOrCreate("Vatican City", None, false)
        models.Region.getOrCreate("Venezuela", None, false)
        models.Region.getOrCreate("Vietnam", Option("Vietnamese"), false)
        models.Region.getOrCreate("Yemen", None, false)
        models.Region.getOrCreate("Zambia", None, false)
        models.Region.getOrCreate("Zimbabwe", None, false)
        Ok
        // Redirect(routes.Admin.list)
    }
}