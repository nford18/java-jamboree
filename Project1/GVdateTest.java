public class GVdateTest
{
    
    public static void main (String [] args) {
        System.out.println ("---Testing begins---");
        //********** phase 1 testing ************
        // testing the default constructor
        GVdate today = new GVdate();
        assert today.getMonth() == 10 : "month should be 10";
        assert today.getDay() == 12 : "day should be 12";
        assert today.getYear() == 2020 : "year should be 2020";
        // testing constructor 2
        GVdate theDay = new GVdate(1, 10, 1995);
        assert theDay.getMonth() == 1 : "month should be 1";
        assert theDay.getDay() == 10 : "day should be 10";
        assert theDay.getYear() == 1995 : "year should be 1995";
        GVdate newTheDay = new GVdate(11,31,2001);
        assert newTheDay.getMonth() == 10 : "month should be 10";
        assert newTheDay.getDay() == 12 : "day should be 12";
        assert newTheDay.getYear() == 2020 : "year should be 2001";
        // testing constructor 3
        GVdate thisDay = new GVdate("10/02/2020");
        assert thisDay.getMonth() == 10 : "month should be 10";
        assert thisDay.getDay() == 2 : "day should be 2";
        assert thisDay.getYear() == 2020 : "year should be 2020";
        GVdate newThisDay = new GVdate("11/31/2001");
        assert newThisDay.getMonth() == 10 : "month should be 10";
        assert newThisDay.getDay() == 12 : "day should be 12";
        assert newThisDay.getYear() == 2020 : "year should be 2001";
        // testing setter methods
        //setMonth
        today.setMonth(9);
        assert today.getMonth() == 9 : "month should be 9";
        today.setMonth(0);
        assert today.getMonth() == 9 : "month should still be 9";
        today.setMonth(13);
        assert today.getMonth() == 9 : "month should still be 9";
        today.setDate(5,31,2020);
        today.setMonth(6);
        assert today.getMonth() == 5 : "month should still be 5";
        today.setMonth(2);
        assert today.getMonth() == 5 : "month should still be 5";
        
        //setDay
        today.setDate(10,12,2020);
        today.setDay(31);
        assert today.getDay() == 31 : "day should be 31";
        today.setDay(0);
        assert today.getDay() == 31 : "day should still be 31";
        today.setDay(32);
        assert today.getDay() == 31 : "day should still be 31";
        
        //setYear
        today.setYear(2001);
        assert today.getYear() == 2001 : "year should be 2001";
        today.setYear(0);
        assert today.getYear() == 2001 : "year should be 2001";
        today.setYear(-2001);
        assert today.getYear() == 2001 : "year should be 2001";
        
        //setDate
        thisDay.setDate(2,29,2000);
        assert thisDay.getMonth() == 2 : "month should be 2";
        assert thisDay.getDay() == 29 : "day should be 29";
        assert thisDay.getYear() == 2000 : "year should be 2000";
        thisDay.setDate(10,32,2000);
        assert thisDay.getMonth() == 2 : "month should be 2";
        assert thisDay.getDay() == 29 : "day should be 29";
        assert thisDay.getYear() == 2000 : "year should be 2000";
        
        //testing getLastDayOfMonth
        assert today.getLastDayOfMonth(9,2001) == 30 : "last day should be 30";
        assert today.getLastDayOfMonth(10,2001) == 31 : "last day should be 31";
        assert today.getLastDayOfMonth(2,2001) == 28 : "last day should be 28";
        assert today.getLastDayOfMonth(2,2000) == 29 : "last day should be 29";
        //testing IsDateValid method
        GVdate checker = new GVdate(10,12,2020);
        assert checker.isDateValid(9,15,2000) == true : "should be true";
        assert checker.isDateValid(9,15,0) == false : "should be false";
        assert checker.isDateValid(9,15,-2000) == false : "should be false";
        assert checker.isDateValid(2,29,2001) == false : "should be false";
        assert checker.isDateValid(2,29,2000) == true : "should be true";
        assert checker.isDateValid(13,15,2000) == false : "should be false";
        assert checker.isDateValid(0,15,2000) == false : "should be false";
        assert checker.isDateValid(9,31,2000) == false : "should be false";
        assert checker.isDateValid(9,0,2000) == false : "should be false";
        assert checker.isDateValid(10,32,2000) == false : "should be false";
        //testing getLastDayOfMonth method
        assert checker.getLastDayOfMonth(2,2000) == 29 : "should be 29";
        assert checker.getLastDayOfMonth(3,2020) == 31 : "should be 31";
        assert checker.getLastDayOfMonth(4,2020) == 30 : "should be 30";
        //testing isLeapYear()
        assert checker.isLeapYear(2021) == false : "should be false";
        assert checker.isLeapYear(1600) == true : "should be true";
        //testing toString() and toString(format)
        checker.setDate(2,9,2020);
        assert checker.toString().equals("2/9/2020") : "should be 2/9/2020";
        assert checker.toString(1).equals("2/9/2020") : "should be 2/9/2020";
        assert (checker.toString(2)).equals("02/09/2020") : "should be 02/09/2020";
        assert (checker.toString(3)).equals("Feb 9, 2020") : "should be Feb 9, 2020";
        assert (checker.toString(4)).equals("February 9, 2020") : "should be February 9, 2020";
        assert (checker.toString(5)).equals("2/9/2020") : "should be 2/9/2020";
        
        //testing phase 3 
        //testing nextDay and skipAhead
        GVdate brandNewDay = new GVdate(10,26,2020);
        brandNewDay.nextDay();
        assert brandNewDay.getDay() == 27 : "should be 27";
        brandNewDay.skipAhead(3);
        assert brandNewDay.getDay() == 30 : "should be 30";
        brandNewDay.skipAhead(3);
        assert brandNewDay.getDay() == 2 : "should be 2";
        brandNewDay.setDate(12,31,2020);
        brandNewDay.skipAhead(3);
        assert brandNewDay.toString().equals("1/3/2021") : "should be 1/3/2021";
        brandNewDay.skipAhead(-2);
        assert brandNewDay.toString().equals("1/3/2021") : "should be 1/3/2021";
        GVdate leapDayTest1 = new GVdate(2,28,2020);
        leapDayTest1.skipAhead(2);
        assert leapDayTest1.toString().equals("3/1/2020") : "should be 3/1/2020";
        GVdate leapDayTest2 = new GVdate(2,28,2021);
        leapDayTest2.skipAhead(2);
        assert leapDayTest2.toString().equals("3/2/2021") : "should be 3/2/2021";
        
        //testing equals method
        today.setDate(10,12,2020);
        thisDay.setDate(10,12,2020);
        assert today.equals(thisDay) == true : "should be true";
        thisDay.setDate(1,12,2020);
        assert today.equals(thisDay) == false : "should be false";
        thisDay.setDate(10,1,2020);
        assert today.equals(thisDay) == false : "should be false";
        thisDay.setDate(10,12,2021);
        assert today.equals(thisDay) == false : "should be false";
        thisDay.setDate(5,25,2019);
        assert today.equals(thisDay) == false : "should be false";
        
        System.out.println("\n==================");
        GVdate todayTest = new GVdate(10,12,2020);
        System.out.println("Today: " + todayTest.toString(1));
        GVdate tomorrowTest = new GVdate(10,13,2020);
        System.out.println("Tomorrow: " + tomorrowTest.toString(1));
        GVdate nextDayTest = new GVdate(10,14,2020);
        System.out.println("The Next Day: " + nextDayTest.toString(1));
        GVdate muchLaterTest = new GVdate(12,1,2020);
        System.out.println("50 Days Later: " + muchLaterTest.toString(1) + "\n");
        System.out.println("\nTesting leap year");
        System.out.println("==================");
        System.out.println("Is 1900 a leap year?: " + todayTest.isLeapYear(1900));
        System.out.println("Is 2000 a leap year?: " + todayTest.isLeapYear(2000));
        System.out.println("\nTesting my Birthday");
        System.out.println("==================");
        System.out.println("Is 10/13/2020 my birthday?: " + tomorrowTest.isMyBirthday());
        System.out.println("\nTesting equals");
        System.out.println("==================");
        System.out.println("Is 10/14/2020 equal to 12/25/2020?: " + nextDayTest.equals(muchLaterTest));
        System.out.println("Is 10/14/2020 equal to 10/14/2020?: " + nextDayTest.equals(nextDayTest));
        System.out.println("\nTesting printing date formats");
        System.out.println("==================");
        System.out.println("Format 1: " + muchLaterTest.toString(1));
        System.out.println("Format 2: " + muchLaterTest.toString(2));
        System.out.println("Format 3: " + muchLaterTest.toString(3));
        System.out.println("Format 4: " + muchLaterTest.toString(4));
        System.out.println("==================");
        
        System.out.println("---Testing ends---");
        
        GVdate hehe = new GVdate(10,27,2020);
        hehe.skipAhead(76);
        System.out.println(hehe.toString(4));
    }
}
