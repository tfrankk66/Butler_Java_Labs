package butler_java2_lab3_carpetcalculator;
//Imports
import java.text.DecimalFormat;
import java.util.Scanner;
public class Butler_Java2_Lab3_CarpetCalculator_Main {

    public static void main(String[] args) {
        //Initialization
        Scanner input = new Scanner(System.in);
        RoomDimension rDim = new RoomDimension();
        DecimalFormat df = new DecimalFormat("######.##");
        
        //User Input
        System.out.println("Hello and welcome to the Carpet Calculator Program!");
        System.out.println("To start, we need to get some info...");
        System.out.print("\nPlease enter the width for your room(EX: 45.50): ");
        rDim.setWidth(input.nextDouble());
        System.out.print("\nPlease enter the width for your room(EX: 45.50): ");
        rDim.setLength(input.nextDouble());
        
        //Initialize RoomCarpet
        RoomCarpet rmCarp = new RoomCarpet(9, rDim);
        System.out.println(rmCarp);
        
        
        
    }
    
}
