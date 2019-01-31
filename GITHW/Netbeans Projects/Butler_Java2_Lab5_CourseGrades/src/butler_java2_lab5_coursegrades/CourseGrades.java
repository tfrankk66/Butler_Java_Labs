package butler_java2_lab5_coursegrades;

public class CourseGrades {
    
    GradedActivity[] grades = new GradedActivity[4];
    
    public void setLab(GradedActivity lab){
        grades[0] = lab;
    }
    
    public void setPassFailExam(GradedActivity passFail){
        grades[1] = passFail;
    }
    
    public void setEssay(GradedActivity essay){
        grades[2] = essay;
    }
    
    public void setFinalExam(GradedActivity finExam){
        grades[3] = finExam;
    }
    
    @Override
    public String toString(){
        String str = "Scores & Grades "
                   + "\n--------------------"
                   + "\nScore #1: " + grades[0].getScore() + "      Grade #1: " + grades[0].getGrade()
                   + "\nScore #2: " + grades[1].getScore() + "      Grade #2: " + grades[1].getGrade()
                   + "\nScore #3: " + grades[2].getScore() + "      Grade #3: " + grades[2].getGrade()
                   + "\nScore #4: " + grades[3].getScore() + "      Grade #4: " + grades[3].getGrade();
        
        return str;
    }
}
