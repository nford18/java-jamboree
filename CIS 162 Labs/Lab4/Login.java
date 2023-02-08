import java.util.*;
public class Login
{
    public static void login(String[] args){
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Enter first name: ");
        String firstName = scnr.next();
        System.out.println(firstName);
        
        System.out.print("Enter last name: ");
        String lastName = scnr.next();
        System.out.println(lastName);
        
        System.out.print("Enter 4-digits: ");
        int userNum = scnr.nextInt();
        System.out.println(userNum);
        
        System.out.print("Your login name: ");
        System.out.print(lastName.substring(0,5) + firstName.substring(0,1));
        System.out.println(userNum % 100);
        scnr.close();
    }
}
