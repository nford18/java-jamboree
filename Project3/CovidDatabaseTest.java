public class CovidDatabaseTest{
    public static void main(String[] args){
        System.out.println ("---Testing starts---");
        CovidDatabase db = new CovidDatabase() ;
        db.readCovidData("covid_test_data.csv");
        // check number of records, total infections, and total deaths
        assert db.countRecords() == 28 : "database should have 20";
        assert db.getTotalDeaths() == 43 : "Total deaths should be: 34";
        assert db.getTotalInfections() == 1112 : "infections should be: 1072";
        // check count total deaths
        assert db.countTotalDeaths(3,5) == 5 : "Total deaths on 3/5 is 5";
        assert db.countTotalDeaths(3,12) == 4 : "Total deaths on 3/12 is 4";
        // check count total infections
        assert db.countTotalInfections(3,5) == 61 : "Total infections on 3/5 is 5";
        assert db.countTotalInfections(3,12) == 182 : "Total infections on 3/12 is 182";
        // check peak daily deaths w/ date
        CovidEntry mostDeaths = db.peakDailyDeaths(3,9);
        assert mostDeaths.getState().equals("NF") : "State with most deaths for 3/9 is NF";
        assert mostDeaths.getDailyDeaths() == 4 : "Deaths for 3/9 is NF: 4";
        mostDeaths = db.peakDailyDeaths(3,4);
        assert mostDeaths.getState().equals("NF") : "State with most deaths for 3/4 is NF";
        assert mostDeaths.getDailyDeaths() == 2 : "Deaths for 3/4 is NF: 2";
        // check peak daily deaths w/ state
        CovidEntry moreDeaths = db.peakDailyDeaths("NF");
        assert moreDeaths.getMonth() == 3 : "Month with most deaths for NF is 3";
        assert moreDeaths.getDay() == 6 : "Day with most deaths for NF is 6";
        assert moreDeaths.getDailyDeaths() == 6 : "Deaths for 3/6 is NF: 6";
        moreDeaths = db.peakDailyDeaths("AW");
        assert moreDeaths.getMonth() == 3 : "Month with most deaths for NF is 3";
        assert moreDeaths.getDay() == 5 : "Day with most deaths for NF is 5";
        assert moreDeaths.getDailyDeaths() == 1 : "Deaths for 3/5 is NF: 1";
        // check get daily deaths
        assert db.getDailyDeaths(3,9).size() == 2 :"Should only be two elements";
        assert db.getDailyDeaths(3,9).get(0).getDay() == 9 :"day should be 9";
        assert db.getDailyDeaths(3,9).get(1).getDay() == 9 :"day should be 9";
        assert db.getDailyDeaths(3,1).size() == 0 :"Should not be any entries";
        // check most total deaths
        CovidEntry totDeaths = db.mostTotalDeaths();
        assert totDeaths.getMonth() == 3 : "Month with most deaths for NF is 3";
        assert totDeaths.getDay() == 13 : "Day with most deaths for NF is 13";
        assert totDeaths.getTotalDeaths() == 33 : "Deaths for 3/13 is NF: 33";
        // check list min daily infect
        assert db.listMinimumDailyInfections(3,10,100).size() == 1 : "Should only have 1 element";
        assert db.listMinimumDailyInfections(3,10,100).get(0).getDailyInfections() == 110 : "Entry should have 110 daily infections";
        assert db.listMinimumDailyInfections(3,10,100).get(0).getState().equalsIgnoreCase("NF") : "Should be the state NF";
        
        assert db.listMinimumDailyInfections(3,10,1).size() == 2 : "Should only have 2 elements";
        assert db.listMinimumDailyInfections(3,10,1).get(0).getDailyInfections() == 5 : "Entry should have 5 daily infections";
        assert db.listMinimumDailyInfections(3,10,1).get(0).getState().equalsIgnoreCase("AW") : "Should be the state AW";
        assert db.listMinimumDailyInfections(3,10,1).get(1).getDailyInfections() == 110 : "Entry should have 110 daily infections";
        assert db.listMinimumDailyInfections(3,10,1).get(1).getState().equalsIgnoreCase("NF") : "Should be the state NF";
        
        assert db.listMinimumDailyInfections(3,10,150).size() == 0 : "Should have 0 elements";
        assert db.listMinimumDailyInfections(3,1,1).size() == 0 : "Should have 0 elements";
        
        // check safe to open
        assert db.safeToOpen("AW").size() == 5 : "should be 5 elements";
        assert db.safeToOpen("AW").get(0).getMonth() == 3 : "Should start with 3";
        assert db.safeToOpen("AW").get(0).getDay() == 5 : "Should start with 5";
        assert db.safeToOpen("AW").get(4).getMonth() == 3 : "Should start with 3";
        assert db.safeToOpen("AW").get(4).getDay() == 9 : "Should start with 9";
        assert db.safeToOpen("NF") == null : "should not be elements";
        // check top ten deaths
        assert db.topTenDeaths(3,5).size() == 2 : "should be 2 elements";
        assert db.topTenDeaths(3,5).get(0).getDailyDeaths() == 4 : "should be 4 deaths";
        assert db.topTenDeaths(3,5).get(0).getState().equalsIgnoreCase("NF") : "should be NF state";
        assert db.topTenDeaths(3,5).get(1).getDailyDeaths() == 1 : "should be 4 deaths";
        assert db.topTenDeaths(3,13).get(9).getState().equalsIgnoreCase("AW") : "should be AW state";
        assert db.topTenDeaths(3,13).size() == 10 : "should be 10 elements";
        assert db.topTenDeaths(3,13).get(0).getDailyDeaths() == 3 : "should be 3 deaths";
        assert db.topTenDeaths(3,13).get(0).getState().equalsIgnoreCase("NF") : "should be NF state";
        assert db.topTenDeaths(3,13).get(1).getDailyDeaths() == 2 : "should be 2 deaths";
        assert db.topTenDeaths(3,13).get(1).getState().equalsIgnoreCase("AB") : "should be AB state";
        assert db.topTenDeaths(3,13).get(9).getDailyDeaths() == 0 : "should be 0 deaths";
        assert db.topTenDeaths(3,13).get(9).getState().equalsIgnoreCase("AW") : "should be AW state";
        
        System.out.println ("---Testing ends---");
    }
}
