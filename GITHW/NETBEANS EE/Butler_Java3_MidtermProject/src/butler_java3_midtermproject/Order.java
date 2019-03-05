
package butler_java3_midtermproject;

import java.sql.Date;


        
public class Order {
    
    private int orderId;
    private String productName;
    private double uPrice;
    private double freight;
    private double discount;
    private double totPrice;
    private Date oDate;
    private int quantity;
    
    public Order(int id, String pName, double up, int q, double d, double tp){
        this.orderId = id;
        this.productName = pName;
        this.uPrice = up;
        this.quantity = q;
        this.discount = d;
        this.totPrice = tp;
    }
    
    public Order(int id, String pName, double up, int q, double d, double f, Date dt){
        this.orderId = id;
        this.productName = pName;
        this.uPrice = up;
        this.quantity = q;
        this.discount = d;
        this.freight = f;
        this.oDate = dt;
    }
    
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int OrderID) {
        this.orderId = OrderID;
    }
    public String getProductName() {
        return productName;
    }
    public double getTotPrice() {
        return totPrice;
    }
    public void setTotPrice(double totPrice) {
        this.totPrice = totPrice;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getUPrice() {
        return uPrice;
    }
    public void setUPrice(double uPrice) {
        this.uPrice = uPrice;
    }
    public double getFreight() {
        return freight;
    }
    public void setFreight(double freight) {
        this.freight = freight;
    }
    public Date getODate() {
        return oDate;
    }
    public void setODate(Date oDate) {
        this.oDate = oDate;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
