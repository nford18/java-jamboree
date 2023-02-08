
public class SimpleTime{
    private int hours;
    private int minutes;
    private int seconds;
    
    public SimpleTime(){
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    public SimpleTime(int h, int m, int s){
        hours = h;
        minutes = m;
        seconds = s;
    }
    
    public boolean isMidnight(){
        if((hours == 0)&&(minutes == 0)&&(seconds == 0)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isNoon(){
        if((hours == 12)&&(minutes == 0)&&(seconds == 0)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isLunchTime(){
        if(hours == 12){
            return true;
        }else{
            return false;
        }
    }
    public String toString(){
       String time1 = Integer.toString(hours) + ":";
       String time2;
       String time3;
       if(minutes < 10){
           time2 = "0" + Integer.toString(minutes) + ":";
       }else{
           time2 = Integer.toString(minutes) + ":";
       }
       if(seconds < 10){
           time3 = "0" + Integer.toString(seconds);
       }else{
           time3 = Integer.toString(seconds);
       }
       String timeString = time1 + time2 + time3;
       return timeString;
    }
    public void increment(){
        if(seconds == 59){
            if(minutes == 59){
                hours++;
                minutes = 0;
                seconds = 0;
            }else{
                minutes++;
                seconds = 0;
            }
        }else{ 
            seconds++;
        }
    }
    
    public static void main(){
        SimpleTime userTime = new SimpleTime(0,59,55);
        System.out.println(userTime.toString());
        System.out.print("It is ");
        if(userTime.isMidnight()==false){
            System.out.print("not ");
        }
        System.out.println("midnight");
        if(userTime.isNoon()==false){
            System.out.print("not ");
        }
        System.out.println("noon");
        if(userTime.isLunchTime()==false){
            System.out.print("not ");
        }
        System.out.println("lunch time");
        int i = 0;
        while(i < 5){
            userTime.increment();
            i++;
        }
        System.out.println(userTime.toString());
    }
}
