import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author David Owen and Noah Barrall
 */
public class Tester {

    public static int[] countCharacters(String input) {
        int[] counter = new int[26];
    // Copy input String to char array.
        char[] chars = input.toCharArray();
    // For each character in the array ...
        for (int i = 0; i < chars.length; i++) {
        // If it's between A and Z ...
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                int j = chars[i] - 'A';
                counter[j]++; 
            }
        }
    // Return the counter variable array.
        return counter;
    }

    public static void makeHistogram(String input, int maxWidth) {
    // Call countCharacters to get an array of counter variables
    // for the letters in the input.
        int[] count = countCharacters(input);
    
        int maxCount = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        for (int i = 0; i < count.length; i++) {
            count[i] = (count[i] * maxWidth / maxCount);
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "plaintext.txt";
        if (args.length >= 1) filename = args[0];

        String plaintext = Files.readString(Path.of(filename));
        //String ciphertext = Cipher.encode(plaintext, 1);
        //String ciphertext = Cipher.encode(plaintext);
        String ciphertext = Cipher.encode(plaintext, 4, 5);
        System.out.println(ciphertext);
        System.out.println("\n");
        makeHistogram(ciphertext, 50);
        System.out.println("\n");
    }
}
