package butler_java3_midtermproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author tfran
 */
public class SQLUtil {
    
    //Fields for Util Class
    private ResultSet rs;
    private ResultSet rs1;
    private Statement stmt;
    private Connection cn;
    ObservableList<Order> oList;
    ObservableList<Customer> cList;
    ObservableList<Employee> eList;
    
    
    public ObservableList<Order> getDetailList(Connection Con, int orderNum) throws SQLException{

        //Initialize Connection Object, List Objects
        cn = ConnectionUtil.getConnection();
        List<Integer> orderId = new ArrayList<>();
        List<Double> prodNum = new ArrayList<>();
        List<String> prodName = new ArrayList<>();
        List<Double> uPrice = new ArrayList<>();
        List<Integer> quantity = new ArrayList<>();
        List<Double> discount = new ArrayList<>();
        List<Double> tPrice = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();
        
        //Create statement and get Resultset data
        stmt = cn.createStatement();
        //Query for info from order details page
        rs = stmt.executeQuery("select * from [order details] where orderid=" + orderNum);
        
        
            //While loop to input data into appropriate lists
           while(rs.next()){
                orderId.add(rs.getInt(1));
                prodNum.add(rs.getDouble(2));
                uPrice.add(rs.getDouble(3));
                quantity.add(rs.getInt(4));
                discount.add(rs.getDouble(5));
            }

           //Predetermined SQL statement
           String sql = "select UnitPrice*Quantity-UnitPrice*Quantity*Discount from [order details] where orderid=" + orderNum;
           
           //Second result set query for computation
           rs = stmt.executeQuery(sql);
           
           //Get Final price 
           while(rs.next()){
               tPrice.add(rs.getDouble(1));
           }
        
           //For loop to query and get product names based off of matching prodcut id's
            for(int i = 0; i < prodNum.size(); i++){
                rs1 = stmt.executeQuery("select * from products where productid=" + prodNum.get(i));
                while(rs1.next()){
                    prodName.add(rs1.getString(2));
                }
            }
  
        //For loop to add Order objects to order list
        for(int i = 0; i < prodNum.size(); i++){
            orderList.add(new Order(orderId.get(i), prodName.get(i), uPrice.get(i), quantity.get(i), discount.get(i), tPrice.get(i)));

        }
    
        //Creation of observable list from order list
        oList = FXCollections.observableList(orderList);

        return oList;
    }
    
    
    public ObservableList<Order> getOrderDetailList(Connection con, int orderNum ) throws SQLException{
        //Initialize Connection Object, List Objects
        cn = ConnectionUtil.getConnection();
        List<Integer> orderId = new ArrayList<>();
        List<Date> orderDate = new ArrayList<>();
        List<Double> freightCharge = new ArrayList<>();
        List<Double> prodNum = new ArrayList<>();
        List<String> prodName = new ArrayList<>();
        List<Double> uPrice = new ArrayList<>();
        List<Integer> quantity = new ArrayList<>();
        List<Double> discount = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();
        
        //Create statement and get Resultset data
        stmt = cn.createStatement();
        
        //Predefined query
        String sql = "select * from Orders inner join [Order Details] on Orders.OrderID=[Order Details].OrderID where orderid=" + orderNum;
        
        //Query for info from order details page
        rs = stmt.executeQuery(sql);
        
        //Column Index Variables
        int orderIdIndex = rs.findColumn("orderid");
        int orderDateIndex = rs.findColumn("orderdate");
        int freightIndex = rs.findColumn("freight");
        int unitPriceIndex = rs.findColumn("unitprice");
        int quantityIndex = rs.findColumn("quantity");
        int discountIndex = rs.findColumn("discount");
        
        //While loop to input data into appropriate lists
        while(rs.next()){
            orderId.add(rs.getInt(orderIdIndex));
            orderDate.add(rs.getDate(orderDateIndex));
            freightCharge.add(rs.getDouble(freightIndex));
            uPrice.add(rs.getDouble(unitPriceIndex));
            quantity.add(rs.getInt(quantityIndex));
            discount.add(rs.getDouble(discountIndex));
        }
        
        //Execute SQL Query
        rs = stmt.executeQuery("select * from [order details] where orderid=" + orderNum);
        
        //Get product id num
        while(rs.next()){
            prodNum.add(rs.getDouble(2));
        }
        
        //For loop to query and get product names based off of matching prodcut id's
        for(int i = 0; i < prodNum.size(); i++){
            rs1 = stmt.executeQuery("select * from products where productid=" + prodNum.get(i));
            while(rs1.next()){
                prodName.add(rs1.getString(2));
            }
        }
        
        //Add order objects to order list
        for(int i = 0; i < prodNum.size(); i++){
            orderList.add(new Order(orderId.get(i), prodName.get(i), uPrice.get(i), quantity.get(i), discount.get(i), freightCharge.get(i), orderDate.get(i)));
        }
        
        //Creation of observable list from order list
        oList = FXCollections.observableList(orderList);
        
        return oList;
    }
    
    public ObservableList<Customer> getCustInfoList(Connection con, String state)throws SQLException{
        //Initialize Connection Object, List Objects
        cn = ConnectionUtil.getConnection();
        List<String> custName = new ArrayList<>();
        List<String> custCity = new ArrayList<>();
        List<Customer> custList = new ArrayList<>();
        
        //Create statement and get Resultset data
        stmt = cn.createStatement();
        
        //Predefined query
        String sql = "select ContactName, City from customers where Region LIKE '%" + state + "%' order by City";
        
        //Query for info from order details page
        rs = stmt.executeQuery(sql);
        
        //Input data into perspective lists
        while(rs.next()){
            custName.add(rs.getString(1));
            custCity.add(rs.getString(2));
        }
        
        //Add customer objects into customer list
        for(int i = 0; i < custName.size(); i++){
            custList.add(new Customer(custName.get(i), custCity.get(i)));
        }
        
        //Create observable list for table view
        cList = FXCollections.observableList(custList);
        
        
        return cList;
    }
    
    public ObservableList<Employee> getEmployeeBirthList(Connection con, int year) throws SQLException{
        //Initialize Connection Object, List Objects
        cn = ConnectionUtil.getConnection();
        List<String> empFName = new ArrayList<>();
        List<String> empLName = new ArrayList<>();
        List<Date> empBYear = new ArrayList<>();
        List<Employee> empList = new ArrayList<>();
        
        //Create statement and get Resultset data
        stmt = cn.createStatement();
        
        //Predefined query
        String sql = "select FirstName, LastName, BirthDate from Employees where BirthDate Like '%" + year + "%' order by LastName";
        
        //Query for info from employees page
        rs = stmt.executeQuery(sql);
        
        //Add info into respective lists
        while(rs.next()){
            empFName.add(rs.getString(1));
            empLName.add(rs.getString(2));
            empBYear.add(rs.getDate(3));
        }
        
        //Add employee classes to employee list
        for(int i = 0; i < empFName.size(); i++){
            empList.add(new Employee(empFName.get(i), empLName.get(i), empBYear.get(i)));
        }
        
        //Creat observable list from employee list
        eList = FXCollections.observableList(empList);
        
        return eList;
    }
    
    public Boolean validateOrderNum(Connection con, int orderNum) throws SQLException{
        Boolean validate = true;
        
        //Initialize Connection
        cn = ConnectionUtil.getConnection();
        
        //Create statement and get Resultset data
        stmt = cn.createStatement();
        //Query for info from order details page
        rs = stmt.executeQuery("select * from [order details] where orderid=" + orderNum);
        
        //If no resultSet data found flag false
        if(rs.next() == false){
            validate = false;
        }
        
        return validate;
    }
    
    public Boolean validateCustomerState(Connection con, String state) throws SQLException{
        Boolean validate = true;
        
        //Initialize Connection
        cn = ConnectionUtil.getConnection();
        
        //Create statement and get Resultset data
        stmt = cn.createStatement();
        
        //Predefined query
        String sql = "select ContactName, City from customers where Region LIKE '%" + state + "%' order by City";
        
        //Query for info from order details page
        rs = stmt.executeQuery(sql);
        
        //If no resultSet data found flag false
        if(rs.next() == false){
            validate = false;
        }
        
        return validate;
    }
    
    public Boolean validateEmpBirthday(Connection con, int year) throws SQLException{
        Boolean validate = true;
        
        //Initialize Connection
        cn = ConnectionUtil.getConnection();
        
        //Create statement and get Resultset data
        stmt = cn.createStatement();
        
        //Predefined query
        String sql = "select FirstName, LastName, BirthDate from Employees where BirthDate Like '%" + year + "%' order by LastName";
        
        //Query for info from employees page
        rs = stmt.executeQuery(sql);
        
        //If no resultSet data found flag false
        if(rs.next() == false){
            validate = false;
        }
        
        return validate;
    }
}
