/*
Author: Tyler Butler:
Date Last Modified: 11/27/18
Purpose of Program: This system is a desktop GUI (please use JavaFX) object oriented application to support the
                    ticket sales for an entertainment complex. This system will provide information regarding which
                    movie is playing in which theater and how many viewers are booked (tickets assigned) for any
                    given show. The entertainment complex has multiple theaters (viewing rooms) which
                    independently show films (movies). A viewer will book a seat in the appropriate theater that is
                    showing the film they wish to see at a particular show time.
*/

package butler_java2_finalproject;

import java.io.Serializable;
import javafx.scene.control.Button;

public class Film implements Serializable{
    //Initialization of field members
    private String filmTime;
    private String filmName;
    private int ss;
    private int sa;
    Boolean[] seatSel;
    Boolean[] seatAvv;
    //Transient to allow object to be serialized
    transient Button[] seatBt;

    public Film(String a, String b) {
        //Initialize Arrays
        this.seatSel = new Boolean[50];
        this.seatAvv = new Boolean[50];
        
        //Set seatSel Array Objects to false
        for(int i = 0; i < seatSel.length; i++){
            seatSel[i] = false;
        }
        //Set seatAvv Array Objects to true
        for(int i = 0; i < seatAvv.length; i++){
            seatAvv[i] = true;
        }
        
        //Assign field members
        this.filmName = a;
        this.filmTime = b;
        this.ss = 0;
        this.sa = 50;
    }

    //Accesor-Mutator Methods
    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    public String getFilmTime() {
        return filmTime;
    }
    public void setFilmTime(String filmTime) {
        this.filmTime = filmTime;
    }
    public int getSs() {
        return ss;
    }
    public void setSs(int ss) {
        this.ss = ss;
    }
    public int getSa() {
        return sa;
    }
    public void setSa(int sa) {
        this.sa = sa;
    }
    
    
}
