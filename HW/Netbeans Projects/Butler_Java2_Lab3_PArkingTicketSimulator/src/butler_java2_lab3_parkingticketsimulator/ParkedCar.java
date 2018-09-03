package butler_java2_lab3_parkingticketsimulator;

public class ParkedCar {
    //Class Fields
    private String make;
    private String model;
    private String color;
    private int lNum;
    private double pMin;
    
    //Argument Constructor
    public ParkedCar(String make, String model, String color, int lNum, double pMin){
        this.make = make;
        this.model = model;
        this.color = color;
        this.lNum = lNum;
        this.pMin = pMin;
    }
    
    //Copy Constructor
    public ParkedCar(ParkedCar pCar){
        this.make = pCar.make;
        this.model = pCar.model;
        this.color = pCar.color;
        this.lNum = pCar.lNum;
        this.pMin = pCar.pMin;
    }
    //Accesor/Mutator Methods
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getlNum() {
        return lNum;
    }
    public void setlNum(int lNum) {
        this.lNum = lNum;
    }
    public double getpMin() {
        return pMin;
    }
    public void setpMin(double pMin) {
        this.pMin = pMin;
    }
    
    
    
}
