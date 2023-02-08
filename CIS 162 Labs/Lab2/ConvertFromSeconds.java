import java.util.*;

public class ConvertFromSeconds
{
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Seconds: ");
        int numSeconds = scnr.nextInt();
        System.out.println(numSeconds);
        
        int hours = numSeconds / 3600;
        numSeconds = numSeconds % 3600;
        
        int minutes = numSeconds / 60;
        numSeconds = numSeconds % 60;
        
        System.out.println("Hours: " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.print("Seconds: " + numSeconds);
        scnr.close();
    }
}
