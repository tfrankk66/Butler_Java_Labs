package butler_java2_lab6_testscorescustomexception;

public class InvalidTestScore extends Exception{
    
    public InvalidTestScore(){
        super("Error: Invalid Test Score!");
    }
    
}
