package butler_java3_lab6_internationalization;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author tfran
 */
public class CurrencyConv {
    
    //Locale Creation
    public Locale cd = Locale.CANADA;
    public Locale e = Locale.GERMANY;
    public Locale bp = Locale.UK;
    
    //Conversion Method for CANADA
    public String convertCD(double da, double ex){
        double convA = (da * ex);
        
        NumberFormat CF = NumberFormat.getCurrencyInstance(cd);
        String cdCurr = CF.format(convA);
        
        return cdCurr;
    }
    
    //Conversion Method for GERMANY
    public String convertE(double da, double ex){
        double convA = (da * ex);
        
        NumberFormat CF = NumberFormat.getCurrencyInstance(e);
        String cdCurr = CF.format(convA);
        
        return cdCurr;
    }
    
    //Conversion Method for UK
    public String convertBP(double da, double ex){
        double convA = (da * ex);
        
        NumberFormat CF = NumberFormat.getCurrencyInstance(bp);
        String cdCurr = CF.format(convA);
        
        return cdCurr;
    }
    
}
