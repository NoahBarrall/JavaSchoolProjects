/**
*
* Cootie Program written in Java
*
* @author Noah Barrall
*/

public class Cootie {
    public static void main(String[] args) {
        int trials = 1000;
        int totalTries = 0;

        if (args.length >= 1) {
            
            trials = Integer.parseInt(args[0]);
        }

        for (int i = 0; i < trials; i++) {
            int tries = 0;
        
            while (true) {
                tries++;
             
               if ((int) (Math.random() * 6) + 1 == 1) {
                    break;
               }
            }

            while (true) {
                tries++;
            
                if ((int)(Math.random() * 6) + 1 == 2) {
                    break;
                }
            }

            int [] partsNeeded = {1, 1, 1, 6};
            int numNeeded = 9;
            int [] partsCollected = new int [4]; 
            int numCollected = 0;

            while (numCollected < numNeeded) {
                tries++;
                int r = (int) (Math.random() * 6 + 1);

                    if (r >= 3) {
                        int j = (r - 3);

                            if (partsCollected[j] < partsNeeded[j]) {
                                numCollected++;
                                partsCollected[j]++;
                            }
                    }
            }
            totalTries += tries;
        }
        double averageTries = (double) totalTries / trials;
        System.out.printf("The average number of tries was %.2f", averageTries);
    }    
}

