package butler_java2_finalproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonHand implements EventHandler<ActionEvent>
    {
        Button seat;
        Theater[] theaterArr;
        Button[] seatArr;
        int a;
        int b;
        int c;
        
        public ButtonHand(Theater[] tha, Button[] s, int c1, int c2, int c3){
            theaterArr = tha;
            seatArr = s;
            a = c1;
            b = c2;
            c = c3;
        }
        
        
        @Override
        public void handle(ActionEvent event) {
            
                if(theaterArr[a].f[b].seatSel[c] == false){
                    seat = (Button) event.getSource();
                    seat.setStyle("-fx-background-color: yellow");
                    theaterArr[a].f[b].seatSel[c] = true;
                }
                else
                {
                    seat = (Button) event.getSource();
                    seat.setStyle(null);
                    theaterArr[a].f[b].seatSel[c] = false;
                }
            }
        
        
    }
