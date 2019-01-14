/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butler_java3_lab1_addressbook;

/**
 *
 * @author tfran
 */
public class Address {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    
    public Address(){
        this.name = "";
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = "";
    }
    
    public Address(String a, String b, String c, String d, String e){
        setName(a);
        setStreet(b);
        setCity(c);
        setState(d);
        setZip(e);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
}
