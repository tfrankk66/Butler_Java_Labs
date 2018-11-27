package butler_java2_finalproject;

import java.io.Serializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PurchaseHand implements Serializable, EventHandler<ActionEvent>
    {
        transient Theater[] theaterArr;
        int a;
        int b;
        public PurchaseHand(Theater[] tha, int c1, int c2){
            theaterArr = tha;
            a = c1;
            b = c2;
        }

        @Override
        public void handle(ActionEvent event) {
            for(int i = 0; i < theaterArr[a].f[b].seatBt.length; i++){
                if(theaterArr[a].f[b].seatSel[i] == true){
                   theaterArr[a].f[b].seatBt[i].setStyle("-fx-background-color: red");
                   theaterArr[a].f[b].seatAvv[i] = false;
                   theaterArr[a].f[b].seatBt[i].setDisable(true);
                }
            }
            
            for(int i = 0; i < theaterArr[a].f[b].seatBt.length; i++){
                theaterArr[a].f[b].seatSel[i] = false;
            }
        }
        
        
    }
