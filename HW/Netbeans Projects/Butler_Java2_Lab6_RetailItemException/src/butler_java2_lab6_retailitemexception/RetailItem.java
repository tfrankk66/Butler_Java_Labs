package butler_java2_lab6_retailitemexception;

public class RetailItem {

    private String description;
    private int unitsOnHand;
    private double price;
    
    public RetailItem(){
        this.description = " ";
        this.unitsOnHand = 0;
        this.price = 0.0;
    }
    
    //Accesor Methods
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getUnitsOnHand() {
        return unitsOnHand;
    }
    public void setUnitsOnHand(int unitsOnHand) throws NegativeUnitsException {
        if(unitsOnHand < 0){
            throw new NegativeUnitsException();
        }
        else{
        this.unitsOnHand = unitsOnHand;
        }
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) throws NegativePriceException {
        if(price < 0){
            throw new NegativePriceException();
        }
        else{
        this.price = price;
        }
    }
    
    
}
