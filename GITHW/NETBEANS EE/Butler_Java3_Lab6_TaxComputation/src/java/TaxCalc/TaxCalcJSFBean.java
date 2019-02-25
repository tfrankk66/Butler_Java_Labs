/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaxCalc;

import java.text.NumberFormat;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Locale;

/**
 *
 * @author tfran
 */
@ManagedBean(name = "taxcalc")
@RequestScoped
public class TaxCalcJSFBean {

    private double taxInc;
    private String fileStat;
    private String taxS;
    private double tax;
    
    public TaxCalcJSFBean() {
    }

    public double getTaxInc() {
        return taxInc;
    }
    public void setTaxInc(double taxInc) {
        this.taxInc = taxInc;
    }
    public String getFileStat() {
        return fileStat;
    }
    public void setFileStat(String fileStat) {
        this.fileStat = fileStat;
    }
    public String getTaxS() {
        return taxS;
    }
    public void setTaxS(String taxS) {
        this.taxS = taxS;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    
    public void calculateTax(){
        if (fileStat.equals("Single")) {
            if (taxInc <= 8350)
                tax = taxInc * 0.10;
            else if (taxInc <= 33950)
                tax = 8350 * 0.10 + (taxInc - 8350) * 0.15;
            else if (taxInc <= 82250)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (taxInc - 33950) * 0.25;
            else if (taxInc <= 171550)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (taxInc - 82250) * 0.28;
            else if (taxInc <= 372950)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (taxInc - 171550) * 0.33;
            else
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (taxInc - 372950) * 0.35;
        }
        else if (fileStat.equals("Married Filing Jointly or Qualifying Widow(er)")) {
            if (taxInc <= 16700)
                tax = taxInc * 0.10;
            else if (taxInc <= 67900)
                tax = 16700 * 0.10 + (taxInc - 16700) * 0.15;
            else if (taxInc <= 137050)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (taxInc - 67900) * 0.25;
            else if (taxInc <= 208850)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (taxInc - 137050) * 0.28;
            else if (taxInc <= 372950)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (171550 - 137050) * 0.28 + (taxInc - 208850) * 0.33;
            else
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (171550 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (taxInc - 372950) * 0.35;
        }
        else if (fileStat.equals("Married Filing Separately")) {
            if (taxInc <= 8350)
                tax = taxInc * 0.10;
            else if (taxInc <= 33950)
                tax = 8350 * 0.10 + (taxInc - 8350) * 0.15;
            else if (taxInc <= 68525)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (taxInc - 33950) * 0.25;
            else if (taxInc <= 104425)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (taxInc - 68525) * 0.28;
            else if (taxInc <= 186475)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (taxInc - 104425) * 0.33;
            else
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 + (taxInc - 186475) * 0.35;
        }
        else if (fileStat.equals("Head of Household")) {
             if (taxInc <= 11950)
                tax = taxInc * 0.10;
            else if (taxInc <= 45500)
                tax = 11950 * 0.10 + (taxInc - 11950) * 0.15;
            else if (taxInc <= 117450)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (taxInc - 45500) * 0.25;
            else if (taxInc <= 190200)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (taxInc - 117450) * 0.28;
            else if (taxInc <= 372950)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (taxInc - 190200) * 0.33;
            else
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 + (taxInc - 372950) * 0.35;
        }
        
        NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.getDefault());
        setTaxS(taxS = CF.format(tax));
    }
    
    public String getOutput(){
        
        return "Taxable Income: " + taxInc + "<br />"
                + "Filing Status: " + fileStat + "<br />"
                + "Tax: " + taxS ; 
                    
    }
}
