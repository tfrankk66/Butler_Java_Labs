package butler_java2_lab3_carpetcalculator;

public class RoomDimension {
    private double width;
    private double length;
    
    public RoomDimension(){
        this.width = 0;
        this.length = 0;
    }
    public RoomDimension(RoomDimension rmDim){
        this.width = rmDim.width;
        this.length = rmDim.length;
    }

    //Accesor/Mutator Methods
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    
    //Area Calculation
    double getArea(double w, double l){
        return w * l;
    }
}
