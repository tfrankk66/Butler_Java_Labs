package butler_java2_finalproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class PurchaseHand implements EventHandler<ActionEvent>
    {
        Theater[] theaterArr;
        Button[] seat;
        int a;
        int b;
        public PurchaseHand(Theater[] tha, Button[] s, int c1, int c2){
            theaterArr = tha;
            seat = s;
            a = c1;
            b = c2;
        }

        @Override
        public void handle(ActionEvent event) {
            for(int i = 0; i < seat.length; i++){
                if(theaterArr[a].f[b].seatSel[i] == true){
                   seat[i].setStyle("-fx-background-color: red");
                   theaterArr[a].f[b].seatAvv[i] = false;
                   seat[i].setDisable(true);
                }
            }
            
            for(int i = 0; i < seat.length; i++){
                theaterArr[a].f[b].seatSel[i] = false;
            }
        }
        
        
    }
