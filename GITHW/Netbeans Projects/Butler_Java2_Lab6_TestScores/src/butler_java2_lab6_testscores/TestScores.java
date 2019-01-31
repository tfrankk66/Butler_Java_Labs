package butler_java2_lab6_testscores;

public class TestScores {
    private double[] arr;
    
    
    public TestScores(double[] array){
        arr = new double[array.length];
        arr = array;
        for(int i = 0; i < arr.length; i++){
            if(array[i] < 0 || array[i] > 100){
                throw new IllegalArgumentException("Tests scores may not be negative or greater than 100.");
            }
            this.arr[i] = array[i];
        }
        
    }

    public double[] getArr() {
        return arr;
    }
    public void setArr(double[] arr) {
        this.arr = arr;
    }
    
    public double testScoreAverage(){
        double average = 0;
        for(int i = 0; i < arr.length; i++){
            average += arr[i];
        }
        
        return average / arr.length;
    }
}
