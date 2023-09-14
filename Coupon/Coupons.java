/**
* Based on examples from Sedgewick & Wayne, Intro to
* Programming in Java / Python.
*
* https://introcs.cs.princeton.edu/java/14array/
* https://introcs.cs.princeton.edu/python/14array/
*
* @author David Owen and Noah Barrall
*/
public class Coupons {
    public static void main(String[] args) {
        int n = 100;
        int trials = 1000;
        int totalTries = 0;

        if (args.length >= 2) { 

            n = Integer.parseInt(args[0]);
            trials = Integer.parseInt(args[1]);
        }

        for (int i = 0; i < trials; i++) {
            boolean[] isCollected = new boolean[n];

            int tries = 0;
            int numCollected = 0;

            while (numCollected < n) {
                tries++;
                int r = (int) (Math.random() * n);

                if (!isCollected[r]) {
                    numCollected++;
                    isCollected[r] = true;
                }
            }
            
            totalTries += tries;

        }
        System.out.printf("Average tries to collect 10 coupons: %.2f\n", (double) totalTries / trials); //f is for floating-pt or (double)
    }
}