
package butler_java3_lab6_internationalization;

import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.text.*;


/**
 *
 * @author tfran
 */
public class Butler_Java3_Lab6_Internationalization extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Initialize CurrencyConverter Object
        CurrencyConv cc1 = new CurrencyConv();
        
        //Intialization Block for JavaFX Elements
        GridPane gp1 = new GridPane();
        HBox hb1 = new HBox();
        VBox vb1 = new VBox();
        TextField tf1 = new TextField();
        TextField[] tfArr = new TextField[6];
        for(int i = 0; i < tfArr.length; i++){
            tfArr[i] = new TextField();
            tfArr[i].setAlignment(Pos.CENTER_RIGHT);
            tfArr[i].setMinWidth(100);   
        }
        Button conv = new Button();
        conv.setText("Convert");
        
        //Settings Block for JavaFX Elements
        vb1.setSpacing(7);
        hb1.setSpacing(5);
        tfArr[1].setEditable(false);
        tfArr[3].setEditable(false);
        tfArr[5].setEditable(false);
        tf1.setAlignment(Pos.CENTER_RIGHT);
        tf1.setMinWidth(250);
        
        //Adding JavaFX Elements into GridPane Object
        gp1.add(new Label("Exchange Rate"), 1, 0);
        gp1.add(new Label("Converted Amount"), 2, 0);
        gp1.add(new Label("Canadian Dollars"), 0, 1);
        gp1.add(tfArr[0], 1, 1);
        gp1.add(tfArr[1], 2, 1);
        gp1.add(new Label("Euro"), 0, 2);
        gp1.add(tfArr[2], 1, 2);
        gp1.add(tfArr[3], 2, 2);
        gp1.add(new Label("British Pounds"), 0, 3);
        gp1.add(tfArr[4], 1, 3);
        gp1.add(tfArr[5], 2, 3);

        //HBox & VBox addAll methods called
        hb1.getChildren().addAll(new Label("US Dollars"), tf1, conv);
        vb1.getChildren().addAll(new Label("Enter Dollar Amount"), hb1, new Label("Display Exchange"), gp1);
        
        conv.setOnAction((ActionEvent e) -> {
            //Retrive text from textfields and convert to doubles
            double da = Double.parseDouble(tf1.getText());
            double er1 = Double.parseDouble(tfArr[0].getText());
            double er2 = Double.parseDouble(tfArr[2].getText());
            double er3 = Double.parseDouble(tfArr[4].getText());
            
            //Set Converted Amount Text by Calling Curreny Conversion Methods
            tfArr[1].setText(cc1.convertCD(da, er1));
            tfArr[3].setText(cc1.convertE(da, er2));
            tfArr[5].setText(cc1.convertBP(da, er3));
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(vb1);
        
        Scene scene = new Scene(root, 400, 200);
        
        primaryStage.setTitle("Internationalization Lab");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
