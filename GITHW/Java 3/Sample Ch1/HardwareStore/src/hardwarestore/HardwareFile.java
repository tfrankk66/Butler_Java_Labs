/*
 * HardwareFile class 
 * Represents the random access hardware data file
 * presents interace to hardware data file
 */
package hardwarestore;

import java.io.RandomAccessFile;
import java.io.IOException;
/**
 *
 * @author David Swaim
 */
public class HardwareFile extends RandomAccessFile
{
    public final static int NAME_LENGTH = 32;            // number of chars in name
    // size of a Java char is two bytes becaule it is Unicode
    // thus size is twice length
    public final static int NAME_SIZE = 2 * NAME_LENGTH; // number of bytes in name
    public final static int QUANTITY_SIZE = 4;           // size of integer
    public final static int PRICE_SIZE = 8;              // size of double
    // ture record size
    public final static int RECORD_SIZE = NAME_SIZE + QUANTITY_SIZE + PRICE_SIZE;
    
    public HardwareFile() throws IOException
    {
        // open or create the hardware file on instantiation
        super("hardware.dat","rw");   
    }
    
    public Hardware readHardware(long position) throws IOException {
        Hardware rec = new Hardware();
        
        seek(position);  // locate and read record
        rec.setName(readFixedLengthString(NAME_LENGTH));
        rec.setQuantity(readInt());
        rec.setPrice(readDouble());
        
        return rec;
    }
    
    public void writeHardware(long position, Hardware hItem) {
        try {
            seek(position);  // set position in file
            // write recode - name (fixed length) quantity and price
            writeFixedLengthString(hItem.getName(),NAME_LENGTH);
            writeInt(hItem.getQuantity());
            writeDouble(hItem.getPrice());
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void addHardware(Hardware item) {
        try {
            // add new record to end of file
            writeHardware(length(), item);
        } catch (IOException ex) { }
    }
    
    public Hardware firstHardware() {
        // return first record in file
        Hardware item = null;
        try {
            if (length() > 0) item = readHardware(0);            
        } catch (IOException ex) {
            item = null;
        }
        return item;
    }
    
    public Hardware lastHardware() {
        Hardware item = null;
        try {
            if (length() > 0)  {
                item = readHardware(length() - RECORD_SIZE);   
            }
            else return null;
        } catch (IOException ex) {
            item = null;
        }
        return item;
    }
    
    public Hardware nextHardware() {
        Hardware item = null;
        try {
            long currentPosition = getFilePointer();
            if (currentPosition < length()) {
                item = readHardware(currentPosition);
            }
        } catch (IOException ex) {
            item = null;
        }
        return item;
    }
    
    public Hardware previousHardware() {
        Hardware item = null;
        try {
            long currentPosition = getFilePointer();
            if (currentPosition - RECORD_SIZE > 0)
            {
                item = readHardware(currentPosition - 2 * RECORD_SIZE);
            } else {
                item = readHardware(0);
            }
        } catch (IOException ex) {
            item = null;
        }
        return item;
    }
    
    public void updateHardware(Hardware item) {
        try {
            writeHardware(getFilePointer() - RECORD_SIZE, item);
        } catch (IOException ex) { }        
    }
    
    // utility methods for dealing with fixed length strings
    
    private String readFixedLengthString(int length) throws IOException {
        char[] chars = new char[length];   // fixed length char buffer
        // read string in a character at a time
        for (int i = 0; i < length; i++) chars[i] = readChar();
        return new String(chars);
    }
    
    private void writeFixedLengthString(String s, int length) throws IOException {
        char[] chars = new char[length];  // fixed length char buffer
        // load String into char array
        s.getChars(0, Math.min(s.length(), length),  chars, 0);
        // fill in blank chars in rest of array
        for (int i = Math.min(s.length(), length); i < chars.length; i++) {
            chars[i] = ' ';
        }
        // write fixed length char array to file
        writeChars(new String(chars));
    }
    
}
