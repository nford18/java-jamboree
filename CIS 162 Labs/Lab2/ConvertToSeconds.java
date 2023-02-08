import java.util.*;

public class ConvertToSeconds
{
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Hours: ");
        int numHours = scnr.nextInt();
        System.out.println(numHours);
        
        System.out.print("Minutes: ");
        int numMinutes = scnr.nextInt();
        System.out.println(numMinutes);
        
        System.out.print("Seconds: ");
        int numSeconds = scnr.nextInt();
        System.out.println(numSeconds);
        
        int hourSeconds = numHours * 3600;
        int minuteSeconds = numMinutes * 60;
        
        int totalSeconds = hourSeconds + minuteSeconds + numSeconds;
        System.out.print(totalSeconds + " seconds");
        scnr.close();
    }
}
