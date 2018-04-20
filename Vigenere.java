import java.util.Scanner;

/**
 * Vigenere cipher by Doruk
 * 24/03/18
 */

public class Vigenere {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        System.out.println("Please enter a key.");
        String key = sc.nextLine();
        char[] ciphered = new char[text.length()];

        while (key.length() < text.length()) {                                        // Repeating the keyword till length is matched.
            key = key.concat(key);
        }

        int j = 0;                                                                    // Integer to keep track of current key letter
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.toCharArray()[i];
            char currentKeyCharacter = key.toCharArray()[j];
            if ('A' <= currentCharacter && currentCharacter <= 'Z') {                 // Check if current character is an alphabetic character and upper case
                if (!('A' <= currentKeyCharacter && currentKeyCharacter <= 'Z')) {    // Check if the key character is also upper case
                    currentKeyCharacter = (char)(currentKeyCharacter - 32);           // If not upper case, change to upper case
                }
                if (currentCharacter + (currentKeyCharacter - 65) <= 'Z') {           // Check if the encrypted character is an alphabetic character
                    ciphered[i] = (char)(currentCharacter + currentKeyCharacter - 'A');
                } else {
                    ciphered[i] = (char)(currentCharacter + currentKeyCharacter - 26 - 'A');    //If not, negate the length of the alphabet to encrypt as alphabetic character
                }
                j++;                                                                 // Only increment j when a letter has been ciphered
            } else if ('a' <= currentCharacter && currentCharacter <= 'z') {         // Check if current character is an alphabetic character and lower case
                if (!('a' <= currentKeyCharacter && currentKeyCharacter <= 'z')) {   // Check if the key character is also lower case
                    currentKeyCharacter = (char)(currentKeyCharacter + 32);          // If not lower case, change to lower case
                }
                if (currentCharacter + currentKeyCharacter - 'a' <= 'z') {           // Check if the encrypted character is an alphabetic character
                    ciphered[i] = (char)(currentCharacter + currentKeyCharacter - 'a');
                } else {
                    ciphered[i] = (char)(currentCharacter + currentKeyCharacter - 26 - 'a');    //If not, negate the length of the alphabet to encrypt as alphabetic character
                }
                j++;                                                                // Only increment j when a letter has been ciphered
            } else {                                                                // If character is not an alphabetic character
                ciphered[i] = currentCharacter;
            }
        }
        System.out.println("The ciphered text is: ");
        System.out.println(ciphered);
    }

}
