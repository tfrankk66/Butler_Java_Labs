package javaeetutorial.dukesbookstore.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * <p>Singleton bean that initializes the book database for the bookstore
 * example.</p>
 */
@Singleton
@Startup
public class StateTaxConfigBean {

    @EJB
    private StateTaxRequestBean request;
    
    @PostConstruct
    public void createData() {
        request.createStateTax("Alabama-AL", 0.06);
        request.createStateTax("Alaska-AK", 0.04);
        request.createStateTax("Arizona-AZ", 0.08);
        request.createStateTax("Arkansas-AR", 0.06);
        request.createStateTax("California-CA", 0.07);
        request.createStateTax("Colorado-CO", 0.07);
        request.createStateTax("Connecticut-CT", 0.08);
        request.createStateTax("Delawar-DE", 0.06);
        request.createStateTax("Florida-FL", 0.02);
        request.createStateTax("Georgia-GA", 0.03);
        request.createStateTax("Hawaii-HI", 0.07);
        request.createStateTax("Idaho-ID", 0.09);
        request.createStateTax("Illinois-IL", 0.08);
        request.createStateTax("Indiana-IN", 0.07);
        request.createStateTax("Iowa-IA", 0.08);
        request.createStateTax("Kansas-KS", 0.06);
        request.createStateTax("Kentucky-KY", 0.10);
        request.createStateTax("Louisiana-LA", 0.05);
        request.createStateTax("Maine-ME", 0.06);
        request.createStateTax("Maryland-MD", 0.08);
        request.createStateTax("Massachusetts-MA", 0.09);
        request.createStateTax("Michigan-MI", 0.10);
        request.createStateTax("Minnesota-MN", 0.11);
        request.createStateTax("Mississippi-MS", 0.05);
        request.createStateTax("Missouri-MO", 0.08);
        request.createStateTax("Montana-MT", 0.06);
        request.createStateTax("Nebraska-NE", 0.06);
        request.createStateTax("Nevada-NV", 0.07);
        request.createStateTax("New Hampshire-NH", 0.06);
        request.createStateTax("New Jersey-NJ", 0.09);
        request.createStateTax("New Mexico-NM", 0.03);
        request.createStateTax("New York-NY", 0.04);
        request.createStateTax("North Carolina-NC", 0.07);
        request.createStateTax("North Dakota-ND", 0.08);
        request.createStateTax("Ohio-OH", 0.09);
        request.createStateTax("Oklahoma-OK", 0.06);
        request.createStateTax("Oregon-OR", 0.07);
        request.createStateTax("Pennsylvania-PA", 0.06);
        request.createStateTax("Rhode Island-RI", 0.07);
        request.createStateTax("South Carolina-SC", 0.08);
        request.createStateTax("South Dakota-SD", 0.06);
        request.createStateTax("Tennessee-TN", 0.06);
        request.createStateTax("Texas-TX", 0.09);
        request.createStateTax("Utah-UT", 0.09);
        request.createStateTax("Vermont-VT", 0.08);
        request.createStateTax("Virginia-VA", 0.06);
        request.createStateTax("Washington-WA", 0.07);
        request.createStateTax("West Virginia-WV", 0.06);
        request.createStateTax("Wisconsin-WI", 0.08);
        request.createStateTax("Wyoming-WY", 0.06);
    }
}
