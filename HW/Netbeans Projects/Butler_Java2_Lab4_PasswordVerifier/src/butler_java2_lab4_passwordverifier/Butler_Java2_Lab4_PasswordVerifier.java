package butler_java2_lab4_passwordverifier;
import java.util.Scanner;
public class Butler_Java2_Lab4_PasswordVerifier {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        String pass;
        
        System.out.println("Hello and Welcome to the Password Verifier Program!");
        System.out.print("To start, Please enter a password that contains alteast one digit, uppercase letter, lowercase letter and is atleast 6 characters long: ");
        pass = input.next();
        
        if(pass.length() < 6){
            System.out.print("Password was invalid!");
        }
        else{
            for(int i = 0; i < pass.length(); i++){
                if(Character.isUpperCase(pass.charAt(i))){
                    hasUpperCase = true;
                }
                else if(Character.isLowerCase(pass.charAt(i))){
                    hasLowerCase = true;
                }
                else if(Character.isDigit(pass.charAt(i))){
                    hasDigit = true;
                }
            }

            if(hasUpperCase && hasLowerCase && hasDigit){
                System.out.print("Password was valid!");
            }
            else{
                System.out.print("Password was invalid!");
            }
        }
    }
    
}
