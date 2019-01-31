package butler_java2_lab7_filearray;

import java.io.IOException;
import java.util.ArrayList;

public class Butler_Java2_Lab7_FileArray {

    public static void main(String[] args) throws IOException {
        int[] a1 = {21, 45, 67, 76, 78};
        int[] a2 = new int[5];
        
        String fileName = "binaryTest.dat";
        
        Binary.writeArray(fileName, a1);
        Binary.readArray(fileName, a2);
        
    }
    
}
