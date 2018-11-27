package butler_java2_finalproject;

import java.io.Serializable;

public class Film implements Serializable{
    private String filmTime;
    private String filmName;
    Boolean[] seatSel;
    Boolean[] seatAvv;

    public Film(String a, String b) {
        this.seatSel = new Boolean[50];
        this.seatAvv = new Boolean[50];
        
        for(int i = 0; i < seatSel.length; i++){
            seatSel[i] = false;
        }
        
        for(int i = 0; i < seatAvv.length; i++){
            seatAvv[i] = true;
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
