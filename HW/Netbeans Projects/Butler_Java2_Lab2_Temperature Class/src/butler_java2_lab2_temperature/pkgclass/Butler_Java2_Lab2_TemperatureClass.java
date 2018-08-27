package butler_java2_lab2_temperature.pkgclass;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Butler_Java2_Lab2_TemperatureClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double temp;
        
        System.out.println("Hello and welcome to the temperature conversion program.");
        System.out.print("Please enter a Farenheit temperature to be converted: ");
        temp = input.nextDouble();
        
        DecimalFormat df = new DecimalFormat("###.####");
        Temperature t = new Temperature(temp);
        
        System.out.println("Converting Farenheit Temprature....");
        System.out.println("Farenheit Temperature: °" + df.format(t.getFarenheit()));
        System.out.println("Converted Celsius Temperature: °" + df.format(t.getCelsius()));
        System.out.println("Converted Kelvin Temperature: °" + df.format(t.getKelvin()));
    }
    
}
