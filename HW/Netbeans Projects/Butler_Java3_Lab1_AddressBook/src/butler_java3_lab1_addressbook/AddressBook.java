/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butler_java3_lab1_addressbook;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author tfran
 */
public class AddressBook extends Application {
    //RA File
    AddressFile aFile;
    
    //TextField Elements
    private TextField tName = new TextField();
    private TextField tStreet = new TextField();
    private TextField tCity = new TextField();
    private TextField tState = new TextField();
    private TextField tZip = new TextField();
    
    //Button Elements
    private Button btAdd = new Button("Add");
    private Button btFirst = new Button("First");
    private Button btNext = new Button("Next");
    private Button btPrevious = new Button("Previous");
    private Button btLast = new Button("Last");
    private Button btUpdate = new Button("Update");
    
    public AddressBook(){
        try {
            aFile = new AddressFile();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        //Set Textfield Widths;
        tName.setPrefWidth(250);
        tStreet.setPrefWidth(250);
        tCity.setMaxWidth(80);
        tState.setMaxWidth(35);
        tZip.setMaxWidth(80);
        
        //Create GridPane Element
        GridPane gp1 = new GridPane();
        gp1.setAlignment(Pos.CENTER);
        gp1.setHgap(5);
        gp1.setVgap(5);
        gp1.add(new Label("Name"), 0, 0);
        gp1.add(new Label("Street"), 0, 1);
        gp1.add(tName, 1, 0);
        gp1.add(tStreet, 1, 1);
        
        //Create 1st HBox Element to hold Labels & TextFields
        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(new Label("City"), tCity, new Label("State"), tState, new Label("Zip"), tZip);
        
        //Create 2nd HBox Element to hold Buttons
        HBox hb2 = new HBox();
        hb2.setSpacing(5);
        hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(btAdd, btFirst, btNext, btPrevious, btLast, btUpdate);  
        
        //Create Vbox to hold all the elements
        VBox vb1 = new VBox();
        vb1.setSpacing(5);
        vb1.setAlignment(Pos.CENTER);
        vb1.getChildren().addAll(gp1, hb1, hb2);
        
        
        BorderPane bp1 = new BorderPane();
        bp1.setCenter(vb1);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(bp1, 350, 130);
        primaryStage.setTitle("Address Book"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        Address ad = aFile.firstAddress();
        if(ad != null) setDisplay(ad);
        
        /********* Action Events *************/
        btAdd.setOnAction(e -> {
            aFile.addAddress(getDisplay());
        });
        
        btFirst.setOnAction(e -> {
            Address item = aFile.firstAddress();
            if(item != null) setDisplay(item);
        });
        btNext.setOnAction(e -> {
            Address item = aFile.nextAddress();
            if (item != null) setDisplay(item);
        });
        btPrevious.setOnAction(e -> {
            Address item = aFile.previousAddress();
            if (item != null) setDisplay(item);
        });
        btLast.setOnAction(e -> {
            Address item = aFile.lastAddress();
            if (item != null) setDisplay(item);
        });
        btUpdate.setOnAction(e -> {
            Address item = getDisplay();
            aFile.updateAddress(item);
        });        
    }
    
    private void setDisplay(Address a) {
        tName.setText(a.getName());
        tStreet.setText(a.getStreet());
        tCity.setText(a.getCity());
        tState.setText(a.getState());
        tZip.setText(a.getZip());
    }
    
    private Address getDisplay() {
        Address a = new Address();
        a.setName(tName.getText());
        a.setStreet(tStreet.getText());
        a.setCity(tCity.getText());
        a.setState(tState.getText());
        a.setZip(tZip.getText());
        return a;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
