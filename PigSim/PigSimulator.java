
/**
* @author David Owen
*/
public class PigSimulator {
    public static void main(String[] args) {
        int numPlayers = args.length - 1;
        PigPlayer[] players = new PigPlayer[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            players[i] = new PigPlayer(Integer.parseInt(args[i]));
        }

        int numTrials = Integer.parseInt(args[args.length - 1]);

        for (int i = 0; i < numTrials; i++) {
        // When you want to loop through the elements of an array,
        // and you don’t need to do anything inside the loop that
        // depends on an element’s index, you can use more
        // compact "for each" form of the loop.
            for (PigPlayer p : players) p.resetScore();

            boolean gameOver = false;

            while (!gameOver) {
                for (PigPlayer p : players) p.takeTurn();

                for (PigPlayer p : players) {
                    if (p.getScore() >= 100) {
                        gameOver = true;
                        break;
                    }
                }
            }
        }
        // We can’t use the "for each" form here, because there’s
        // code inside the loop that makes use of the index (i)
        // of each element of the array.
        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("Player %2d (held at %2d): %5.2f\n",
                i + 1, players[i].getHoldAmount(),
                ((double) players[i].getTotalScore()) / numTrials);
        }
    }
}