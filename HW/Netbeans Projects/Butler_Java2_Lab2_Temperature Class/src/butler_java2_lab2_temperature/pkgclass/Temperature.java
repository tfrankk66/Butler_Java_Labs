package butler_java2_lab2_temperature.pkgclass;

public class Temperature {
    double ftemp;
    
    public Temperature(double a){
        this.ftemp = a;
    }
    
    public void setFarenheit(double temp){
        this.ftemp = temp;
    }
    
    public double getFarenheit(){
        return ftemp;
    }
    
    public double getCelsius(){
        double c = (5.0 / 9.0) * (ftemp - 32);
        return c;
    }
    
    public double getKelvin(){
        double k = (((5.0/9.0) * (ftemp - 32)) + 273.0);
        return k;
    }
}
