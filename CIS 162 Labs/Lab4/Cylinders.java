import java.text.*;
import java.util.*;
public class Cylinders
{
    public static void cylinders(String[] args){
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
}
