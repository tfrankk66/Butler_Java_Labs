package butler_java2_lab3_carpetcalculator;

import java.text.DecimalFormat;

public class RoomCarpet {
    private double cpCost;
    private RoomDimension roomDim;
    DecimalFormat df = new DecimalFormat("######.##");
    
    public RoomCarpet(double c, RoomDimension rmDim){
        this.setCpCost(c);      
        roomDim = new RoomDimension(rmDim);
    }

    //Accesor/Mutator Methods
    public double getCpCost() {
        return cpCost;
    }
    public void setCpCost(double cpCost) {
        this.cpCost = cpCost;
    }
    
    public double getTotalCost(){
        return this.getCpCost() * roomDim.getArea(roomDim.getWidth(), roomDim.getLength());
    }
    
    public String toString(){
        String str = "\nYour Information: \n\n" + 
                     "Width: " + roomDim.getWidth() +
                     "\nLength: " + roomDim.getLength() +
                     "\nArea: " + df.format(roomDim.getArea(roomDim.getWidth(), roomDim.getLength())) + 
                     "\nCost of carpet per Square Foot: $" + df.format(this.getCpCost()) +
                     "\nTotal Cost: $" + df.format(this.getTotalCost());
        
        return str;
    }
}
