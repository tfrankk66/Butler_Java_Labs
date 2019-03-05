/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butler_java3_midtermproject;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author tfran
 */
public class Butler_Java3_MidtermProject extends Application {
    
    private static Connection con;
    private SQLUtil sUtil;
    private static ResultSet rs;
    private static StringBuilder orderTot;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, SQLException {
        //Creation of Connection Object
        con = ConnectionUtil.getConnection();
        sUtil = new SQLUtil();
        
        //Creation of MenuBar
        MenuBar mb = new MenuBar();
        
        //Creation of Menu's
        Menu orderMenu = new Menu("Orders");
        Menu customerMenu = new Menu("Customers");
        Menu employeeMenu = new Menu("Employees");
        
        //Creation of Menu Items
        MenuItem orderTot = new MenuItem("Order Total");
        MenuItem orderDet = new MenuItem("Order Details");
        MenuItem custInfo = new MenuItem("Customer State Info.");
        MenuItem empInfo = new MenuItem("Employee Birthdays");
        
        //Add Menu items to corresponding menu's
        orderMenu.getItems().addAll(orderTot, orderDet);
        customerMenu.getItems().add(custInfo);
        employeeMenu.getItems().add(empInfo);
        
        //Add all Menu's into the Menu Bar
        mb.getMenus().addAll(orderMenu, customerMenu, employeeMenu);
        
        //Creation of Image Object to display Northwind Logo
        Image image = new Image(new FileInputStream("C:\\Users\\tfran\\Butler_CS_HW\\Butler_LabWork_Repo\\GITHW\\NETBEANS EE\\Butler_Java3_MidtermProject\\src\\images\\NorthwindLogo.jpg"));
        ImageView imageView = new ImageView(image);
        
        //Creation of Borderpane Object
        BorderPane root = new BorderPane();
        
        //Scene Setup
        root.setTop(mb);
        root.setCenter(imageView);
        Scene scene = new Scene(root, 700, 450);
        
        //Primary Stage Attributes Assigned
        primaryStage.setTitle("Butler_Java3_Midterm");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Event Handlers Assigned
        orderTot.setOnAction(e -> {
            buildOrderTotScreen(root, primaryStage, mb, sUtil);
        });
        orderDet.setOnAction(e -> {
            buildOrderDetScreen(root, primaryStage, mb, sUtil);
        });
        custInfo.setOnAction(e -> {
            buildCustomerScreen(root, primaryStage, mb, sUtil);
        });
        empInfo.setOnAction(e -> {
            buildEmployeeBirthdayScreen(root, primaryStage, mb, sUtil);
        });
        
        con.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void buildOrderTotScreen(BorderPane root, Stage primaryStage, MenuBar mb, SQLUtil sUtil){
        //JavaFX Elements Created
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb1 = new HBox();
        TextField tf1 = new TextField();
        Button totButton = new Button("Retreive Order Total");
        
        //Element Attributes Defined
        hb1.setAlignment(Pos.CENTER);
        vb1.setAlignment(Pos.CENTER);
        vb2.setAlignment(Pos.CENTER);
        hb1.setSpacing(5);
        vb1.setSpacing(5);
        
        //Assigning Elements to respective Container Objects
        hb1.getChildren().addAll(new Label("Please Enter a Order Number:"), tf1);
        vb1.getChildren().addAll(hb1, totButton);
        root.setCenter(vb1);
        
        //Total Button Action Listener
        totButton.setOnAction(e -> {
            //Input value from TextField
            int tfIn = Integer.parseInt(tf1.getText());
            Boolean v = true;
            
            //Validation Clause
            try {
                v = sUtil.validateOrderNum(con, tfIn);
            } catch (SQLException ex) {
                Logger.getLogger(Butler_Java3_MidtermProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Validation Loop
            while(v != true){
                vb2.getChildren().addAll(new Label("ERROR: Please enter a valid Order Number:"), vb1);
                root.setCenter(null);
                root.setCenter(vb2);
            }
            
            //TableView Creation
            TableView<Order> table = new TableView<>();
            
            //Column Creation
            TableColumn<Order, Integer> orderIdCol = new TableColumn<>("Order ID");
            TableColumn<Order, String> productNameCol = new TableColumn<>("Product Name");
            TableColumn<Order, Double> unitPriceCol = new TableColumn<>("Unit Price");
            TableColumn<Order, Integer> quantityCol = new TableColumn<>("Quantity");
            TableColumn<Order, Double> discountCol = new TableColumn<>("Discount");
            TableColumn<Order, Double> totalPriceCol = new TableColumn<>("Total Price");
            
            //Defines how to fill the data
            orderIdCol.setCellValueFactory(new PropertyValueFactory<>("orderId"));
            productNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
            unitPriceCol.setCellValueFactory(new PropertyValueFactory<>("uPrice"));
            quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            discountCol.setCellValueFactory(new PropertyValueFactory<>("discount"));
            totalPriceCol.setCellValueFactory(new PropertyValueFactory<>("totPrice"));
            
            try {
                //List to hold table info
                ObservableList<Order> list = sUtil.getDetailList(con, tfIn);
                //Set Table info
                table.setItems(list);
                //Set Table columns
                table.getColumns().addAll(orderIdCol, productNameCol, unitPriceCol, quantityCol, discountCol, totalPriceCol);
            } catch (SQLException ex) {
                Logger.getLogger(Butler_Java3_MidtermProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            root.setCenter(table);
            
        });
    }
    
    public static void buildOrderDetScreen(BorderPane root, Stage primaryStage, MenuBar mb, SQLUtil sUtil){
        //JavaFX Elements Created
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb1 = new HBox();
        TextField tf1 = new TextField();
        Button detButton = new Button("Retreive Order Details");
        
        //Element Attributes Defined
        hb1.setAlignment(Pos.CENTER);
        vb1.setAlignment(Pos.CENTER);
        vb2.setAlignment(Pos.CENTER);
        hb1.setSpacing(5);
        vb1.setSpacing(5);
        
        //Assigning Elements to respective Container Objects
        hb1.getChildren().addAll(new Label("Please Enter a Order Number:"), tf1);
        vb1.getChildren().addAll(hb1, detButton);
        root.setCenter(vb1);
        
        //Total Button Action Listener
        detButton.setOnAction(e -> {
            //Input value from TextField
            int tfIn = Integer.parseInt(tf1.getText());
            
            Boolean v = true;
            //Validation Clause
            try {
                v = sUtil.validateOrderNum(con, tfIn);
            } catch (SQLException ex) {
                Logger.getLogger(Butler_Java3_MidtermProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Validation Loop
            while(v != true){
                vb2.getChildren().addAll(new Label("ERROR: Please enter a valid Order Number:"), vb1);
                root.setCenter(null);
                root.setCenter(vb2);
            }
            
            //Creation Of TableView
            TableView<Order> table = new TableView<>();
            
            //Column Creation
            TableColumn<Order, Integer> orderIdCol = new TableColumn<>("Order ID");
            TableColumn<Order, Date> orderDateCol = new TableColumn<>("Order Date");
            TableColumn<Order, Double> freightChargeCol = new TableColumn<>("Freight Charge");
            TableColumn<Order, String> productNameCol = new TableColumn<>("Product Name");
            TableColumn<Order, Double> unitPriceCol = new TableColumn<>("Unit Price");
            TableColumn<Order, Integer> quantityCol = new TableColumn<>("Quantity");
            TableColumn<Order, Double> discountCol = new TableColumn<>("Discount");
            
            //Defines how to fill the data
            orderIdCol.setCellValueFactory(new PropertyValueFactory<>("orderId"));
            orderDateCol.setCellValueFactory(new PropertyValueFactory<>("oDate"));
            freightChargeCol.setCellValueFactory(new PropertyValueFactory<>("freight"));
            productNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
            unitPriceCol.setCellValueFactory(new PropertyValueFactory<>("uPrice"));
            quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            discountCol.setCellValueFactory(new PropertyValueFactory<>("discount"));
            
            try {
                //List to hold table info
                ObservableList<Order> list = sUtil.getOrderDetailList(con, tfIn);
                //Set Table info
                table.setItems(list);
                //Set Table columns
                table.getColumns().addAll(orderIdCol, orderDateCol, freightChargeCol, productNameCol, unitPriceCol, quantityCol, discountCol);
            } catch (SQLException ex) {
                Logger.getLogger(Butler_Java3_MidtermProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            root.setCenter(table);
        });
    }
    
    public static void buildCustomerScreen(BorderPane root, Stage primaryStage, MenuBar mb, SQLUtil sUtil){
        //JavaFX Elements Created
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb1 = new HBox();
        TextField tf1 = new TextField();
        Button cusButton = new Button("Retreive Customer Info.");
        
        //Element Attributes Defined
        hb1.setAlignment(Pos.CENTER);
        vb1.setAlignment(Pos.CENTER);
        vb2.setAlignment(Pos.CENTER);
        hb1.setSpacing(5);
        vb1.setSpacing(5);
        
        //Assigning Elements to respective Container Objects
        hb1.getChildren().addAll(new Label("Please Enter a State (EX: GA):"), tf1);
        vb1.getChildren().addAll(hb1, cusButton);
        root.setCenter(vb1);
        
        cusButton.setOnAction(e -> {
            //Input value from TextField
            String tfIn = tf1.getText();

            Boolean v = true;
            
            //Validation Clause
            try {
                v = sUtil.validateCustomerState(con, tfIn);
            } catch (SQLException ex) {
                Logger.getLogger(Butler_Java3_MidtermProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Validation Loop
            while(v != true){
                vb2.getChildren().addAll(new Label("ERROR: Please enter a valid State (EX: GA):"), vb1);
                root.setCenter(null);
                root.setCenter(vb2);
            }
            
            //Creation of TableView
            TableView<Customer> table = new TableView<>();
            
            //Column Creation
            TableColumn<Customer, String> custNameCol = new TableColumn<>("Customer Name");
            TableColumn<Customer, String> custCityCol = new TableColumn<>("Customer City");
            
            //Defines how to fill the data
            custNameCol.setCellValueFactory(new PropertyValueFactory<>("custName"));
            custCityCol.setCellValueFactory(new PropertyValueFactory<>("cityName"));
            
            

            try {
                //List to hold table info
                ObservableList<Customer> list = sUtil.getCustInfoList(con, tfIn);
                //Set Table info
                table.setItems(list);
                //Set Table columns
                table.getColumns().addAll(custNameCol, custCityCol);
            } catch (SQLException ex) {
                Logger.getLogger(Butler_Java3_MidtermProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            root.setCenter(table);
            
        });
    }
    
    public static void buildEmployeeBirthdayScreen(BorderPane root, Stage primaryStage, MenuBar mb, SQLUtil sUtil){
        //JavaFX Elements Created
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb1 = new HBox();
        TextField tf1 = new TextField();
        Button empButton = new Button("Retreive Employee Info.");
        
        //Element Attributes Defined
        hb1.setAlignment(Pos.CENTER);
        vb1.setAlignment(Pos.CENTER);
        vb2.setAlignment(Pos.CENTER);
        hb1.setSpacing(5);
        vb1.setSpacing(5);
        
        //Assigning Elements to respective Container Objects
        hb1.getChildren().addAll(new Label("Please Enter a Birth Year (EX: 1995):"), tf1);
        vb1.getChildren().addAll(hb1, empButton);
        root.setCenter(vb1);
        
        empButton.setOnAction(e -> {
            //Input value from TextField
            int tfIn = Integer.parseInt(tf1.getText());
            
            Boolean v = true;
            
            //Validation Clause
            try {
                v = sUtil.validateEmpBirthday(con, tfIn);
            } catch (SQLException ex) {
                Logger.getLogger(Butler_Java3_MidtermProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Validation Loop
            while(v != true){
                vb2.getChildren().addAll(new Label("ERROR: Please enter a valid Birth Year (EX: 1995):"), vb1);
                root.setCenter(null);
                root.setCenter(vb2);
            }
            
            //TableView Creation
            TableView<Employee> table = new TableView<>();
            
            //Column Creation
            TableColumn<Employee, String> empFNameCol = new TableColumn<>("First Name");
            TableColumn<Employee, String> empLNameCol = new TableColumn<>("Last Name");
            TableColumn<Employee, String> empBYearCol = new TableColumn<>("Birth Year");
            
            //Defines how to fill the data
            empFNameCol.setCellValueFactory(new PropertyValueFactory<>("fName"));
            empLNameCol.setCellValueFactory(new PropertyValueFactory<>("lName"));
            empBYearCol.setCellValueFactory(new PropertyValueFactory<>("bYear"));
            
            

            try {
                //List to hold table info
                ObservableList<Employee> list = sUtil.getEmployeeBirthList(con, tfIn);
                //Set Table info
                table.setItems(list);
                //Set Table columns
                table.getColumns().addAll(empFNameCol, empLNameCol, empBYearCol);
            } catch (SQLException ex) {
                Logger.getLogger(Butler_Java3_MidtermProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            root.setCenter(table);
            
        });
        
        
    }
    
}
