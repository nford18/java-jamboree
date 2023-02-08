
public class ChuckTest{
    public static void main(String[] args){
        System.out.println("---Phase 1 testing start---");
        //testing constructor
        Chuck dice = new Chuck();
        assert dice.getCredits() == 10 : "should be 10";
        if(dice.getDice() == null){
            System.out.println("array not instantiated");
        }else{
            for(int i=0; i<3; ++i){
                if(dice.getDice()[i] == null){
                    System.out.println("array elements not instantiated");
                }
            }
        }
        for(int i=0; i<dice.betList.length; ++i){
            if(dice.betList[i] != false){
                System.out.println("array elements should start false");
            }
        }
        
        
        //testing accessors
        assert dice.getCredits() == 10 : "should be 10";
        dice.addCredits(2);
        assert dice.getCredits() == 12 : "should now be 12";
        assert dice.getMessage().equals("") : "should be blank";

        System.out.println("---Phase 1 testing end---");

        System.out.println("---Phase 3 testing start---");
        
        //vars for testing
        int before = 0;
        final int ONES = 1;
        final int TWOS = 2;
        final int THREES = 3;
        final int FOURS = 4;
        final int FIVES = 5;
        final int SIXES = 6;
        final int FIELD = 7;
        final int SMALL = 8;
        final int LARGE = 9;
        
        //mutators
        Chuck game = new Chuck();
        assert game.getCredits() == 10 : "credits should start at 10";
        assert game.getMessage().equals("") : "should be blank";
        game.placeBet(4);
        assert game.betList[3] == true : "should be true";
        game.addCredits(5);
        assert game.getCredits() == 15 : "should have added 5 to 10";
        game.reset();
        assert game.getCredits() == 10 : "should be reset to 10";
        assert game.getMessage().equals("") : "should be blank";
        
        int[] values = new int[3];
        values[0] = 3;
        values[1] = 3;
        values[2] = 3;
        
        game.placeBet(3);
        game.testRoll(values);
        assert game.getMessage().equals("Congrats, You Won!") : "should be win card";
        assert game.getCredits() == 20 : "should be 20";
        game.cancelBet(3);
        game.placeBet(2);
        game.testRoll(values);
        assert game.getMessage().equals("Too Bad, Try Again!") : "should be lose card";
        assert game.getCredits() == 19 : "should be 19";

        // wins bet on 1
        before = game.getCredits();
        game.placeBet(ONES);
        game.testRoll(new int [] {1,3,3});
        assert game.getCredits() == before + 1 : "should have won betting on 1";
        // loses bet on 1
        before = game.getCredits();
        game.placeBet(ONES);
        game.testRoll(new int [] {6,3,3});
        assert game.getCredits() == before - 1 : "should have lost betting on 1";
        
        // wins bet on 2
        before = game.getCredits();
        game.placeBet(TWOS);
        game.testRoll(new int [] {2,2,3});
        assert game.getCredits() == before + 2 : "should have won betting on 2";
        // loses bet on 2
        before = game.getCredits();
        game.placeBet(TWOS);
        game.testRoll(new int [] {6,5,3});
        assert game.getCredits() == before - 1 : "should have lost betting on 2";
        
        // wins bet on 3
        before = game.getCredits();
        game.placeBet(THREES);
        game.testRoll(new int [] {3,3,3});
        assert game.getCredits() == before + 10 : "should have won betting on 3";
        // loses bet on 3
        before = game.getCredits();
        game.placeBet(THREES);
        game.testRoll(new int [] {6,2,5});
        assert game.getCredits() == before - 1 : "should have lost betting on 3";
        
        // wins bet on 4
        before = game.getCredits();
        game.placeBet(FOURS);
        game.testRoll(new int [] {4,3,4});
        assert game.getCredits() == before + 2 : "should have won betting on 4";
        // loses bet on 4
        before = game.getCredits();
        game.placeBet(FOURS);
        game.testRoll(new int [] {6,3,3});
        assert game.getCredits() == before - 1 : "should have lost betting on 4";
        
        // wins bet on 5
        before = game.getCredits();
        game.placeBet(FIVES);
        game.testRoll(new int [] {2,5,3});
        assert game.getCredits() == before + 1 : "should have won betting on 5";
        // loses bet on 5
        before = game.getCredits();
        game.placeBet(FIVES);
        game.testRoll(new int [] {6,3,3});
        assert game.getCredits() == before - 1 : "should have lost betting on 5";
        
        // wins bet on 6
        before = game.getCredits();
        game.placeBet(SIXES);
        game.testRoll(new int [] {6,6,6});
        assert game.getCredits() == before + 10 : "should have won betting on 6";
        // loses bet on 6
        before = game.getCredits();
        game.placeBet(SIXES);
        game.testRoll(new int [] {5,3,3});
        assert game.getCredits() == before - 1 : "should have lost betting on 6";
        
        // wins bet on Field
        before = game.getCredits();
        game.placeBet(FIELD);
        game.testRoll(new int [] {2,2,2});
        assert game.getCredits() == before + 1 : "should have won betting on Field";
        // wins bet on Field again
        before = game.getCredits();
        game.placeBet(FIELD);
        game.testRoll(new int [] {5,5,5});
        assert game.getCredits() == before + 1 : "should have won betting on Field";
        // loses bet on Field
        before = game.getCredits();
        game.placeBet(FIELD);
        game.testRoll(new int [] {3,4,3});
        assert game.getCredits() == before - 1 : "should have lost betting on Field";
        
        // wins bet on Small
        before = game.getCredits();
        game.placeBet(SMALL);
        game.testRoll(new int [] {2,3,3});
        assert game.getCredits() == before + 1 : "should have won betting on Small";
        // loses bet on Small
        before = game.getCredits();
        game.placeBet(SMALL);
        game.testRoll(new int [] {6,3,3});
        assert game.getCredits() == before - 1 : "should have lost betting on Small";
        
        // wins bet on Large
        before = game.getCredits();
        game.placeBet(LARGE);
        game.testRoll(new int [] {6,3,3});
        assert game.getCredits() == before + 1 : "should have won betting on Large";
        // loses bet on Large
        before = game.getCredits();
        game.placeBet(LARGE);
        game.testRoll(new int [] {2,3,3});
        assert game.getCredits() == before - 1 : "should have lost betting on Large";
        
        System.out.println("---Phase 3 testing end---");
    }
}
