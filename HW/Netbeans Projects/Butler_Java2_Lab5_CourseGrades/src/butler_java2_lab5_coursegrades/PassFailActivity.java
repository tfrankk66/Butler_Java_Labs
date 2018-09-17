package butler_java2_lab5_coursegrades;


public class PassFailActivity extends GradedActivity {
    private double minPassingScore;
    
    
    public PassFailActivity(double mps){
        minPassingScore = mps;
    }
    
    @Override
    public char getGrade(){
        char letterGrade;
        
        if(super.getScore() >= minPassingScore)
            letterGrade = 'P';
        else
            letterGrade = 'F';
        
        return letterGrade;
    }
    
}
