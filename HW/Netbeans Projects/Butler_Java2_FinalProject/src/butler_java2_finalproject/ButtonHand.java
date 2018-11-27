package butler_java2_finalproject;

import java.io.Serializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonHand implements Serializable, EventHandler<ActionEvent>
    {
        Button seat;
        transient Theater[] theaterArr;
        Button[] seatArr;
        int a;
        int b;
        int c;
        
        public ButtonHand(Theater[] tha, int c1, int c2, int c3){
            theaterArr = tha;
            a = c1;
            b = c2;
            c = c3;
        }
        
        
        @Override
        public void handle(ActionEvent event) {
            
                if(theaterArr[a].f[b].seatSel[c] == false){
                    theaterArr[a].f[b].seatBt[c] = (Button) event.getSource();
                    theaterArr[a].f[b].seatBt[c].setStyle("-fx-background-color: yellow");
                    theaterArr[a].f[b].seatSel[c] = true;
                }
                else
                {
                    theaterArr[a].f[b].seatBt[c] = (Button) event.getSource();
                    theaterArr[a].f[b].seatBt[c].setStyle(null);
                    theaterArr[a].f[b].seatSel[c] = false;
                }
            }
        
        
    }
