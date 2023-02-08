import java.util.*;
import java.io.*;
public class CovidDatabase{
    private ArrayList<CovidEntry> entries;
    private static final int SAFE = 5;
    //constructor
    public CovidDatabase(){
        entries = new ArrayList<CovidEntry>();
    }
    //mutators
    public void readCovidData(String filename){
        Scanner inFS = null;
        FileInputStream fileByteStream = null;
        try{

            // open the File and set delimiters
            fileByteStream = new FileInputStream(filename);
            inFS = new Scanner(fileByteStream);
            inFS.useDelimiter("[,\r\n]+");
            
            // continue while there is more data to read
            while(inFS.hasNext()) {
                String st = inFS.next();
                int m = inFS.nextInt();
                int d = inFS.nextInt();
                int dI = inFS.nextInt();
                int dD = inFS.nextInt();
                int tI = inFS.nextInt();
                int tD = inFS.nextInt();
                CovidEntry thisLine = new CovidEntry(st,m,d,dI,dD,tI,tD);
                entries.add(thisLine);
            }
                fileByteStream.close();
                // error while reading the file
        }catch(IOException error1) {
            System.out.println("Oops! Error related to: " + filename);
        }
    }
    
    //accessors
    public int countRecords(){
        return entries.size();
    }
    public int getTotalDeaths(){
        int totalDeaths = 0;
        for(int i=0; i<entries.size(); i++){
            totalDeaths += entries.get(i).getDailyDeaths();
        }
        return totalDeaths;
    }
    public int getTotalInfections(){
        int totalInfect = 0;
        for(int i=0; i<entries.size(); i++){
            totalInfect += entries.get(i).getDailyInfections();
        }
        return totalInfect;
    }
    public int countTotalDeaths(int m, int d){
        int numDeaths = 0;
        for(CovidEntry currLine: entries){
            if(currLine.getMonth()==m && currLine.getDay()==d){
                numDeaths += currLine.getDailyDeaths();
            }
        }
        return numDeaths;
    }
    public int countTotalInfections(int m, int d){
        int numInfect = 0;
        for(CovidEntry currLine: entries){
            if(currLine.getMonth()==m && currLine.getDay()==d){
                numInfect += currLine.getDailyInfections();
            }
        }
        return numInfect;
    }
    public CovidEntry peakDailyDeaths(String st){
        int mostDailyDeath = Integer.MIN_VALUE;
        CovidEntry reaperDay = null;
        
        for(CovidEntry currLine: entries){
            if(currLine.getState().equalsIgnoreCase(st) && currLine.getDailyDeaths() > mostDailyDeath){
                mostDailyDeath = currLine.getDailyDeaths();
                reaperDay = currLine;
                
            }
        }
        if(mostDailyDeath == Integer.MIN_VALUE){
            return null;
        }else{
            return reaperDay;
        }
    }
    public ArrayList<CovidEntry> getDailyDeaths(int m, int d){
        ArrayList<CovidEntry> dateDailyDeath = new ArrayList<CovidEntry>();
        for(CovidEntry currLine: entries){
            if(currLine.getMonth() == m && currLine.getDay() == d){
                dateDailyDeath.add(currLine);
            }
        }
        return dateDailyDeath;
    }
    public CovidEntry peakDailyDeaths(int m, int d){
        int mostDailyDeath = Integer.MIN_VALUE;
        CovidEntry reaperState = null;
        
        for(CovidEntry currLine: entries){
            if(currLine.getMonth() == m && currLine.getDay() == d && currLine.getDailyDeaths() > mostDailyDeath){
                mostDailyDeath = currLine.getDailyDeaths();
                reaperState = currLine;
                
            }
        }
        if(mostDailyDeath == Integer.MIN_VALUE){
            return null;
        }else{
            return reaperState;
        }
    }
    public CovidEntry mostTotalDeaths(){
        int mostTotalDeath = Integer.MIN_VALUE;
        CovidEntry highTotDeathEntry = entries.get(0);
        
        for(CovidEntry currLine: entries){
            if(currLine.getTotalDeaths() > mostTotalDeath){
                mostTotalDeath = currLine.getTotalDeaths();
                highTotDeathEntry = currLine;
            }
        }
        return highTotDeathEntry;
    }
    public ArrayList<CovidEntry> listMinimumDailyInfections(int m, int d, int min){
        ArrayList<CovidEntry> leastInfect = new ArrayList<CovidEntry>();
        for(CovidEntry currLine: entries){
            if(currLine.getMonth() == m && currLine.getDay() == d && currLine.getDailyInfections() > min){
                leastInfect.add(currLine);
            }
        }
        return leastInfect;
    }
    public ArrayList<CovidEntry> safeToOpen(String st){
        ArrayList<CovidEntry> descendSet = new ArrayList<CovidEntry>();
        int safetyCombo = 0;
        int numInfect = Integer.MAX_VALUE;
        for(CovidEntry currLine: entries){
            if(currLine.getState().equalsIgnoreCase(st)){
                numInfect = currLine.getDailyInfections();
                break;
            }
        }
        
        if(numInfect != Integer.MAX_VALUE){
            for(int i=0; i<entries.size() && descendSet.size()<SAFE; i++){
                if(entries.get(i).getState().equalsIgnoreCase(st)){
                    if(entries.get(i).getDailyInfections()<numInfect){
                        safetyCombo++;
                    }else{
                        safetyCombo = 1;
                        descendSet.clear();
                    }
                    descendSet.add(entries.get(i));
                    numInfect = entries.get(i).getDailyInfections();
                }
            }
            if(descendSet.size() == SAFE){
                return descendSet;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    public ArrayList<CovidEntry> topTenDeaths(int m, int d){
        ArrayList<CovidEntry> forTopTen = getDailyDeaths(m,d);
        Collections.sort(forTopTen);
        for(int i = forTopTen.size() -1; i>9; i--){
            forTopTen.remove(i);
        }
        return forTopTen;
    }
    
}
