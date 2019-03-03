/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanCalc;

import java.text.NumberFormat;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tfran
 */
@ManagedBean(name ="loan")
@RequestScoped
public class loanBean {

    private double loanAmt;
    private double annInt;
    private int years;
    private double monthPay;
    private double totPay;
    
   
    public loanBean() {
        
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
    public double getMonthPay() {
        return monthPay;
    }
    public void setMonthPay(double monthPay) {
        this.monthPay = monthPay;
    }
    public double getTotPay() {
        return totPay;
    }
    public void setTotPay(double totPay) {
        this.totPay = totPay;
    }
    
    public void reset(){
        this.loanAmt = 0;
        this.annInt = 0;
        this.years = 0;
    }
    
    public String calcLoan(){
        Loan l = new Loan(this.annInt, this.years, this.loanAmt);
        this.monthPay = l.getMonthlyPayment();
        this.totPay = l.getTotalPayment();
        
        return "result";
    }
    
    public String getOutput(){
        NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.getDefault());
        
        
        return "Loan Amount: " + CF.format(this.loanAmt) + "<br />"
                + "Annual Interest Rate: " + this.annInt + "<br />"
                + "Number of Years: " + this.years + "<br />"
                + "Monthly Payment: " + CF.format(this.monthPay) + "<br />"
                + "Total Payment: " + CF.format(this.totPay);
    }
    
}
