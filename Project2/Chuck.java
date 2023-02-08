/*
 * Author - Nicholas Ford
 * I pledge that this work is entirely mine, and mine alone (except for any
 * code provided by my instructor). 
 * 
 * I helped Luke Olsen understand one of the instructions. I did not receive
 * any help other than from my instructor.
 */
public class Chuck{
    private int credits = 0;
    private String message = "";
    GVdie[] diceBlock = new GVdie[3];
    boolean[] betList = new boolean[9];
    
    //constructors
    public Chuck(){
        credits = 10;
        for(int i=0; i<diceBlock.length; ++i){
            diceBlock[i] = new GVdie();
        }
        for(int i=0; i<betList.length; ++i){
            betList[i] = false;
        }
        for(int i=0; i<diceBlock.length; ++i){
            diceBlock[i].setBlank();
        }
    }
    
    //helper methods
    private int getSumDiceValues(){
        int sum = 0;
        for(int i=0; i<diceBlock.length; ++i){
            sum += diceBlock[i].getValue();
        }
        return sum;
    }
    private boolean isDoubles(int num){
        boolean doubles = false;
        int matchNumCount = 0;
        for(int i=0; i<diceBlock.length; ++i){
            if(diceBlock[i].getValue()==num){
                matchNumCount++;
            }
        }
        if(matchNumCount == 2){
            doubles = true;
        }
        return doubles;
    }
    private boolean isTriplets(){
        boolean triplets = false;
        if(diceBlock[0].getValue()==diceBlock[1].getValue() && diceBlock[0].getValue()==diceBlock[2].getValue()){
            triplets = true;
        }
        return triplets;
    }
    private void checkLarge(){
        if(getSumDiceValues()>10 && !isTriplets()){
            addCredits(2);
            message = "Congrats, You Won!";
        }
    }
    private void checkSmall(){
        if(getSumDiceValues()<11 && !isTriplets()){
            addCredits(2);
            message = "Congrats, You Won!";
        }
    }
    private void checkField(){
        if(getSumDiceValues()<8 ||getSumDiceValues()>12){
            addCredits(2);
            message = "Congrats, You Won!";
        }
    }
    private void checkNumber(int num){
        if(diceBlock[0].getValue() == num && isTriplets()){
            addCredits(11);
            message = "Congrats, You Won!";
        }else if(isDoubles(num)){
            addCredits(3);
            message = "Congrats, You Won!";
        }else if(diceBlock[0].getValue() == num || diceBlock[1].getValue() == num || diceBlock[2].getValue() == num){ 
            addCredits(2);
            message = "Congrats, You Won!";
        }
    }  
    
    private void checkAllBets(){
        message = "Too Bad, Try Again!";
        for(int i=0; i<betList.length; ++i){
            if(i<=5){
                if(betList[i]){
                    --credits;
                    checkNumber(i+1);
                }
            }
            if(i==6){
                if(betList[i]){
                    --credits;
                    checkField();
                }
            }
            if(i==7){
                if(betList[i]){
                    credits--;
                    checkSmall();
                }
            }
            if(i==8){    
                if(betList[i]){
                    credits--;
                    checkLarge();
                }
            }
        }
    }
    
    //accessors
    public String getMessage(){
        return message;
    }
    public int getCredits(){
        return credits;
    }
    public GVdie[] getDice(){
        return diceBlock;
    }
    public boolean enoughCredits(){
        boolean isEnough = true;
        int numBets = 0;
        for(int i=0; i<betList.length; ++i){
            if(betList[i]==true){
                numBets++;
            }
        }
        if(numBets > credits){
            isEnough = false;
        }
        return isEnough;
    }
    
    //mutators
    public void addCredits(int amount){
        if(amount>=0){
            credits += amount;
        }
    }
    public void placeBet(int bet){
        betList[bet-1] = true;
    }
    public void cancelBet(int bet){
        betList[bet-1] = false;
    }
    public void clearAllBets(){
        for(int i=0; i<betList.length; ++i){
            betList[i] = false;
        }
    }
    public void roll(){
        if(enoughCredits()){
            for(int i=0; i<diceBlock.length; ++i){
                diceBlock[i].roll();
            }
            checkAllBets();
            clearAllBets();
        }else{
            message = "Not Enough Credits";
            for(int i=0; i<diceBlock.length; ++i){
                diceBlock[i].setBlank();
            }
        }
    }
    public void reset(){
        for(int i=0; i<diceBlock.length; ++i){
            diceBlock[i].setBlank();
        }
        credits = 10;
        message = "";
        clearAllBets();
    }
    
    //software testing
    public String diceToString(){
        String diceNums = "[";
        for(int i=0; i<diceBlock.length; ++i){
            diceNums += Character.toString(diceBlock[i].getValue());
            if(i<diceBlock.length-1){
                diceNums += ",";
            }else{
                diceNums += "]";
            }
        }
        return diceNums;
    }
    public void testRoll(int[] values){
        for(int i=0; i<diceBlock.length; ++i){
            while(diceBlock[i].getValue() != values[i]){
                diceBlock[i].roll();
            }
        }
        checkAllBets();
        clearAllBets();
    }
    
}