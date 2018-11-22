package butler_java2_finalproject;

import java.io.Serializable;


public class Theater implements Serializable{
    Film[] f;
    
    public Theater(String a){
        this.f = new Film[3];
        this.f[0] = new Film(a, "Matinee");
        this.f[1] = new Film(a, "Afternoon");
        this.f[2] = new Film(a, "Evening");   
    }
}
