import java.util.*;
public class RandomRanges{
    public static void ranges(String[] args){
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