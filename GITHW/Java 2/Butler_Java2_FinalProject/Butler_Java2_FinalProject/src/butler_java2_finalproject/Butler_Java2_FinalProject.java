/*
Author: Tyler Butler:
Date Last Modified: 11/27/18
Purpose of Program: This system is a desktop GUI (please use JavaFX) object oriented application to support the
                    ticket sales for an entertainment complex. This system will provide information regarding which
                    movie is playing in which theater and how many viewers are booked (tickets assigned) for any
                    given show. The entertainment complex has multiple theaters (viewing rooms) which
                    independently show films (movies). A viewer will book a seat in the appropriate theater that is
                    showing the film they wish to see at a particular show time.
*/

package butler_java2_finalproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.WindowEvent;

/**
 *
 * @author tfran
 */
public class Butler_Java2_FinalProject extends Application implements Serializable {
    
    ButtonHand bh;
    //PurchaseHand ph = new PurchaseHand();
    
    @Override
    public void start(Stage primaryStage) {
       //Initialize Theater Array of Objects
       Theater[] theaterArr = new Theater[4];
       
       for(int i = 0; i < theaterArr.length; i++){
           theaterArr[i] = null;
       }

       //Initialize TextField Elements
       TextField tf1 = new TextField();
       TextField tf2 = new TextField();
       TextField tf3 = new TextField();
       TextField tf4 = new TextField();
       
       //Intialize Pane Elements
       BorderPane bPane = new BorderPane();
       bPane.setPadding(new Insets(5, 5, 5, 5));
       Scene scene = new Scene(bPane, 350, 200);
       
       //Stage Set-up
       primaryStage.setTitle("Movie Theater Booking System");
       primaryStage.setScene(scene);
       primaryStage.show();
       primaryStage.sizeToScene();
       
       //Check for Serialized Object Data, If Found Deserialize
       if(new File("Objects.txt").isFile()){
           try{
               //Try to open file and Deserialize Object Data
               FileInputStream fileIn = new FileInputStream("Objects.txt");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               theaterArr[0] = (Theater) in.readObject();
               theaterArr[1] = (Theater) in.readObject();
               theaterArr[2] = (Theater) in.readObject();
               theaterArr[3] = (Theater) in.readObject();
           }
           catch (IOException | ClassNotFoundException i) {
               System.out.println("Class Not Found");
           }
           
           System.out.println("Deserializing Data.");
           //Call to Main Theater Screen
           buildTheaterMainPanel(theaterArr, bPane, primaryStage);
       }
       else
       {
          //Call to Main Theater Screen
          buildTheaterAssignPanel(tf1, tf2, tf3, tf4, bPane, primaryStage, theaterArr);
       }
       
       
       
       //Event Handler to Serialize Object Data before application closes
       primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
           @Override
           public void handle(WindowEvent event) {
               try{
                   //Try to open file and Serialize Object Data
                   FileOutputStream fileOut = new FileOutputStream("Objects.txt");
                   ObjectOutputStream out = new ObjectOutputStream(fileOut);
                   out.writeObject(theaterArr[0]);
                   out.writeObject(theaterArr[1]);
                   out.writeObject(theaterArr[2]);
                   out.writeObject(theaterArr[3]);
               }
               catch(IOException i){
                   System.out.println("Objects not found!");
               }
               
               System.out.print("Serializing Data");
           }
       });
       
       
       
    }
    
    public static void buildTheaterAssignPanel(TextField tf1, TextField tf2, TextField tf3, TextField tf4, BorderPane bPane, Stage primaryStage, Theater[] theaterArr){
        //Initialization of content objects
        GridPane gPane1 = new GridPane();
        Button assignB = new Button("Assign Films");
        
        //EventListener for Assign Button
        assignB.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               theaterArr[0] = new Theater(tf1.getText());
               theaterArr[1] = new Theater(tf2.getText());
               theaterArr[2] = new Theater(tf3.getText());
               theaterArr[3] = new Theater(tf4.getText());
               
               //Call to Main Theater Screen
               buildTheaterMainPanel(theaterArr, bPane, primaryStage);
               primaryStage.sizeToScene();
           }
       });
        
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
        
        //Set BorderPane Elements
        bPane.setTop(gPane1);
        bPane.setCenter(assignB);
    }
    
    public static void buildTheaterMainPanel(Theater[] theaterArr, BorderPane bPane, Stage primaryStage){
        //Initialization of Content Objects
        GridPane gPane2 = new GridPane();
        int count1;
        int count2;
        ImageView[] imv = new ImageView[4];
        Label[] theaterLabel = new Label[4];
        Label[] filmLabel = new Label[4];
        VBox[] vba = new VBox[5];
        Button[][] timeButton = new Button[4][3];
        
        //Assignment For Loops
        for(int i = 0; i < imv.length; i++){
            imv[i] = new ImageView();
            imv[i].setImage(new Image("images/TheaterPicture.jpg"));
            imv[i].setFitHeight(200);
            imv[i].setFitWidth(125);
        }
        for(int i = 0; i < theaterLabel.length; i++){
            theaterLabel[i] = new Label("Theater " + (i + 1)); 
        }
        for(int i = 0; i < vba.length; i++){
            vba[i] = new VBox();
            vba[i].setAlignment(Pos.CENTER);
            vba[i].setSpacing(3);
        }
        for(int i = 0; i < filmLabel.length; i++){
            filmLabel[i] = new Label(theaterArr[i].f[0].getFilmName());
        }
       
        //Large for Loop to handle showing Film Time Buttons
        for(int i = 0; i < 4; i++){
            for(int c = 0; c < 3; c++){
                timeButton[i][c] = new Button(theaterArr[0].f[c].getFilmTime());
                timeButton[i][c].setPrefSize(100, 20);
                
                //Large Double-Switch Statement to handle adding Event Listeners to corresponding Film Time Buttons
                switch(i){
                    case 0:
                        switch(c){
                            case 0:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 0, 0);
                                });
                                break;
                            case 1:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 0, 1);
                                });
                                break;
                            case 2:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 0, 2);
                                });
                                break;
                        }
                        break;
                    case 1:
                        switch(c){
                            case 0:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 1, 0);
                                });
                                break;
                            case 1:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 1, 1);
                                });
                                break;
                            case 2:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 1, 2);
                                });
                                break;
                        }
                        break;
                    case 2:
                        switch(c){
                            case 0:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 2, 0);
                                });
                                break;
                            case 1:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 2, 1);
                                });
                                break;
                            case 2:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 2, 2);
                                });
                                break;
                        }
                        break;
                    case 3:
                        switch(c){
                            case 0:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 3, 0);
                                });
                                break;
                            case 1:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 3, 1);
                                });
                                break;
                            case 2:
                                timeButton[i][c].setOnAction((ActionEvent event) -> {
                                    buildFilmRoomPanel(theaterArr, bPane, primaryStage, 3, 2);
                                });
                                break;
                        }
                        break;
                        
                }
            }
        }
        
        //Current Status Button w/ Event Listener
        Button b1 = new Button("Current Status");
        b1.setOnAction((ActionEvent event) -> {
                buildCStatusPanel(theaterArr, bPane, primaryStage);
            });
        
        //Current Viewer Total Button w/ Event Listener
        Button b2 = new Button("Viewer Total");
        b2.setOnAction((ActionEvent event) -> {
                buildViewerTotalPanel(theaterArr, bPane, primaryStage);
            });
        
        //Setting Button Size
        b1.setPrefSize(100, 20);
        b2.setPrefSize(100, 20);

        //Add All Content Panes to Corresponding VBoxes
        vba[0].getChildren().addAll(b1, b2);
        vba[1].getChildren().addAll(theaterLabel[0], imv[0], filmLabel[0], timeButton[0][0], timeButton[0][1], timeButton[0][2]);
        vba[2].getChildren().addAll(theaterLabel[1], imv[1], filmLabel[1], timeButton[1][0], timeButton[1][1], timeButton[1][2]);
        vba[3].getChildren().addAll(theaterLabel[2], imv[2], filmLabel[2], timeButton[2][0], timeButton[2][1], timeButton[2][2]);
        vba[4].getChildren().addAll(theaterLabel[3], imv[3], filmLabel[3], timeButton[3][0], timeButton[3][1], timeButton[3][2]);
        
        //Add All VBoxes to corresponding GridPanes
        gPane2.add(vba[1], 0, 0);
        gPane2.add(vba[2], 1, 0);
        gPane2.add(vba[3], 2, 0);
        gPane2.add(vba[4], 3, 0);
        gPane2.setHgap(6);
        gPane2.setPadding(new Insets(0, 0, 0, 5));
        
        //Set GPanes to corresponding BorderPane Areas
        bPane.setLeft(vba[0]);
        bPane.setTop(null);
        bPane.setCenter(gPane2);
        bPane.setBottom(null);

        //Adjust Stage Size to allow all items to show
        primaryStage.setMinWidth(650);
        primaryStage.setMinHeight(375);
        
    }
    
    
    public static void buildFilmRoomPanel(Theater[] theaterArr, BorderPane bPane, Stage primaryStage, int a, int b){
        //Pane Assignments
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        VBox vb3 = new VBox();
        vb1.setAlignment(Pos.CENTER);
        vb2.setAlignment(Pos.CENTER);
        GridPane gp1 = new GridPane();
        
        //Previous Page Button Initialization
        Button back = new Button("Previous Page");
        back.setOnAction((ActionEvent event) -> {
                buildTheaterMainPanel(theaterArr, bPane, primaryStage);
             });

        //Key Code Button Initialization
        Button bgrey = new Button();
        Button byellow = new Button();
        Button bred = new Button();
        
        //Change Key Code Button Settings
        bgrey.setMinSize(30, 25);
        byellow.setMinSize(30, 25);
        bred.setMinSize(30, 25);
        bgrey.setDisable(true);
        byellow.setStyle("-fx-background-color: yellow");
        bred.setStyle("-fx-background-color: red");
        
        //Label Intialization
        Label l1 = new Label("= Available");
        Label l2 = new Label("= Selected");
        Label l3 = new Label("= Unavailable");
        Label l4 = new Label("Theater " + (a + 1));
        Label l5 = new Label(theaterArr[a].f[b].getFilmName());
        Label l6 = new Label(theaterArr[a].f[b].getFilmTime());
        Label l7 = new Label("Seats Sold: " + theaterArr[a].f[b].getSs());
        Label l8 = new Label("Seats Available: " + theaterArr[a].f[b].getSa());
        
        //Purchase Button Initialization
        Button purchase = new Button("Purchase Tickets");
        purchase.setOnAction(new PurchaseHand(theaterArr, a, b, l7, l8));
        
        //Add Content to GridPane
        gp1.add(bgrey, 0, 0);
        gp1.add(l1, 1, 0);
        gp1.add(byellow, 0, 1);
        gp1.add(l2, 1, 1);
        gp1.add(bred, 0, 2);
        gp1.add(l3, 1, 2);
        gp1.setHgap(3);
        gp1.setAlignment(Pos.CENTER);

        //Tile Pane Intialization
        TilePane tp1 = new TilePane();
        tp1.setMaxSize(300, 300);
        tp1.setAlignment(Pos.CENTER);
        tp1.setHgap(3);
        tp1.setVgap(3);
        
        //Initialization of seat buttons
        theaterArr[a].f[b].seatBt = new Button[50];
        for(int i = 0; i < theaterArr[a].f[b].seatBt.length; i++){
            theaterArr[a].f[b].seatBt[i] = new Button("" + (i + 1));
            theaterArr[a].f[b].seatBt[i].setMaxSize(50, 25);
            //Assignment of EventHandler
            theaterArr[a].f[b].seatBt[i].setOnAction(new ButtonHand(theaterArr, a, b, i));
        }

            
        //Check for seat availability  
        for(int i = 0; i < theaterArr[a].f[b].seatSel.length; i++){ 
            //If seat is unavailable disable it and set background to red
            if(theaterArr[a].f[b].seatAvv[i] == false){
                theaterArr[a].f[b].seatBt[i].setDisable(true);
                theaterArr[a].f[b].seatBt[i].setStyle("-fx-background-color: red");
            }
            
            //Assign seat button to TilePane
            tp1.getChildren().add(theaterArr[a].f[b].seatBt[i]);
        } 
        
        //Adjust VBox Spacing
        vb1.setSpacing(20);
        vb2.setSpacing(10);
        vb3.setSpacing(10);
        
        //Add Content Panes to VBoxes
        vb2.getChildren().addAll(l4, l5, l6);
        vb1.getChildren().addAll(vb2, tp1, purchase, back);
        vb3.getChildren().addAll(l7, l8);
           
        //Assign VBoxes to corresponding BorderPane Areas
        bPane.setLeft(gp1);
        bPane.setCenter(vb1);
        bPane.setTop(vb3);
        
        //Adjust Stage size
        primaryStage.setMinWidth(650);
        primaryStage.setMinHeight(440);
    }
    
    public static void buildCStatusPanel(Theater[] theaterArr, BorderPane bPane, Stage primaryStage){
        //VBox Initializations
        VBox v1 = new VBox();
        v1.setSpacing(20);
        v1.setAlignment(Pos.CENTER);
        VBox v2 = new VBox();
        v2.setSpacing(-10);
        v2.setAlignment(Pos.CENTER);
        
        //GridPane Initializations
        GridPane gp = new GridPane();
        gp.setHgap(90);
        gp.setVgap(15);
        gp.setAlignment(Pos.CENTER);
        GridPane gp2 = new GridPane();
        gp2.setHgap(25);
        gp2.setVgap(5);
        gp2.setAlignment(Pos.CENTER);
        GridPane gp3 = new GridPane();
        gp3.setHgap(25);
        gp3.setVgap(5);
        gp3.setAlignment(Pos.CENTER);
        GridPane gp4 = new GridPane();
        gp4.setHgap(25);
        gp4.setVgap(5);
        gp4.setAlignment(Pos.CENTER);
        
        //Title Label Initialization
        Label title = new Label("Current Status of all Theaters");
        
        //Initialization of Array of Labels
        Label[] tl = new Label[4];
        Label[] t2 = new Label[4];
        Label[] t3 = new Label[12];
        Label[] t4 = new Label[12];
        Label[] t5 = new Label[12];
        
        //For-Loops For Assigning Label Arrays
        for(int i = 0; i < tl.length; i++){
            tl[i] = new Label("Theater " + (i + 1));
            gp.add(tl[i], i, 0);
        }
        for(int i = 0; i < t2.length; i++){
            tl[i] = new Label(theaterArr[i].f[0].getFilmName());
            gp.add(tl[i], i, 1);
        }
        for(int i = 0; i < 12; i++){
                t3[i] = new Label();
        }
        for(int i = 0; i < 12; i++){
                t4[i] = new Label();
        }
        for(int i = 0; i < 12; i++){
                t5[i] = new Label();
        }
        
        //Large Assignment chunk of Film Time Labels
        t3[0] = new Label(theaterArr[0].f[0].getFilmTime());
        t3[1] = new Label(theaterArr[0].f[1].getFilmTime());
        t3[2] = new Label(theaterArr[0].f[2].getFilmTime());
        t3[3] = new Label(theaterArr[1].f[0].getFilmTime());
        t3[4] = new Label(theaterArr[0].f[1].getFilmTime());
        t3[5] = new Label(theaterArr[0].f[2].getFilmTime());
        t3[6] = new Label(theaterArr[2].f[0].getFilmTime());
        t3[7] = new Label(theaterArr[0].f[1].getFilmTime());
        t3[8] = new Label(theaterArr[0].f[2].getFilmTime());
        t3[9] = new Label(theaterArr[2].f[0].getFilmTime());
        t3[10] = new Label(theaterArr[0].f[1].getFilmTime());
        t3[11] = new Label(theaterArr[0].f[2].getFilmTime());
        
        //Large Assignment chunk of Tickets Sold Labels
        t4[0] = new Label("Tickets Sold: " + theaterArr[0].f[0].getSs());
        t4[1] = new Label("Tickets Sold: " + theaterArr[0].f[1].getSs());
        t4[2] = new Label("Tickets Sold: " + theaterArr[0].f[2].getSs());
        t4[3] = new Label("Tickets Sold: " + theaterArr[1].f[0].getSs());
        t4[4] = new Label("Tickets Sold: " + theaterArr[1].f[1].getSs());
        t4[5] = new Label("Tickets Sold: " + theaterArr[1].f[2].getSs());
        t4[6] = new Label("Tickets Sold: " + theaterArr[2].f[0].getSs());
        t4[7] = new Label("Tickets Sold: " + theaterArr[2].f[1].getSs());
        t4[8] = new Label("Tickets Sold: " + theaterArr[2].f[2].getSs());
        t4[9] = new Label("Tickets Sold: " + theaterArr[3].f[0].getSs());
        t4[10] = new Label("Tickets Sold: " + theaterArr[3].f[1].getSs());
        t4[11] = new Label("Tickets Sold: " + theaterArr[3].f[2].getSs());
        
        //Large Assignment chunk of Seats Available Labels
        t5[0] = new Label("Seats Available: " + theaterArr[0].f[0].getSa());
        t5[1] = new Label("Seats Available: " + theaterArr[0].f[1].getSa());
        t5[2] = new Label("Seats Available: " + theaterArr[0].f[2].getSa());
        t5[3] = new Label("Seats Available: " + theaterArr[1].f[0].getSa());
        t5[4] = new Label("Seats Available: " + theaterArr[1].f[1].getSa());
        t5[5] = new Label("Seats Available: " + theaterArr[1].f[2].getSa());
        t5[6] = new Label("Seats Available: " + theaterArr[2].f[0].getSa());
        t5[7] = new Label("Seats Available: " + theaterArr[2].f[1].getSa());
        t5[8] = new Label("Seats Available: " + theaterArr[2].f[2].getSa());
        t5[9] = new Label("Seats Available: " + theaterArr[3].f[0].getSa());
        t5[10] = new Label("Seats Available: " + theaterArr[3].f[1].getSa());
        t5[11] = new Label("Seats Available: " + theaterArr[3].f[2].getSa());
        
        //Large Chunk of Add statements to corresponding GridPane Objects
        gp2.add(t3[0], 0, 1);
        gp2.add(t4[0], 0, 2);
        gp2.add(t5[0], 0, 3);
        gp3.add(t3[1], 0, 4);
        gp3.add(t4[1], 0, 5);
        gp3.add(t5[1], 0, 6);
        gp4.add(t3[2], 0, 7);
        gp4.add(t4[2], 0, 8);
        gp4.add(t5[2], 0, 9);
        gp2.add(t3[3], 1, 1);
        gp2.add(t4[3], 1, 2);
        gp2.add(t5[3], 1, 3);
        gp3.add(t3[4], 1, 4);
        gp3.add(t4[4], 1, 5);
        gp3.add(t5[4], 1, 6);
        gp4.add(t3[5], 1, 7);
        gp4.add(t4[5], 1, 8);
        gp4.add(t5[5], 1, 9);
        gp2.add(t3[6], 2, 1);
        gp2.add(t4[6], 2, 2);
        gp2.add(t5[6], 2, 3);
        gp3.add(t3[7], 2, 4);
        gp3.add(t4[7], 2, 5);
        gp3.add(t5[7], 2, 6);
        gp4.add(t3[8], 2, 7);
        gp4.add(t4[8], 2, 8);
        gp4.add(t5[8], 2, 9);
        gp2.add(t3[9], 3, 1);
        gp2.add(t4[9], 3, 2);
        gp2.add(t5[9], 3, 3);
        gp3.add(t3[10], 3, 4);
        gp3.add(t4[10], 3, 5);
        gp3.add(t5[10], 3, 6);
        gp4.add(t3[11], 3, 7);
        gp4.add(t4[11], 3, 8);
        gp4.add(t5[11], 3, 9);
       
        //Previous Page Button Initialization
        Button back = new Button("Previous Page");
        back.setOnAction((ActionEvent event) -> {
                buildTheaterMainPanel(theaterArr, bPane, primaryStage);
             });
        
        //Add Content to VBox Pane Holders
        v2.getChildren().addAll(gp2, gp3, gp4);
        v1.getChildren().addAll(title, gp, v2, back);
        
        //Set new VBoxes to corresponding bPane areas
        bPane.setTop(v1);
        bPane.setCenter(null);
        bPane.setLeft(null);
        bPane.setBottom(null);
        
        //Adjust stage height to allow all items to be shown
        primaryStage.setMinHeight(450);
    }
    
    
    public static void buildViewerTotalPanel(Theater[] theaterArr, BorderPane bPane, Stage primaryStage){
        //Initialization of VBox Pane
        VBox v1 = new VBox();
        v1.setAlignment(Pos.CENTER);
        v1.setSpacing(30);

        //Initialization of GridPane Object
        GridPane gp1 = new GridPane();
        gp1.setAlignment(Pos.CENTER);
        gp1.setHgap(60);
        gp1.setVgap(10);
        
        //Initialization of Array of Labels
        Label[] la = new Label[4];
        Label[] lb = new Label[4];
        
        //Initialization of non-array Labels
        Label title = new Label("Viewer Total");
        title.setAlignment(Pos.CENTER);
        Label filmT = new Label("Film:");
        Label viewT = new Label("Tickets Sold:");
        
        //Adding Labels to GridPane
        gp1.add(filmT, 0, 0);
        gp1.add(viewT, 1, 0);
        
        //Initialization of film name Labels and adding to GridPane
        for(int i = 0; i < la.length; i++){
            la[i] = new Label(theaterArr[i].f[0].getFilmName());
            gp1.add(la[i], 0, (i + 1));
        }
        
        //Initialization of tickets sold Labels and adding to GridPane
        for(int i = 0; i < lb.length; i++){
            lb[i] = new Label("" + (theaterArr[i].f[0].getSs() + theaterArr[i].f[1].getSs() + theaterArr[i].f[2].getSs()));
            gp1.add(lb[i], 1, (i + 1));
        }
        
        //Previous Page Button Initialization
        Button back = new Button("Previous Page");
        back.setOnAction((ActionEvent event) -> {
                buildTheaterMainPanel(theaterArr, bPane, primaryStage);
             });
        
        //Add Content Panes to VBox
        v1.getChildren().addAll(title, gp1, back);
        
        //Assign VBox to corresponding BorderPane Areas
        bPane.setTop(null);
        bPane.setCenter(v1);
        bPane.setLeft(null);
        bPane.setBottom(null);
    }
}