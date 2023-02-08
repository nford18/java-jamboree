import java.text.*;
import java.util.*;
public class Lab4{
    public static void main(String[] args){
        login();
        cylinders();
        triangle();
        pizzas();
        ranges();
    }

    public static void login(){
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

    public static void cylinders(){
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Radius: ");
        double radius = scnr.nextDouble();
        System.out.println(radius);
        
        System.out.print("Height: ");
        double height = scnr.nextDouble();
        System.out.println(height);
        
        double volume = Math.PI * Math.pow(radius, 2.0) * height;
        double area = 2 * Math.PI * radius * height;
        
        DecimalFormat df = new DecimalFormat ("0.0");
        System.out.println(df.format(volume));
        System.out.println(df.format(area));
        scnr.close();
    }

    public static void triangle(){
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Enter Side A: ");
        double sideA = scnr.nextDouble();
        System.out.println(sideA);
        
        System.out.print("Enter Side B: ");
        double sideB = scnr.nextDouble();
        System.out.println(sideB);
        
        System.out.print("Enter Side C: ");
        double sideC = scnr.nextDouble();
        System.out.println(sideC);
        
        double s = (sideA + sideB + sideC) / 2;
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(area));
        scnr.close();
    }

    public static void pizzas(){
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

    public static void ranges(){
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.print("Enter low: ");
        int numLow = scnr.nextInt();
        System.out.println(numLow);
        
        System.out.print("Enter high: ");
        int numHigh = scnr.nextInt();
        System.out.println(numHigh);
        
        System.out.println("Random values: ");
        int i = 1;
        while(i <= 3){
            int randNum = rand.nextInt(numHigh + 1 - numLow) + numLow;
            System.out.println(randNum);
            i += 1;
        }
        scnr.close();
    }

}
