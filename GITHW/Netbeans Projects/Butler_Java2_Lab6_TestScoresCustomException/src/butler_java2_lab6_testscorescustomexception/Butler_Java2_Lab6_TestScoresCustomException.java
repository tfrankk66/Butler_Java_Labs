package butler_java2_lab6_testscorescustomexception;

public class Butler_Java2_Lab6_TestScoresCustomException {

    public static void main(String[] args) {
        double[] ts = {67, 78, 89, -1};
        
        try{
            TestScoresModified tsm = new TestScoresModified(ts);
        }
        catch(InvalidTestScore t){
            System.out.print(t.getMessage());
        }
    }
}
