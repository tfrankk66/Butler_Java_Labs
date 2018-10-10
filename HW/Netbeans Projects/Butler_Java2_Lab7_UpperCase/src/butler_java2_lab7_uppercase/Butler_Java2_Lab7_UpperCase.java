package butler_java2_lab7_uppercase;

import java.util.Scanner;
import java.io.*;

public class Butler_Java2_Lab7_UpperCase {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        //Get File names 
        System.out.println("Welcome to the Uppercase File Converter Program!");
        System.out.print("To start please enter the name of a file you would like to convert the text of: ");
        String iF = input.nextLine();
        System.out.print("\nPlease enter the name of a file you would like to store the converted text to: ");
        String oF = input.nextLine();
        
        //Create the File & Check Existence
        File iFile = new File(iF);
        File oFile = new File(oF);
        if(!iFile.exists()){
            System.out.println("The file " + iF + " is not found.");
            System.exit(0);
        }
        if(!oFile.exists()){
            System.out.println("The file " + oF + " is not found.");
            System.exit(0);
        }
        
        //Open File for reading and writing
        Scanner inputFile = new Scanner(iFile); 
        PrintWriter outputFile = new PrintWriter(oF);
        
        while(inputFile.hasNext())
        {
            String c = inputFile.next();
            c = c.toUpperCase();
            outputFile.print(c);
        } 
        
        inputFile.close();
        outputFile.close();
        
        
        System.out.println("File data converted to upper case.");
    }
    
}
