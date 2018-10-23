package butler_java2_lab10_colorchangingradiobuttons;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author tfran
 */
public class Butler_Java2_Lab10_ColorChangingRadioButtons extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        HBox h = new HBox(30);
        h.setPadding(new Insets(10, 10, 10, 10));
        h.setAlignment(Pos.CENTER);
        
        RadioButton rb1 = new RadioButton("White");
        RadioButton rb2 = new RadioButton("Yellow");
        
        EventHandler<ActionEvent> handler = (ActionEvent event) -> {
            if(rb1.isSelected()){
                h.setStyle("-fx-background-color: white");
            }
            else if(rb2.isSelected()){
                h.setStyle("-fx-background-color: yellow");
            }
        };
        rb1.setOnAction(handler);
        rb2.setOnAction(handler);
        
        h.getChildren().addAll(rb1, rb2);
        
        Scene scene = new Scene(h, 400, 50);
        
        primaryStage.setTitle("Color Changing Radio Buttons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    
}
