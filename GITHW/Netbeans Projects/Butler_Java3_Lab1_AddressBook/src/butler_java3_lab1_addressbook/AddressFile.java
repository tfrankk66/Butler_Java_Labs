/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butler_java3_lab1_addressbook;


import java.io.RandomAccessFile;
import java.io.IOException;
/**
 *
 * @author tfran
 */
public class AddressFile extends RandomAccessFile{
    public final static int NAME_SIZE = 2 * 32;
    public final static int STREET_SIZE = 2 * 32;
    public final static int CITY_SIZE = 2 * 20;
    public final static int STATE_SIZE = 2 * 2;
    public final static int ZIP_SIZE = 2 * 5;
    
    public final static int RECORD_SIZE = NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE; 
   
    public AddressFile() throws IOException
    {
        super("address.dat","rw");   
    }
    
     public Address readAddress(long position) throws IOException {
        Address rec = new Address();
        
        seek(position);  // locate and read record
        rec.setName(readFixedLengthString(32));
        rec.setStreet(readFixedLengthString(32));
        rec.setCity(readFixedLengthString(20));
        rec.setState(readFixedLengthString(2));
        rec.setZip(readFixedLengthString(5));
        
        return rec;
    }
     
    public void writeAddress(long position, Address aItem) {
        try {
            seek(position);  // set position in file
            // write recode - name (fixed length) quantity and price
            writeFixedLengthString(aItem.getName(), 32);
            writeFixedLengthString(aItem.getStreet(), 32);
            writeFixedLengthString(aItem.getCity(), 20);
            writeFixedLengthString(aItem.getState(), 2);
            writeFixedLengthString(aItem.getZip(), 5);
            
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
     
    public void addAddress(Address item) {
        try {
            // add new record to end of file
            writeAddress(length(), item);
        } catch (IOException ex) { }
    }
    
    public Address firstAddress() {
        // return first record in file
        Address item = null;
        try {
            if (length() > 0) item = readAddress(0);            
        } catch (IOException ex) {
            item = null;
        }
        return item;
    }
    
    public Address lastAddress() {
        Address item = null;
        try {
            if (length() > 0)  {
                item = readAddress(length() - RECORD_SIZE);   
            }
            else return null;
        } catch (IOException ex) {
            item = null;
        }
        return item;
    }
    
    public Address nextAddress() {
        Address item = null;
        try {
            long currentPosition = getFilePointer();
            if (currentPosition < length()) {
                item = readAddress(currentPosition);
            }
        } catch (IOException ex) {
            item = null;
        }
        return item;
    }
    
    public Address previousAddress() {
        Address item = null;
        try {
            long currentPosition = getFilePointer();
            if (currentPosition - RECORD_SIZE > 0)
            {
                item = readAddress(currentPosition - 2 * RECORD_SIZE);
            } else {
                item = readAddress(0);
            }
        } catch (IOException ex) {
            item = null;
        }
        return item;
    }
    
    public void updateAddress(Address item) {
        try {
            writeAddress(getFilePointer() - RECORD_SIZE, item);
        } catch (IOException ex) { }        
    }

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
