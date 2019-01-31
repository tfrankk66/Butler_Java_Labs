package butler_java2_lab3_parkingticketsimulator;

public class ParkingMeter {
    //Class Fields
    private double paidMin;
    
    //Argument Constructor
    public ParkingMeter(int p){
        this.paidMin = p;
    }
    
    //Copy Constructor
    public ParkingMeter(ParkingMeter pMeter){
        this.paidMin = pMeter.paidMin;
    }

    //Accesor/Mutator Methods
    public double getPaidMin() {
        return paidMin;
    }
    public void setPaidMin(double paidMin) {
        this.paidMin = paidMin;
    }
}
