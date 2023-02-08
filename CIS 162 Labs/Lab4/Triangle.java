import java.text.*;
import java.util.*;
public class Triangle
{
    public static void triangle(String[] args){
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
}
