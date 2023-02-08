import java.util.*;
public class Email
{
    public static void main(String[] args){
       Scanner scnr = new Scanner(System.in);
       String email = new String();
       System.out.println("What is your email:");
       email = scnr.next();

       System.out.println("Username is: " + email.substring(0, email.indexOf("@")));
       System.out.println("Domain is: " + email.substring(email.indexOf("@")+1, email.length()));
       scnr.close();
    }
}
