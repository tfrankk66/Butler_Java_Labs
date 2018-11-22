package butler_java2_finalproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.*;
import javafx.stage.WindowEvent;

/**
 *
 * @author tfran
 */
public class Butler_Java2_FinalProject extends Application implements Serializable {
    //Declare Theater Objects
    Theater t1 = null;
    Theater t2 = null;
    Theater t3 = null;
    Theater t4 = null;
    
    @Override
    public void start(Stage primaryStage) {
       BorderPane bPane = new BorderPane();
       Scene scene = new Scene(bPane);
       
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
       }
       
       
       
       primaryStage.setTitle("Movie Theater Booking System");
       primaryStage.setScene(scene);
       primaryStage.show();
       primaryStage.sizeToScene();
       
       
       
       
       //Event Handler to Serialize Object Data before application closes
       primaryStage.setOnCloseRequest((WindowEvent event) -> {
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
       });
       
    }
}
