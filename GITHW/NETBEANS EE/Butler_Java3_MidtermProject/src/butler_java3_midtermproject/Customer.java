
package butler_java3_midtermproject;

/**
 *
 * @author tfran
 */
public class Customer {
    
    private String custName;
    private String cityName;
    
    public Customer(String custName, String cityName){
        this.custName = custName;
        this.cityName = cityName;
    }

    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
 
}
