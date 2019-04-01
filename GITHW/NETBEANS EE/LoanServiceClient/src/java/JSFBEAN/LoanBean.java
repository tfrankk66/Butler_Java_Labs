/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBEAN;

import LoanWeb.LoanService;
import LoanWeb.LoanWebService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tfran
 */
@ManagedBean(name ="loan")
@RequestScoped
public class LoanBean {
    private double loanAmt;
    private double annInt;
    private int years;
    
    
    /**
     * Creates a new instance of LoanBean
     */
    public LoanBean() {
    }
    
    public String getOuput(){
        
        LoanWebService loanWebServ = new LoanWebService();
        LoanService port = loanWebServ.getLoanServicePort();
        
        double monthlyPayment = port.monthlyPayment(annInt, loanAmt, years);
        
        Double tp = port.totalPayment(monthlyPayment, years);
        return " " + monthlyPayment + " " + tp;
    }
    
    public String resultPage(){
        return "clientResult";
    }
    
    public void reset(){
        this.setLoanAmt(0);
        this.setAnnInt(0);
        this.setYears(0);
    }

    public double getLoanAmt() {
        return loanAmt;
    }
    public void setLoanAmt(double loanAmt) {
        this.loanAmt = loanAmt;
    }
    public double getAnnInt() {
        return annInt;
    }
    public void setAnnInt(double annInt) {
        this.annInt = annInt;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
    
}
