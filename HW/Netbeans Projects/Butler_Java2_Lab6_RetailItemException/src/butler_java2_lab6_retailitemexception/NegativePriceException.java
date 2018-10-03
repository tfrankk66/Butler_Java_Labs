package butler_java2_lab6_retailitemexception;

public class NegativePriceException extends Exception{
    
    public NegativePriceException(){
        super("Error: Negative value entered for price!");
    }
    
}
