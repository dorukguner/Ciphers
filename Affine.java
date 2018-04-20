import java.util.Scanner;

/**
 * Affine cipher by Doruk
 * 29/03/18
 */

public class Affine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        System.out.println("Please enter the first key.");
        int key1 = sc.nextInt();
        System.out.println("Please enter the second key.");
        int key2 = sc.nextInt();
        char[] ciphered = new char[text.length()];
        int alphabetLength = 26;

        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.toCharArray()[i];
            if (('A' <= currentCharacter && currentCharacter <= 'Z')) {                                                 // Check if current character is an alphabetic character and upper case
                ciphered[i] = (char)(((key1 * (currentCharacter - 'A') + key2) % alphabetLength) + 'A');                // Negate 'A' from the current character value to match the alphabet values to their required plaintext values
            } else if ('a' <= currentCharacter && currentCharacter <= 'z') {                                            // Check if current character is an alphabetic character and lower case
                ciphered[i] = (char)(((key1 * (currentCharacter - 'a') + key2) % alphabetLength) + 'a');                // Negate 'a' from the current character value to match the alphabet values to their required plaintext values
            } else {                                                                                                    // If character is not an alphabetic character
                ciphered[i] = currentCharacter;
            }
        }
        System.out.println("The ciphered text is: ");
        System.out.println(ciphered);
    }

}
