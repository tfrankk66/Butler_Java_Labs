package butler_lab2_employee.pkgclass;

public class Employee {
    //Class Fields
    private String Name;
    private int idNumber;
    private String Department;
    private String Position;
    
    //Full Accepting Constructor
    public Employee(String a, int b, String c, String d ){
        this.Name = a;
        this.idNumber = b;
        this.Department = c;
        this.Position = d;
    }
    
    //Semi-Full Accepting Contructor
    public Employee(String a, int b){
        this.Name = a;
        this.idNumber = b;
        this.Department = "";
        this.Position = "";
    }
    //No-Arg Constructor
    public Employee(){
        this.Name = "";
        this.idNumber = 0;
        this.Position = "";
        this.Position = "";
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }
    
    
}
