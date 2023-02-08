import java.util.*;

public class ConvertToDollars
{
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Quarters: ");
        int numQuarters = scnr.nextInt();
        System.out.println(numQuarters);
        
        System.out.print("Dimes: ");
        int numDimes = scnr.nextInt();
        System.out.println(numDimes);
        
        System.out.print("Nickels: ");
        int numNickels = scnr.nextInt();
        System.out.println(numNickels);
        
        System.out.print("Pennies: ");
        int numPennies = scnr.nextInt();
        System.out.println(numPennies);
        
        int totalCents = (25 * numQuarters) + (10 * numDimes) + 
        (5 * numNickels) + (numPennies);
        double totalDollars = totalCents / 100.0;
        
        System.out.print("Dollars: $" + totalDollars);
        scnr.close();
    }
}
