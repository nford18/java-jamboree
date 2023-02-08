import java.util.*;

public class MadLib
{
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Adjective: ");
        String adj1 = scnr.next();
        System.out.println(adj1);
        
        System.out.print("Place: ");
        String place1 = scnr.next();
        System.out.println(place1);
        
        System.out.print("Color: ");
        String color1 = scnr.next();
        System.out.println(color1);
        
        System.out.print("Type of Liquid: ");
        String liquid1 = scnr.next();
        System.out.println(liquid1);
        
        System.out.print("Type of Food: ");
        String food1 = scnr.next();
        System.out.println(food1);
        
        System.out.print("Different Type of Food: ");
        String food2 = scnr.next();
        System.out.println(food2);
        
        System.out.print("It's been a " + adj1 + " winter here in " + place1 +
        ". For as long as we can remember, the sky has been " + color1 +
        " and the ground has been covered with " + liquid1 + 
        ". We have all been surviving on a steady diet of " + food1 
        + " and " + food2 + ".");
        scnr.close();
    }
}
