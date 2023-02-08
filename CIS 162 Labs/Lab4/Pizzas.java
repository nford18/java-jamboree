import java.text.*;
import java.util.*;
public class Pizzas
{
    public static void pizzas(String[] args){
        Scanner scnr = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        
        System.out.print("How many pizzas? ");
        int numPizzas = scnr.nextInt();
        System.out.println();
        
        double subTotal = 9.99 * numPizzas;
        double total = subTotal * 1.06;
        
        System.out.println("Sub Total: " + nf.format(subTotal));
        System.out.println("Total Due: " + nf.format(total));
        scnr.close();
    }
}
