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
import javafx.scene.control.Label;

public class PurchaseHand implements Serializable, EventHandler<ActionEvent>
    {
        //Field Members
        transient Theater[] theaterArr;
        int a;
        int b;
        Label l1;
        Label l2;

        public PurchaseHand(Theater[] tha, int c1, int c2, Label la, Label lb){
            //Assigning field members
            theaterArr = tha;
            a = c1;
            b = c2;
            l1 = la;
            l2 = lb;   
        }

        @Override
        public void handle(ActionEvent event) {
            //For-Loop to check if selected seats are true
            for(int i = 0; i < theaterArr[a].f[b].seatBt.length; i++){
                //If True, Set color to red, disable and set seat availability to false
                if(theaterArr[a].f[b].seatSel[i] == true){
                   theaterArr[a].f[b].seatBt[i].setStyle("-fx-background-color: red");
                   theaterArr[a].f[b].seatAvv[i] = false;
                   theaterArr[a].f[b].seatBt[i].setDisable(true);
                }
            }
            
            //Set all seats to un-selected
            for(int i = 0; i < theaterArr[a].f[b].seatBt.length; i++){
                theaterArr[a].f[b].seatSel[i] = false;
            }
            
            //Check to see if seats sold is not 50
            if(theaterArr[a].f[b].getSs() != 50){
                //Zero out seats sold
                theaterArr[a].f[b].setSs(0);
                //For-Loop to get seats sold number
                for(int i = 0; i < theaterArr[a].f[b].seatAvv.length; i++){
                    //If False Iterate the sold seats value
                    if(theaterArr[a].f[b].seatAvv[i] == false){
                        theaterArr[a].f[b].setSs((theaterArr[a].f[b].getSs() + 1));
                    }
                }
                
                l1.setText("Seats Sold: " + theaterArr[a].f[b].getSs());
            }
            else
            {
                //If seats sold is 50 set it to 50 and display seats sold
                theaterArr[a].f[b].setSs(50);
                l1.setText("Seats Sold: " + theaterArr[a].f[b].getSs());
            }
            
            //Check to see if seats available is not 0
            if(theaterArr[a].f[b].getSa() != 0){
                theaterArr[a].f[b].setSa(50);
                //Calculation: Seats Available - Seats Sold
                theaterArr[a].f[b].setSa((theaterArr[a].f[b].getSa() - theaterArr[a].f[b].getSs()));
                l2.setText("Seats Available: " + theaterArr[a].f[b].getSa());
            }
        }
        
        
    }
