package butler_java2_lab10_checkerboard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author tfran
 */
public class Butler_Java2_Lab10_Checkerboard extends Application {
    
    private int n;
    
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Please enter in the value for the board: ");
        TextField t = new TextField();
        HBox hPane = new HBox(20);
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(hPane);
        
        t.setOnAction((ActionEvent event) -> {
            n = Integer.parseInt(t.getText());
            TextField [][] TextField = new TextField[n][n];
            
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    TextField[i][j] = new TextField("" + i + "," + j);
                    gridPane.add(TextField[i][j], i, j);
                }
            }
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    TextField[i][j].setEditable(false);
                }
            }
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if( (i % 2) == (j % 2)){
                        TextField[i][j].setStyle("-fx-background-color: red");
                    }
                    else{
                        TextField[i][j].setStyle("-fx-background-color: black");
                    }
                }
            }
           primaryStage.sizeToScene();
        });
        
        hPane.getChildren().addAll(label, t, gridPane);
        primaryStage.setTitle("Checker Board!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
