package butler_java2_lab5_bankandsavingsaccountdemo;
import java.text.DecimalFormat;
public class SavingsAccount extends BankAccount{
    private boolean isActive;
    DecimalFormat df = new DecimalFormat("#######.##");
    
    public SavingsAccount(double b, double i){
        super(b, i);
    }
    
    //Accesors
    public boolean isIsActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    //Overrident Methods
    @Override
    public void withdraw(double w){
        if(accountCheck()){
            super.withdraw(w);
        }
        else{
            System.out.print("ERROR: Account is not active due to balance being below $25. Please deposit more funds.\n");
        }
    }
    @Override
    public void deposit(double d){
        if(accountCheck()){
            super.deposit(d);
        }
        else{
            super.deposit(d);
            accountCheck();
        }
    }
    @Override
    public void monthlyProcess(){
        //Check amount of withdrawals and get service charge
        if(getWithdrawals() > 4){
            setMonthlyCharge((getWithdrawals() - 4));
        }
        else{
            setMonthlyCharge(0);
        }

        //Superclass Method Call
        super.monthlyProcess();
        //Check Account Activity
        accountCheck();
    }
    @Override
    public String toString(){
        String str = "\nAccount Balance: $" + df.format(getBalance()) 
                    +"\nAccount Activity: " + (accountActivity()) + "\n";
        
        return str;
    }
    
    //Account Activity Check
    public boolean accountCheck(){
        if(getBalance() >= 25)
            setIsActive(true);
        else
            setIsActive(false);
        
        return isIsActive();
    }
    
    public String accountActivity(){
        String str;
        
        if(accountCheck()){
            str = "Active";
        }
        else{
            str = "Inactive";
        }
        
        return str;
    }
    
}
