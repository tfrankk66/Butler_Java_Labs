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
        request.createStateTax("AL", 0.06);
        request.createStateTax("AK", 0.04);
        request.createStateTax("AZ", 0.08);
        request.createStateTax("AR", 0.06);
        request.createStateTax("CA", 0.07);
        request.createStateTax("CO", 0.07);
        request.createStateTax("CT", 0.08);
        request.createStateTax("DE", 0.06);
        request.createStateTax("FL", 0.02);
        request.createStateTax("GA", 0.03);
        request.createStateTax("HI", 0.07);
        request.createStateTax("ID", 0.09);
        request.createStateTax("IL", 0.08);
        request.createStateTax("IN", 0.07);
        request.createStateTax("IA", 0.08);
        request.createStateTax("KS", 0.06);
        request.createStateTax("KY", 0.10);
        request.createStateTax("LA", 0.05);
        request.createStateTax("ME", 0.06);
        request.createStateTax("MD", 0.08);
        request.createStateTax("MA", 0.09);
        request.createStateTax("MI", 0.10);
        request.createStateTax("MN", 0.11);
        request.createStateTax("MS", 0.05);
        request.createStateTax("MO", 0.08);
        request.createStateTax("MT", 0.06);
        request.createStateTax("NE", 0.06);
        request.createStateTax("NV", 0.07);
        request.createStateTax("NH", 0.06);
        request.createStateTax("NJ", 0.09);
        request.createStateTax("NM", 0.03);
        request.createStateTax("NY", 0.04);
        request.createStateTax("NC", 0.07);
        request.createStateTax("ND", 0.08);
        request.createStateTax("OH", 0.09);
        request.createStateTax("OK", 0.06);
        request.createStateTax("OR", 0.07);
        request.createStateTax("PA", 0.06);
        request.createStateTax("RI", 0.07);
        request.createStateTax("SC", 0.08);
        request.createStateTax("SD", 0.06);
        request.createStateTax("TN", 0.06);
        request.createStateTax("TX", 0.09);
        request.createStateTax("UT", 0.09);
        request.createStateTax("VT", 0.08);
        request.createStateTax("VA", 0.06);
        request.createStateTax("WA", 0.07);
        request.createStateTax("WV", 0.06);
        request.createStateTax("WI", 0.08);
        request.createStateTax("WY", 0.06);
    }
}
