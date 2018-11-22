package butler_java2_finalproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import javafx.geometry.Pos;
import javafx.stage.WindowEvent;

/**
 *
 * @author tfran
 */
public class Butler_Java2_FinalProject extends Application implements Serializable {
    //Declare Theater Objects
    private Theater t1 = null;
    private Theater t2 = null;
    private Theater t3 = null;
    private Theater t4 = null;
    
   
    
    @Override
    public void start(Stage primaryStage) {
       //Initialize TextField Elements
       TextField tf1 = new TextField();
       TextField tf2 = new TextField();
       TextField tf3 = new TextField();
       TextField tf4 = new TextField();
       
       //Initialize Button Object
       Button assignB = new Button("Assign Films");
       
       //Intialize Pane Elements
       BorderPane bPane = new BorderPane();
       GridPane gPane1 = new GridPane();
       GridPane gPane2 = new GridPane();
       VBox vb1 = new VBox();
       VBox vb2 = new VBox();
       VBox vb3 = new VBox();
       VBox vb4 = new VBox();
       
       Scene scene = new Scene(bPane, 350, 200);
       
       //Check for Serialized Object Data, If Found Deserialize
       if(new File("Objects.txt").isFile()){
           try{
               FileInputStream fileIn = new FileInputStream("Objects.txt");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               t1 = (Theater) in.readObject();
               t2 = (Theater) in.readObject();
               t3 = (Theater) in.readObject();
               t4 = (Theater) in.readObject();
           }
           catch (IOException i) {
               System.out.println("Class Not Found");
           }
           catch (ClassNotFoundException e) {
               System.out.println("Class Not Found");
           }
           System.out.println("Serializing Data.");
           
           buildTheaterMainPanel(gPane2, t1, t2, t3, t4, vb1, vb2, vb3, vb4, bPane);
       }
       else
       {
          buildTheaterAssignPanel(gPane1, tf1, tf2, tf3, tf4);
          bPane.setTop(gPane1);
          bPane.setCenter(assignB);
       }
       
       //Stage Set-up
       primaryStage.setTitle("Movie Theater Booking System");
       primaryStage.setScene(scene);
       primaryStage.show();
       primaryStage.sizeToScene();
       
       
       //Event Handler to Serialize Object Data before application closes
       /*primaryStage.setOnCloseRequest((WindowEvent event) -> {
           try{
               FileOutputStream fileOut = new FileOutputStream("Objects.txt");
               ObjectOutputStream out = new ObjectOutputStream(fileOut);
               out.writeObject(t1);
               out.writeObject(t2);
               out.writeObject(t3);
               out.writeObject(t4);
           }
           catch(IOException i){
               System.out.println("Objects not found!");
           }
           
           System.out.print("Deserializing Data");
       });*/
       
       assignB.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               Theater t1 = new Theater(tf1.getText());
               Theater t2 = new Theater(tf1.getText());
               Theater t3 = new Theater(tf1.getText());
               Theater t4 = new Theater(tf1.getText());
               
               buildTheaterMainPanel(gPane2, t1, t2, t3, t4, vb1, vb2, vb3, vb4, bPane);
           }
       });
       
    }
    
    public static void buildTheaterAssignPanel(GridPane gPane1, TextField tf1, TextField tf2, TextField tf3, TextField tf4){
        //Building/Adding of actual JavaFX Elements 
        gPane1.add(new Label("Enter film name for Theater #1"), 0, 0);
        gPane1.add(tf1, 1, 0);
        gPane1.add(new Label("Enter film name for Theater #2"), 0, 1);
        gPane1.add(tf2, 1, 1);
        gPane1.add(new Label("Enter film name for Theater #3"), 0, 2);
        gPane1.add(tf3, 1, 2);
        gPane1.add(new Label("Enter film name for Theater #4"), 0, 3);
        gPane1.add(tf4, 1, 3);
        gPane1.setAlignment(Pos.CENTER);
    }
    
    public static void buildTheaterMainPanel(GridPane gPane2, Theater t1, Theater t2, Theater t3, Theater t4, VBox vb1, VBox vb2, VBox vb3, VBox vb4, BorderPane bPane){
        Button b1 = new Button("Current Status");
        Button b2 = new Button("Viewer Total");
        
        
        
        vb1.getChildren().addAll(b1, b2);
        
        
        bPane.setLeft(vb1);
        bPane.setTop(null);
        bPane.setCenter(null);
    }
}
