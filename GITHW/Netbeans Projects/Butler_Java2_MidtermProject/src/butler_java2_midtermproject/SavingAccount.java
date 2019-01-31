package butler_java2_midtermproject;

import java.util.Scanner;
import java.text.DecimalFormat;

public class SavingAccount {
    //Declarations
    static double annualInterestRate;
    static Scanner input = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("######.##");
    private double savingsBalance;
    private String name;
    
    //Constructor
    public SavingAccount(String a, double b) {
        this.name = a;
        this.savingsBalance = b;
        
        while(this.savingsBalance < 0){
            System.out.print("\nERROR: Savings account balance is negative! Please enter a value that is greater than 0.0: ");
            this.savingsBalance = input.nextDouble();
        }
    }
    
    //Mutators & Accesors
    public double getSavingsBalance() {
        return savingsBalance;
    }
    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //Set & Errorcheck annualInterestRate
    public static void modifyInterestRate(double a){
        annualInterestRate = a;
        
        while(annualInterestRate > 50.0 || annualInterestRate < 0.0){
            System.out.print("\nERROR: Annual Interest Rate is Invalid! Please enter a rate that is greater than 0.0 and less than 0.5: ");
            annualInterestRate = input.nextDouble();
        }
    }
  
    //Calculate monthly interest
    public void calculateMonthlyInterest(){
        double monthInt;
        monthInt = (this.getSavingsBalance() * annualInterestRate) / 12.0;

        this.setSavingsBalance(this.getSavingsBalance() + monthInt);
    }
    
    //Overriden toString call
    @Override
    public String toString(){
        String str = "\nSavingsAccount " + this.getName() + " balance: $" + df.format(this.getSavingsBalance());
        return str;
    }
    
}
