package butler_java2_lab5_bankandsavingsaccountdemo;
import java.util.Scanner;
public class Butler_Java2_Lab5_BankandSavingsAccountDemo {

    public static void main(String[] args) {
        double bal;
        int temp;
        double temp2;
        double interest;
        boolean decision = false;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello and welcome to the Abstract Class Demo.");
        System.out.print("\nPlease enter a balance for your savings account: ");
        bal = input.nextDouble();
        System.out.print("Please enter a interest rate for your savings account: ");
        interest = input.nextDouble();
        
        SavingsAccount save = new SavingsAccount(bal, interest);
        
        while(decision == false){
            System.out.print(save);
            System.out.println("\nTo make a withdrawal press 1 \nTo make a deposit press 2 \nTo run the monthly process press 3 \nTo exit the program press 4\n");
            temp = input.nextInt();
            
            switch (temp) {
                case 1:
                    System.out.print("Please enter the withdrawal amount: ");
                    temp2 = input.nextDouble();
                    save.withdraw(temp2);
                    break;
                case 2:
                    System.out.print("Please enter the deposit amount: ");
                    temp2 = input.nextDouble();
                    save.deposit(temp2);
                    break;
                case 3:
                    save.monthlyProcess();
                    break;
                default:
                    decision = true;
                    break;
            }
        }
        
    }
    
}
