package butler_java2_lab4_sumofdigits;
import java.util.Scanner;

public class Butler_Java2_Lab4_SumofDigits {
    
    public static void main(String[] args) {
        //Initialization
        Scanner input = new Scanner(System.in);
        String num;
        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        
        //Welcome and User Input
        System.out.println("Hello and welcome to the Sum of Digits in a string program!");
        System.out.print("To start please enter in a number: ");
        num = input.nextLine();
        
        //String Split
        String[] sArr = num.split("");
        
        //Getting Sum Value
        for(int i = 0; i < num.length(); i++){
            sum += Integer.parseInt(sArr[i]);
        }
        //Getting Highest and Lowest Values
        for(int c = 0; c < num.length(); c++){
            int temp = Integer.parseInt(sArr[c]);
            if(temp > highest){
                highest = temp;
            }
            
            if(temp < lowest){
                lowest = temp;
            }
        }
        
        //Print Results
        System.out.println("\nResults:");
        System.out.println("--------");
        System.out.println("Number you entered: " + num);
        System.out.println("Sum of numbers: " + sum);
        System.out.println("Highest Value: " + highest);
        System.out.println("Lowest Value: " + lowest);
        
    }
    
}
