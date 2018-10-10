package butler_java2_midtermproject;

//Imports
import java.util.Scanner;
import java.text.DecimalFormat;

public class Butler_Java2_MidtermProject {

    public static void main(String[] args) {
        //Declarations
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##");
        SavingAccount.annualInterestRate = 0.04;
        
        //Instatiations
        SavingAccount saver1 = new SavingAccount("saver1", 2000.0);
        SavingAccount saver2 = new SavingAccount("saver2", 3000.0);
        
        //Welcome Messsage
        System.out.println("Welcome to the Savings Account Midterm Project.\nThis program will monitor two savings accounts and their activity.\n");
        System.out.println("Objects Instantiated and Annual Interest Rate set to: $" + df.format(SavingAccount.annualInterestRate * 100.0) +"%");
        System.out.println("Account 1 balance set to: $" + SavingAccount.df.format(saver1.getSavingsBalance()));
        System.out.println("Account 2 balance set to: $" + SavingAccount.df.format(saver2.getSavingsBalance()) + "\n");
        
        //Calculate first 12 months
        for(int i = 0; i < 12; i++){
            //Monthly Interest Calculation
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            
            //Display Message
            System.out.print("Month #" + (i + 1));
            System.out.print(saver1.toString());
            System.out.println(saver2.toString() + "\n---------------------------------------\n");
        }
        
        //Set and Display new Annual Interest Rate
        SavingAccount.annualInterestRate = 0.05;
        System.out.println("Annual Interest Rate set to: " + df.format(SavingAccount.annualInterestRate * 100.0) + "%\n");
        
        //Calculate second 12 months
        for(int i = 12; i < 24; i++){
            //Monthly Interest Calculation
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            
            //Display Message
            System.out.print("Month #"  + (i + 1));
            System.out.print(saver1.toString());
            System.out.println(saver2.toString() + "\n---------------------------------------\n");
        }
        
        
        
    }
    
}
