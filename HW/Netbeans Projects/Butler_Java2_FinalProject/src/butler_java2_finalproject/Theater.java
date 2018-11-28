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

public class Theater implements Serializable{
    //Array of Film Objects
    Film[] f;
    
    
    private String name;
    public Theater(String a){
        //Initialize Array of Film Objects
        this.f = new Film[3];
        
        //Assign each film a time
        this.f[0] = new Film(a, "10:00 AM");
        this.f[1] = new Film(a, "3:00 PM");
        this.f[2] = new Film(a, "8:00 PM");   
        name = "String";
    }

    //Accesor-Mutator Methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
