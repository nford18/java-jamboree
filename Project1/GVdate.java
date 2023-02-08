/* 
 * I pledge that this work is entirely mine, and mine alone (except for any
 * code provided by my instructor). __Nicholas_Ford__
 * I did not help nor receive help from others.
 */
import java.text.*;
public class GVdate{
    private int month;
    private int day;
    private int year;
    private final int BIRTH_MONTH = 5;
    private final int BIRTH_DAY = 18;
    private final int DEFAULT_MONTH = 10;
    private final int DEFAULT_DAY = 12;
    private final int DEFAULT_YEAR = 2020;

    public GVdate(){
        month = DEFAULT_MONTH;
        day = DEFAULT_DAY;
        year = DEFAULT_YEAR;
    }

    public GVdate(int m, int d, int y){
        if(isDateValid(m, d, y) == true){
            month = m;
            day = d;
            year = y;
        }else{
            System.out.println("Error - Invalid Date");
            System.out.println("Setting Date to Default.");
            month = DEFAULT_MONTH;
            day = DEFAULT_DAY;
            year = DEFAULT_YEAR;
        }
    }

    public GVdate(String date){
        int firstSlash = date.indexOf("/");
        int secondSlash = date.indexOf("/", firstSlash +1);

        int m = Integer.parseInt(date.substring(0,firstSlash));
        int d = Integer.parseInt(date.substring(firstSlash + 1, secondSlash));
        int y = Integer.parseInt(date.substring(secondSlash + 1));
        if(isDateValid(m,d,y) == true){
            month = m;
            day = d;
            year = y;
        }else{
            System.out.println("Error - Invalid Date");
            System.out.println("Setting Date to Default.");
            month = DEFAULT_MONTH;
            day = DEFAULT_DAY;
            year = DEFAULT_YEAR;
        }
    }

    //accessor methods
    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    public String toString(){
        String str1 = Integer.toString(month);
        String str2 = Integer.toString(day);
        String str3 = Integer.toString(year);

        String dateString = str1 + "/" + str2 + "/" + str3;
        return dateString;
    }

    public String toString(int format){
        String str1 = Integer.toString(month);
        String str2 = Integer.toString(day);
        String str3 = Integer.toString(year);
        String shortMonth = "JanFebMarAprMayJunJulAugSepOctNovDec";
        String dateString;
        switch(format){
            default:
            case 1:
                dateString = str1 + "/" + str2 + "/" + str3;
                break;
            case 2:
                DecimalFormat df = new DecimalFormat("00");
                df.format(month);
                df.format(day);
                dateString = df.format(month) + "/" + df.format(day) + "/" + str3;
                break;                
            case 3:
                int str1Start = 3 * (month - 1);
                str1 = shortMonth.substring(str1Start, str1Start + 3);
                dateString = str1 + " " + str2 + ", " + str3;
                break;
            case 4:
            switch(month){
                case 1:
                    str1 = "January";
                    break;
                case 2:
                    str1 = "February";
                    break;
                case 3:
                    str1 = "March";
                    break;
                case 4:
                    str1 = "April";
                    break;
                case 5:
                    str1 = "May";
                    break;
                case 6:
                    str1 = "June";
                    break;
                case 7:
                    str1 = "July";
                    break;
                case 8:
                    str1 = "August";
                    break;
                case 9:
                    str1 = "September";
                    break;
                case 10:
                    str1 = "October";
                    break;
                case 11:
                    str1 = "November";
                    break;
                case 12:
                    str1 = "December";
                    break;
            }
            dateString = str1 + " " + str2 + ", " + str3;
        }

        return dateString;
    }

    public boolean isMyBirthday(){
        if((month == BIRTH_MONTH)&&(day == BIRTH_DAY)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isLeapYear(int y){
        if(y % 400 == 0){
            return true;
        }else if(y % 100 == 0){
            return false;
        }else if(y % 4 == 0){
            return true;
        }else{
            return false;
        }
    }

    public int getLastDayOfMonth(int m, int y){
        int lastDay = 0;
        switch(m){
            case 4:
            case 6:
            case 9:
            case 11:
                lastDay = 30;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                lastDay = 31;
                break;
            case 2:
            if(isLeapYear(y) == true){
                lastDay = 29;
            }else{
                lastDay = 28;
            }
            break;
        }
        return lastDay;
    }

    public boolean isDateValid(int m, int d, int y){
        if(y > 0){
            if((m > 0)&&(m <= 12)){
                if((d > 0)&&(d <= getLastDayOfMonth(m,y))){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean equals(GVdate otherDate){
        if(otherDate.getDay() == day){
            if(otherDate.getMonth() == month){
                if(otherDate.getYear() == year){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    //mutator methods
    public void setMonth(int m){
        if(isDateValid(m, day, year) == true){
            month = m;
        }else{
            System.out.println("Error - Invalid Month");
        }
    }

    public void setDay(int d){
        if(isDateValid(month, d, year) == true){
            day = d;
        }else{
            System.out.println("Error - Invalid Day");
            //month = 10;
            //day = 12;
            //year = 2012;
        }
    }

    public void setYear(int y){
        if(isDateValid(month, day, y) == true){
            year = y;
        }else{
            System.out.println("Error - Invalid Year");
        }
    }

    public void setDate(int m, int d, int y){
        if(isDateValid(m, d, y) == true){
            month = m;
            day = d;
            year = y;
        }else{
            System.out.println("Error - Invalid Date");
        }
    }

    public void nextDay(){
        if(day == getLastDayOfMonth(month, year)){
            if(month == 12){
                year++;
                month = 1;
            }else{
                month++;
            }
            day = 1;
        }else{ 
            day++;
        }
    }
    
    public void skipAhead(int numDays){
        int i = 0;
        if(numDays > 0){
            while(i < numDays){
                nextDay();
                i++;
            }
        }
    }
        
}