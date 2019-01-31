package butler_java2_lab5_bankandsavingsaccountdemo;
import java.text.DecimalFormat;
public abstract class BankAccount {
    private double balance;
    private double monthDep;
    private double withdrawals;
    private double intRate;
    private double monthlyCharge;
    DecimalFormat df = new DecimalFormat("#######.##");
    
    //Constructor
    public BankAccount(double b, double i){
        balance = b;
        intRate = i;
    }

    //Getters and Setters
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getMonthDep() {
        return monthDep;
    }
    public void setMonthDep(double monthDep) {
        this.monthDep = monthDep;
    }
    public double getWithdrawals() {
        return withdrawals;
    }
    public void setWithdrawals(double withdrawals) {
        this.withdrawals = withdrawals;
    }
    public double getIntRate() {
        return intRate;
    }
    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }
    public double getMonthlyCharge() {
        return monthlyCharge;
    }
    public void setMonthlyCharge(double monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }
    
    //Abtract Methods
    public void deposit(double d){
        setBalance(getBalance() + d);
        setMonthDep(getMonthDep() + 1);
        System.out.println("\nDeposit Made.");
    }
    
    public void withdraw(double w){
        setBalance(getBalance() - w);
        setWithdrawals(getWithdrawals() + 1);
        System.out.println("\nWithdrawal Made.");
    }
    
    public void calcInterest(){
        double monthlyIntRate = (getIntRate() / 12.0);
        double monthlyInt = getBalance() * monthlyIntRate;
        System.out.println("Monthly Charge: $" + df.format(getMonthlyCharge()));
        System.out.println("Interest Amount: $" + df.format(monthlyInt));
        setBalance(getBalance() + monthlyInt);
    }
    
    public void monthlyProcess(){
        System.out.println("\nRunning Monthly Process...\n");
        setBalance(getBalance() - getMonthlyCharge());
        calcInterest();
        setWithdrawals(0);
        setMonthDep(0);
        setMonthlyCharge(0);
        
        System.out.println("\nMonthly Process Complete...");
    }
    
}
