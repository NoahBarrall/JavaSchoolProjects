/**
 * @author David Owen and Noah Barrall
 */
public class Cipher {

    public static String encode(String plaintext, int offset) {
    
        // Convert String to an array of char values, so that we
        // can work with each character of the String as if it
        // were that character's associated ASCII value.
        char[] chars = plaintext.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            
            // If character at i is an uppercase letter ...
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
            
                // Shift it by offset.
                chars[i] += offset;
                
                // If it was shifted past Z, shift it back 26.
                if (chars[i] > 'Z') chars[i] -= 26;
            }
        }
        
        // Convert char array to a String and return it.
        return String.valueOf(chars);
    }

    public static void shuffle(char[] array) {
        // Rewrite the shuffle code from Cards.java (or
        // ShuffleTest.java) so that it works for an array of
        // characters.
        int n = array.length;

        for (int j = 0; j < n; j++) {
            int r = j + (int) (Math.random() * (n - j));
            char temp = array[r];
            array[r] = array[j];
            array[j] = temp;
        }
    }

    public static String encode(String plaintext) {
        // Create a char array with the letters of the alphabet
        // (capitalized), and shuffle it using the function above.
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabet = alphabetString.toCharArray();
        shuffle(alphabet);

        // Copy plaintext String to a char array.  (A separate array
        // from the one you just created with the letters of the
        // alphabet.)
        char[] chars = plaintext.toCharArray();

        // For each character in the second array ...
        for (int i = 0; i < chars.length; i++) {

            // If it's between A and Z ...
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Find the index of the corresponding character in
                // the substitution alphabet.  (Hint:  get the
                // character from the array and subtract 'A' from
                // it.  This will give you 0 for 'A', 1 for
                // 'B', etc.)
                int j = chars[i] - 'A';
                // Replace the character (from the plaintext char
                // array) with the one in the substitution alphabet
                // whose index you just found.
                chars[i] = alphabet[j];

            }
        }

        // Convert char array (the one with the encoded
        // characters, not the substitution alphabet, in it) to a
        // String and return it.
        return String.valueOf(chars);

    }   

    public static String encode(String plaintext, int offset, int period) {
            // Copy plaintext String to char array.
            // Initialize an int variable called extraOffset to zero.
        char[] chars = plaintext.toCharArray();
        int extraOffset = 0;
            // For each character in the array ...
        for (int i = 0; i < chars.length; i++) {

            // If it's between A and Z ...
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Shift it by offset + extraOffset.
                chars[i] += (offset + extraOffset);
            
                    // If it was shifted past Z, shift it back 26.
                if (chars[i] > 'Z') chars[i] -= 26;
                        // Increase extraOffset by 1.  If after adding 1
                        // extraOffset equals period, reset extraOffset to
                        // zero.
                extraOffset += 1;
                if (extraOffset >= period) {
                    extraOffset = 0;
                }
            }
        }
    // Convert char array to a String and return it.
        return String.valueOf(chars);
    }

}