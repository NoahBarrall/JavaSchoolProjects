import java.util.Scanner;

public class PigFunctions {

    private static Scanner input = null;

    public static int takeTurn(int holdAmount) {
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
        return turnScore;
    }

    public static int takeTurnInteractive() {
        int turnScore = 0;

        //Scanner input = new Scanner(System.in);

        if (input == null) {
            input = new Scanner(System.in);
        }

        while (true) {
            int rollScore = (int) (Math.random() * 6) + 1;

            if (rollScore > 1) {
                turnScore += rollScore;
                System.out.printf("You rolled %d\n", rollScore);
                // format for a decimal number where the spacing doesnt matter
                System.out.printf("Your score for this turn is %d\n", turnScore);

                System.out.print("Roll again? (Y/N): ");
                String inputLine = input.nextLine();
                String inputCaps = inputLine.toUpperCase();
                char firstChar = inputCaps.charAt(0);

                if (firstChar == 'N') {
                    break;
                }
            } else {
                turnScore = 0;
                System.out.println("You rolled a PIG!");
                System.out.println("Your score for the turn is 0");
                break;
            }
        }
        return turnScore;
    }
}