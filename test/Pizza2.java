import java.util.*;

public class Pizza2 {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      System.out.print("People: ");
      int numPeople = scnr.nextInt(); 
      System.out.println(numPeople);
      
      int numSlices = 2 * numPeople;
      int numPizzas;
      numPizzas = (numSlices / 12);

      System.out.println("Pizzas: " + numPizzas);
      
      double costDollars = numPizzas * 14.95;
      System.out.print("Cost: " + costDollars);
      
      scnr.close();
   }
}