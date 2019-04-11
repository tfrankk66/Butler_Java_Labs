package javaeetutorial.dukesbookstore.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "WEB_BOOKSTORE_STATETAX")
@NamedQuery(
        name = "findStateTaxes",
        query = "SELECT s FROM StateTax s ORDER BY s.state")
public class StateTax implements Serializable{
    
    @Id
    private String state;
    private double tax;
    
    
    public StateTax(){
        
    }
    
    public StateTax(String s, double t){
        this.state = s;
        this.tax = t;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    
    
    
}
