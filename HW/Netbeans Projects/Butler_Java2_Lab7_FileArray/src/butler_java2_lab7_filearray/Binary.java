package butler_java2_lab7_filearray;

import java.io.*;

public class Binary 
{
    
    public static void writeArray(String fName, int[] arr) throws IOException{
        
        FileOutputStream foStream = new FileOutputStream(fName);
        DataOutputStream outputFile = new DataOutputStream(foStream);
        
        System.out.println("Writing Data To Binary File: " + fName);
        for(int i = 0; i < arr.length; i++)
        {
            outputFile.writeInt(arr[i]);
        }
        
        outputFile.close();
        System.out.println("Done Writing...");
    }
    
    public static void readArray(String fName, int[] arr) throws IOException{
        
        FileInputStream fiStream = new FileInputStream(fName);
        DataInputStream inputFile = new DataInputStream(fiStream);
        int number;
        boolean endOfFile = false;
        
        
        System.out.println("Reading Data From Binary File: " + fName);
        while(!endOfFile)
        {
            try
            {
                for(int i = 0; i < arr.length; i++)
                {
                    number = inputFile.readInt();
                    arr[i] = number;
                }
            }
            catch (EOFException e){
                endOfFile = true;
            }
        }
        inputFile.close();
        System.out.println("Done Reading...");
    }
    
}
