package butler_java2_lab3_parkingticketsimulator;
import java.text.DecimalFormat;

public class ParkingTicket {
    //Class Fields
    final double FIRSTHOURFEE = 25;
    final double HOURLYFEE = 10;
    boolean isFirstHour;
    private double fFee;
    private double tTime;
    PoliceOfficer pOfficer;
    
    //Copy Constructor
    public ParkingTicket(double parMin, double paidMin){
        this.tTime = parMin-paidMin;
    }
    
    public void setFee(){
        //If number of illegaly parked minutes is less and an hour
        if( this.tTime <= 60.0 )
        {
            this.fFee = FIRSTHOURFEE;
        }
        else
        {
            //Do loop to account for first hour
            do{
                this.fFee = this.fFee += FIRSTHOURFEE;
                this.isFirstHour = true;
            } while (this.isFirstHour == false);
            
            while(this.tTime > 0){
                this.tTime -= 60.0;
                this.fFee += HOURLYFEE;
            }
        }
    }
    
    public void showTicket(String make, String model, String color, String lNum, double parMin, double paidMin, String name, int bNum){
      System.out.println("Parking Ticket");
      System.out.println("--------------");
      System.out.println("Car Make: " + make);
      System.out.println("Car Model: " + model);
      System.out.println("Car Color: " + color);
      System.out.println("Car License Number: " + lNum);
      System.out.println("Parked Minutes: " + parMin);
      System.out.println("Paid Minutes: " + paidMin);
      System.out.println("Officer Name: " + name);
      System.out.println("Officer Badge Number: " + bNum);
      System.out.println("Fee: $" + fFee + "\n");
    }
    
}
