package butler_java2_finalproject;

import java.io.Serializable;


public class Theater implements Serializable{
    final Film[] f;
    
    
    private String name;
    public Theater(String a){
        this.f = new Film[3];
        this.f[0] = new Film(a, "10:00 AM");
        this.f[1] = new Film(a, "3:00 PM");
        this.f[2] = new Film(a, "8:00 PM");   
        name = "String";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
