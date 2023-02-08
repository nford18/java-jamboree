import java.text.*;
public class Car{
    private double mileage;
    private double gasTank;
    private String carModel;
    private boolean isEngineOn;
    final double MILES_PER_GALLON = 24.5;
    final int TANK_CAPACITY = 13;
    DecimalFormat df = new DecimalFormat("000.0");
    
    //car methods
    public Car(String model){
        mileage = 0.0;
        gasTank = (double)TANK_CAPACITY;
        carModel = model;
        isEngineOn = false;
    }
    public double checkOdometer(){
        return mileage;
    }
    public double checkGasGauge(){
        return gasTank;
    }
    public void honkHorn(){
        System.out.println("The " + carModel + " says Honk, Honk!");
    }
    public String toString(){
        String str = "The " + carModel + " has " + df.format(mileage) + " miles and " + df.format(gasTank) + " gallons of gas.";
        return str;
    }
    public void addGas(double g){
        if(engineOn() == true){
            System.out.println("Warning: The car is on, do not fill tank");
        }else{ 
            if(gasTank + g > TANK_CAPACITY){
                System.out.println("Warning: Entered gas parameter would overfill the tank.");
                gasTank = TANK_CAPACITY;
            }else{
                gasTank += g;
            }
            System.out.println("The " + carModel + "'s gas tank is now at " + gasTank + " gallons.");
        }
    }
    public void drive(double miles){
        if(engineOn() == false){
            System.out.println("Warning: The car is off, cannot drive");
        }else if(miles < 0){
            System.out.println("Warning: Entered miles was negative");
        }else if(miles/MILES_PER_GALLON > gasTank){
            double milesDriven = gasTank * MILES_PER_GALLON;
            gasTank = 0.0;
            mileage += milesDriven;
            System.out.println("The " + carModel + " drove " + milesDriven + " miles before it ran out of gas.");
            stopEngine();
        }else{
            mileage += miles;
            gasTank -= miles/MILES_PER_GALLON;
            System.out.println("The " + carModel + " drove " + miles + " miles, using " + (miles/MILES_PER_GALLON) + " gallons of gas.");
        }
    }
    //engine methods
    public boolean engineOn(){
        return isEngineOn;
    }
    public void startEngine(){
        isEngineOn = true;
        System.out.println("The " + carModel + " roars to life.");
    }
    public void stopEngine(){
        isEngineOn = false;
        System.out.println("The " + carModel + " goes silent.");
    }
    //challenge
    public void takeTrips(int num, int distance){
        int i = 1;
        startEngine();
        while(isEngineOn && i < num){
            drive((double)distance);
            i++;
        }
        stopEngine();
    }
    
    public static void main(String[] args){
        System.out.println("Part 1 Testing Begins-----");
        Car car1 = new Car("Hyundai Kona"); 
        Car car2 = new Car("Ford Explorer");
        double doubleApprox = 0.001;

        car1.startEngine();
        assert car1.checkOdometer() == 0.0 : "should be zero, car has not moved";
        assert car1.checkGasGauge() == 13.0 : "should be 13, car has not moved";
        car1.honkHorn();
        car1.drive(73.5);
        assert (car1.checkOdometer() >= 73.5 - doubleApprox && car1.checkOdometer() <= 73.5 + doubleApprox): "should be 73.5";
        assert (car1.checkGasGauge() >= 10.0 - doubleApprox && car1.checkGasGauge() <= 10.0 + doubleApprox): "should be 10.0";
        car1.toString();
        car1.stopEngine();
        car1.addGas(2.0);
        assert (car1.checkOdometer() >= 73.5 - doubleApprox && car1.checkOdometer() <= 73.5 + doubleApprox): "should be 73.5";
        assert (car1.checkGasGauge() >= 12.0 - doubleApprox && car1.checkGasGauge() <= 12.0 + doubleApprox): "should be 12.0";
        car1.toString();
        
        car2.startEngine();
        assert car2.checkOdometer() == 0.0 : "should be zero, car has not moved";
        assert car2.checkGasGauge() == 13.0 : "should be 13, car has not moved";
        car2.honkHorn();
        car2.drive(318.5);
        assert (car2.checkOdometer() >= 318.5 - doubleApprox && car2.checkOdometer() <= 318.5 + doubleApprox): "should be 318.5";
        assert (car2.checkGasGauge() >= 0.0 - doubleApprox && car2.checkGasGauge() <= 0.0 + doubleApprox): "should be 0.0";
        car2.toString();
        car2.stopEngine();
        car2.addGas(7.0);
        assert (car2.checkOdometer() >= 318.5 - doubleApprox && car2.checkOdometer() <= 318.5 + doubleApprox): "should be 318.5";
        assert (car2.checkGasGauge() >= 7.0 - doubleApprox && car2.checkGasGauge() <= 7.0 + doubleApprox): "should be 73.5";
        car2.toString();
        System.out.println("Part 1 Testing Ends-----");
        
        System.out.println("Enhancement Testing Begins-----");
        Car car3 = new Car("Mini Couper");
        
        assert car3.checkOdometer() == 0.0 : "should be zero, car has not moved";
        assert car3.checkGasGauge() == 13.0 : "should be 13, car has not moved";
        
        car3.honkHorn();
        car3.drive(24.5);
        car3.startEngine();
        car3.drive(-5);
        car3.drive(24.5);
        assert (car3.checkOdometer() >= 24.5 - doubleApprox && car3.checkOdometer() <= 24.5 + doubleApprox): "should be 24.5";
        assert (car3.checkGasGauge() >= 12.0 - doubleApprox && car3.checkGasGauge() <= 12.0 + doubleApprox): "should be 12.0";
        car3.toString();
        
        car3.addGas(1.0);
        car3.stopEngine();
        car3.addGas(2.0);
        assert (car3.checkOdometer() >= 24.5 - doubleApprox && car3.checkOdometer() <= 24.5 + doubleApprox): "should be 24.5";
        assert (car3.checkGasGauge() >= 13.0 - doubleApprox && car3.checkGasGauge() <= 13.0 + doubleApprox): "should be 13.0";
        car3.toString();
        
        Car car4 = new Car("Toyota Camry");
        
        assert car4.checkOdometer() == 0.0 : "should be zero, car has not moved";
        assert car4.checkGasGauge() == 13.0 : "should be 13, car has not moved";
        
        car4.takeTrips(5,5);
        assert (car4.checkOdometer() >= 20.0 - doubleApprox && car4.checkOdometer() <= 25.0 + doubleApprox): "should be 25.0";
        assert (car4.checkGasGauge() >= 12.183 - doubleApprox && car4.checkGasGauge() <= 12.183 + doubleApprox): "should be 12.183";
        
        System.out.println("Enhancement Testing Ends-----");
    }
}
