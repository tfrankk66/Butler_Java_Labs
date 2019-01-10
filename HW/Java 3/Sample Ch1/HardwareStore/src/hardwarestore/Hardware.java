/*
 * Hardware class - Represents an item in the HardwareStore inventory
 */
package hardwarestore;

/**
 *
 * @author David Swaim
 */
public class Hardware 
{
    private String name;
    private int quantity;
    private double price;
    
    public Hardware() { this("",0,0.0); }
    
    public Hardware( String name, int quantity, double price )
    {
        setName(name);
        setQuantity(quantity);
        setPrice(price);
    }
    
    public String getName() { return name; }
    public void setName( String name ) { this.name = name; }
    public int getQuantity() { return quantity; }
    public void setQuantity( int quantity ) { this.quantity = quantity > 0 ? quantity : 0; }
    public double getPrice() { return price; }
    public void setPrice( double price ) { this.price = price > 0.0 ? price : 0.0; }
    
}
