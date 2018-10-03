package butler_java2_scratchpaper;


public class Account {
    private int accNum;
    private String accName;
    private int accAge;
    
    
    public Account(){
        accNum = 0;
        accAge = 0;
    }
    
    public Account(int accN, String accNam, int accA){
        this.accNum = accN;
        this.accName = accNam;
        this.accAge = accA;
    }

    //Mutators
    public int getAccNum() {
        return accNum;
    }
    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }
    public String getAccName() {
        return accName;
    }
    public void setAccName(String accName) {
        this.accName = accName;
    }
    public int getAccAge() {
        return accAge;
    }
    public void setAccAge(int accAge) {
        this.accAge = accAge;
    }
    
}
