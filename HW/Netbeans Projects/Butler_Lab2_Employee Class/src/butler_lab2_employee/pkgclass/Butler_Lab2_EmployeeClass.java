package butler_lab2_employee.pkgclass;

public class Butler_Lab2_EmployeeClass {
    
    public static void main(String[] args) {
        Employee e1 = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        Employee e2 = new Employee("Mark Jones", 39119, "IT", "Programmer");
        Employee e3 = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");
        
        System.out.println("Name          ID Number      Department       Position");
        System.out.println("---------------------------------------------------------");
        System.out.println(e1.getName() + "    " + e1.getIdNumber() + "        " + e1.getDepartment() + "    " + e1.getPosition());
        System.out.println(e2.getName() + "      " + e2.getIdNumber() + "        " + e2.getDepartment() + "              " + e2.getPosition());
        System.out.println(e3.getName() + "      " + e3.getIdNumber() + "        " + e3.getDepartment() + "    " + e3.getPosition());
        
    }
    
}
