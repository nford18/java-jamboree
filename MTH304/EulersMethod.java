import java.util.*;

public class EulersMethod
{
    public double f(double t, double y){
      
      //replace "2*t" with the function of derivative
      double fValue = 2*t;
      
      return fValue;
    }
    public static void algorithm(String[] args){
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("\n" + "t_0: ");
        double t = scnr.nextDouble();
        System.out.println(t);
        
        System.out.print("y_0: ");
        double y = scnr.nextDouble();
        System.out.println(y);
        
        System.out.print("t Endpoint: ");
        double endpoint = scnr.nextDouble();
        System.out.println(endpoint);
        
        System.out.print("Intervals: ");
        double intervals = scnr.nextInt();
        System.out.println(intervals);
        
        double deltaT = (endpoint - t)/intervals;
            int i = 0;
        EulersMethod deriv = new EulersMethod();
        
        while (i <= intervals){
            deriv.f(t,y);
            /*replace "t * y" with the needed derivative function using
             * the variables t as the independent var and y as the dependent
             * variable.
             */
            double m = deriv.f(t,y);//t * y;
            double y_1 = m * deltaT + y;
            
            System.out.println(y_1);
            
            y = y_1;
            t += deltaT;
            
            i += 1;
        }    
        scnr.close();
    }
}