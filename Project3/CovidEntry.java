import java.text.DecimalFormat;
public class CovidEntry {
    private String state;
    private int month;
    private int day;
    private int dailyDeath;
    private int dailyInfect;
    private int totalDeath;
    private int totalInfect;
    
    //constructor
    public CovidEntry(String st, int m, int d, int di, int dd, int ti, int td){
        state = st;
        month = m;
        day = d;
        dailyInfect = di;
        dailyDeath = dd;
        totalInfect = ti;
        totalDeath = td;
    }
    
    //accessor
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public String getState(){
        return state;
    }
    public int getDailyInfections(){
        return dailyInfect;
    }
    public int getDailyDeaths(){
        return dailyDeath;
    }
    public int getTotalInfections(){
        return totalInfect;
    }
    public int getTotalDeaths(){
        return totalDeath;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("00,000");
        return ""+ state +" "+ month +"/"+ day +" "+ df.format(getDailyInfections()) +" infections, "+ df.format(getDailyDeaths()) + " deaths"; 
    }
    
    public int compareTo(Object other){
        CovidEntry c = (CovidEntry) other;
        return c.dailyDeath - dailyDeath;
    }
}
