
/**
* A new data type, to represent a player of the dice game Pig.
* Tracks player’s hold amount (how many points this player tries
* for in each turn) and score for the current game.
*
* @author David Owen
*/
public class PigPlayer {

    private int holdAmount;
    private int score;
    private int totalScore;

    public PigPlayer(int holdAmount) {
       
        this.holdAmount = holdAmount;
        
        this.score = 0;
        this.totalScore = 0;
    }
  
    public int getHoldAmount() {
    return this.holdAmount;
    }

    public int getScore() {
        return this.score;
    }

    public int getTotalScore() {
        return this.totalScore;
    }
    // if you want a method to call from an instance, you dont need to use static
    public void takeTurn() {
        int turnScore = 0;

        while (turnScore < holdAmount) {
            int rollScore = (int) (Math.random() * 6) + 1;

            if (rollScore > 1) {
                turnScore += rollScore;
            } else {
                turnScore = 0;
                break;
            }
        }
        this.score += turnScore;
        this.totalScore += turnScore;
    }

    public void resetScore() {
        this.score = 0;
    }
}

