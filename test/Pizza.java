import java.util.*;

public class Pizza {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int numPeople = scnr.nextInt();
      System.out.println("People: " + numPeople);
      
      int numSlices = 2 * numPeople;
      int numPizzas;
         if(numSlices % 12 == 0){
            numPizzas = (numSlices / 12);
        }   else{
            numPizzas = (numSlices / 12) +1;
         }
      System.out.println("Pizzas: " + numPizzas);
      
      double costDollars = numPizzas * 14.95;
      System.out.print("Cost: $" + costDollars);
      scnr.close();
      
   }
}