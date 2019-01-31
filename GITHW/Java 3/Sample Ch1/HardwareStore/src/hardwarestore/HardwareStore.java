/*
 * HardwareStore - represents the hardware store
 */
package hardwarestore;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author David Swaim
 */
public class HardwareStore extends Application {
    
    HardwareFile hFile;         // random access hardware file
    
    // Text fields
    private TextField tfName = new TextField();
    private TextField tfQuantity = new TextField();
    private TextField tfPrice = new TextField();
    // Buttons
    private Button btAdd = new Button("Add");
    private Button btFirst = new Button("First");
    private Button btNext = new Button("Next");
    private Button btPrevious = new Button("Previous");
    private Button btLast = new Button("Last");
    private Button btUpdate = new Button("Update");
    
    public HardwareStore()
    {
        // open or create hardware file when application instantiates
        try {
            hFile = new HardwareFile();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        GridPane p1 = new GridPane();
        p1.setAlignment(Pos.CENTER);
        p1.setHgap(5);
        p1.setVgap(5);
        p1.add(new Label("Name"), 0, 0);
        p1.add(new Label("Quantity on Hand"), 0, 1);
        p1.add(new Label("Unit Price"), 0, 2);
        p1.add(tfName, 1, 0);
        p1.add(tfQuantity, 1, 1);
        p1.add(tfPrice, 1, 2);
        // Add buttons to a pane
        HBox p3 = new HBox(5);
        p3.getChildren().addAll(btAdd, btFirst, btNext, btPrevious,
                btLast, btUpdate);
        p3.setAlignment(Pos.CENTER);

        // Add p1 and p3 to a border pane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(p1);
        borderPane.setBottom(p3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 350, 120);
        primaryStage.setTitle("Hardware Inventory"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        
        // Display the first record if exists
        Hardware hw = hFile.firstHardware();
        if(hw != null) setDisplay(hw);
        
/********* Action Events *************/
        
        btAdd.setOnAction(e -> {
            hFile.addHardware(getDisplay());
        });
        btFirst.setOnAction(e -> {
            Hardware item = hFile.firstHardware();
            if(item != null) setDisplay(item);
        });
        btNext.setOnAction(e -> {
            Hardware item = hFile.nextHardware();
            if (item != null) setDisplay(item);
        });
        btPrevious.setOnAction(e -> {
            Hardware item = hFile.previousHardware();
            if (item != null) setDisplay(item);
        });
        btLast.setOnAction(e -> {
            Hardware item = hFile.lastHardware();
            if (item != null) setDisplay(item);
        });
        btUpdate.setOnAction(e -> {
            Hardware item = getDisplay();
            hFile.updateHardware(item);
        });        
    }

    // utility method to put data into display
    private void setDisplay(Hardware hw) {
        tfName.setText(hw.getName());
        tfQuantity.setText(String.format("%d", hw.getQuantity()));
        tfPrice.setText(String.format("%.2f", hw.getPrice()));
    }
    
    // utility method to get data from display
    private Hardware getDisplay() {
        Hardware hw = new Hardware();
        hw.setName(tfName.getText());
        int quantity = Integer.parseInt(tfQuantity.getText());
        hw.setQuantity(quantity);
        double price = Double.parseDouble(tfPrice.getText());
        hw.setPrice(price);
        return hw;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
