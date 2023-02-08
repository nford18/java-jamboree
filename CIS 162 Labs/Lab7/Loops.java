import java.util.*;
import javax.swing.JOptionPane;
public class Loops{
    Scanner scnr = new Scanner(System.in);
    
    public void average(){
        int userNum = 0;
        int sum = 0;
        int numNumbers = 0;
        
        System.out.println("Input first number: ");
        userNum = scnr.nextInt();
        while(userNum > 0){
            sum += userNum;
            numNumbers++;
            System.out.println("Next number: ");
            userNum = scnr.nextInt();
        }
        System.out.println(sum/numNumbers);
    }
    
    public void infinite(){
        int A = 0;
        while(true){
            System.out.println(A + " bottles of milk on the wall");
            A++;
        }
    }
    
    public void sum(int low, int high){
        int sum = 0;
        for(int i = low; i <= high; ++i){
            sum += i;
        }
        JOptionPane.showMessageDialog(null,"The sum is: " + sum);
    }
    
    public void countdown(int high, int low){
        for(int i = high; i >= low; --i){
            System.out.println(i);
        }
    }
    
    public int countMultiples(int low, int high, int digit){
        int numMultiples = 0;
        for(int i = low; i <= high; ++i){
            if(i % digit == 0){
                numMultiples++;
            }
        }
        return numMultiples;
    }
}
