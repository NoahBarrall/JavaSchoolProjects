


public class PigTester {

    public static void main(String[] args) {
        int computerHoldAmt = Integer.parseInt(args[0]);
        PigPlayer p = new PigPlayer(computerHoldAmt);
        
        int userScore = 0;
        int roundCount = 1;

        while (p.getScore() < 35 && userScore < 35) {
            // You'll call, e.g., p.getScore() to get the computers score

            System.out.printf("\nRound %d\n", roundCount);
            System.out.println("------------------------");

            //int turnScore = PigFunctions.takeTurn(computerHoldAmt);
            p.takeTurn();
            // You'll call p.takeTurn()
           
            System.out.printf("The computer scored %d. ", p.getScore());
            System.out.println("Now it's your turn...\n");

            int turnScore = PigFunctions.takeTurnInteractive();
            userScore += turnScore;

            System.out.printf("\nYour score is %d\n", userScore);

            roundCount += 1;
        }
        if (p.getScore() > userScore) {
            System.out.printf("\nYou lose, %d to %d. Sorry!\n", p.getScore(), userScore);
        } else if (userScore > p.getScore()) {
            System.out.printf("\nYou win, %d to %d!!\n", userScore, p.getScore());
        } else {
            System.out.printf("\nIt's a tie, %d to %d.\n", userScore, p.getScore());
        }
    }
}