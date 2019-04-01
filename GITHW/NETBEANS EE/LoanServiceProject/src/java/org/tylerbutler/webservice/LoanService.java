/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tylerbutler.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author tfran
 */
@WebService(name = "LoanService", serviceName = "LoanWebService")
public class LoanService {
    
    @WebMethod(operationName = "monthlyPayment")
    public double getMonthlyPayment(@WebParam(name = "annInt") double annualInterestRate, @WebParam(name = "loanAmt") double loanAmount, @WebParam(name = "years") int numberOfYears) {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }
    
    @WebMethod(operationName = "totalPayment")
    public double getTotalPayment(@WebParam(name = "monthlyPayment") double monthlyPayment, @WebParam(name = "numberOfYears") int numberOfYears) {
        double totalPayment = monthlyPayment * numberOfYears * 12;
        return totalPayment;
    }
}
