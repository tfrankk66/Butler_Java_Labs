package butler_java2_lab5_coursegrades;

public class Butler_Java2_Lab5_CourseGrades {

    public static void main(String[] args) {
        //Object Initialization
        CourseGrades cGrade = new CourseGrades();
        GradedActivity act1 = new LabActivity(95);
        GradedActivity act2 = new PassFailExam(10, 4, 70);
        GradedActivity act3 = new Essay(75);
        GradedActivity act4 = new FinalExam(50, 5);
        
        //Set Methods
        cGrade.setLab(act1);
        cGrade.setPassFailExam(act2);
        cGrade.setEssay(act3);
        cGrade.setFinalExam(act4);
        
        System.out.print(cGrade);
    }
    
}
