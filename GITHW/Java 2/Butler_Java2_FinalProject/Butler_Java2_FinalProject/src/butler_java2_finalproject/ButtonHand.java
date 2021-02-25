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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonHand implements Serializable, EventHandler<ActionEvent>
    {
        //Field Members
        Button seat;
        Theater[] theaterArr;
        Button[] seatArr;
        int a;
        int b;
        int c;
        
        public ButtonHand(Theater[] tha, int c1, int c2, int c3){
            //Initialize Field Members
            theaterArr = tha;
            a = c1;
            b = c2;
            c = c3;
        }
        
        
        @Override
        public void handle(ActionEvent event) {
            
                //Check for if the seat selected is false
                if(theaterArr[a].f[b].seatSel[c] == false){
                    theaterArr[a].f[b].seatBt[c] = (Button) event.getSource();
                    //Set color to yellow to represent selection
                    theaterArr[a].f[b].seatBt[c].setStyle("-fx-background-color: yellow");
                    //Set seat selection to true
                    theaterArr[a].f[b].seatSel[c] = true;
                }
                else
                {
                    //Set Selected seats back to unselected
                    theaterArr[a].f[b].seatBt[c] = (Button) event.getSource();
                    theaterArr[a].f[b].seatBt[c].setStyle(null);
                    theaterArr[a].f[b].seatSel[c] = false;
                }
            }
        
        
    }
