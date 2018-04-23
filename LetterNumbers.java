import java.util.Scanner;

/**
 * Letter Numbers cipher by Doruk
 * 21/04/18
 */

public class LetterNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        String ciphered = "";

        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.toCharArray()[i];
            if ('A' <= currentCharacter && currentCharacter <= 'Z') {                                                 // Check if current character is an alphabetic character and upper case
                ciphered = ciphered.concat(String.valueOf(currentCharacter - 'A'));                                   // Negate 'A' from the current character value to match the alphabet values to their required plaintext values
            } else if ('a' <= currentCharacter && currentCharacter <= 'z') {                                          // Check if current character is an alphabetic character and lower case
                ciphered = ciphered.concat(String.valueOf(currentCharacter - 'a'));                                   // Negate 'a' from the current character value to match the alphabet values to their required plaintext values
            } else {                                                                                                  // If character is not an alphabetic character
                ciphered = ciphered.concat(String.valueOf(currentCharacter));
            }
        }
        System.out.println("The ciphered text is: ");
        System.out.println(ciphered);
    }

}
