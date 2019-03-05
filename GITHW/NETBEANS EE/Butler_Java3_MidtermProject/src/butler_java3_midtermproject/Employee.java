
package butler_java3_midtermproject;

import java.sql.Date;

/**
 *
 * @author tfran
 */
public class Employee {
    private String fName;
    private String lName;
    private Date bYear;
    
    public Employee(String fName, String lName, Date bYear){
        this.fName = fName;
        this.lName = lName;
        this.bYear = bYear;
    }

    public String getFName() {
        return fName;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }
    public String getLName() {
        return lName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }
    public Date getBYear() {
        return bYear;
    }
    public void setBYear(Date bYear) {
        this.bYear = bYear;
    }
}
