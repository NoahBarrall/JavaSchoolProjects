

/**
* Based on examples from Sedgewick & Wayne, Intro to
* Programming in Java / Python:
* https://introcs.cs.princeton.edu/java/13flow/
* https://introcs.cs.princeton.edu/python/13flow/
*
* @author Noah Barrall
*/
public class Gambler {
    //filename = class name (has to be the same or wont compile)
    public static void main(String[] args) {
        //every program needs this line after the class
        //below is the data types/initializing the variables/variables need to be declared
        int stake = 10;
        int goal = 20;
        int trials = 1000;

        if (args.length >= 3) { 

            stake = Integer.parseInt(args[0]);
            goal = Integer.parseInt(args[1]);
            trials = Integer.parseInt(args[2]);

        }
        int bets = 0;
        int wins = 0;
        for (int i = 0; i < trials; i++) {

            int cash = stake;
            while ((cash > 0) && (cash < goal)) {

                bets++;

                if (trials == 1) {
                    for (int j = 0; j < cash; j++) {
                        // initializes j as 0 and makes it so if j is less than cash then it will add to J and print a "$" for each time
                        System.out.print("$");
                    }    
                    System.out.println();
                }

                if (Math.random() < 0.5) {
                    cash++;
                    
                    
                } else {
                    cash--;
                }
            }
            if (cash == goal) {
                wins++;
            }
        }
        System.out.printf("%4.1f%% wins\n", 100.0 * wins / trials);
        System.out.printf("Avg. bets: %.1f\n", (double) bets / trials);
        //double gets floating point

    }
}

