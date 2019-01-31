package butler_java2_lab3_parkingticketsimulator;

public class PoliceOfficer {
    //Class Fields
    private String name;
    private int badgeNum;
    ParkedCar parCar;
    ParkingMeter parMet;
    ParkingTicket parTicket;
    
    //Object Constructor
    public PoliceOfficer(String n, int b, ParkedCar pCar, ParkingMeter pMeter){
        this.name = n;
        this.badgeNum = b;
        this.parCar = new ParkedCar(pCar);
        this.parMet = new ParkingMeter(pMeter);
    }
    
    public boolean parkedIllegal()
    {
        boolean illegal = false;
        
        if(this.parCar.getpMin()-this.parMet.getPaidMin() > 0){
            illegal = true;
        }
        
        return illegal;
    }
    
    public void issueTicket(){
        this.parTicket = new ParkingTicket(this.parCar.getpMin(), this.parMet.getPaidMin());
        this.parTicket.setFee();
        this.parTicket.showTicket(this.parCar.getMake(), this.parCar.getModel(), this.parCar.getColor(), this.parCar.getlNum(), this.parCar.getpMin(), this.parMet.getPaidMin(), this.name, this.badgeNum);
    }

    //Accesor/Mutator Methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBadgeNum() {
        return badgeNum;
    }
    public void setBadgeNum(int badgeNum) {
        this.badgeNum = badgeNum;
    }
    
    
}
