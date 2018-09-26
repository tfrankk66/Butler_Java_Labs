package butler_java2_lab6_retailitemexception;

public class NegativeUnitsException extends Exception {
    
    public NegativeUnitsException(){
        super("Error: Negative value entered for units!");
    }
    
}
