package butler_java2_finalproject;

import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable{
    private String filmTime;
    private String filmName;
    Boolean[] seatArr;

    public Film(String a, String b) {
        this.seatArr = new Boolean[50];
        for(int i = 0; i < seatArr.length; i++){
            seatArr[i] = false;
        }
        this.filmName = a;
        this.filmTime = b;
    }

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
    
    
}
