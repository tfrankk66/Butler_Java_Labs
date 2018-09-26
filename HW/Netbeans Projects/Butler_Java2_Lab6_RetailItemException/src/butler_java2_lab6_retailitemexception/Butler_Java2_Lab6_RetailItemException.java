package butler_java2_lab6_retailitemexception;

public class Butler_Java2_Lab6_RetailItemException {

    public static void main(String[] args) {
        RetailItem ri = new RetailItem();
        
        try{
            ri.setPrice(-2.0);
        }
        catch(NegativePriceException e){
            System.out.println(e.getMessage());
        }
        
        try{
            ri.setUnitsOnHand(-4);        
        }
        catch(NegativeUnitsException e){
            System.out.println(e.getMessage());
        }
    }
    
}
