import java.util.Scanner;

/**
 * Caesar cipher by Doruk Guner
 * 17/03/18
 */

public class Caesar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        System.out.println("Please enter a key.");
        int key = sc.nextInt();
        char[] ciphered = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.toCharArray()[i];
            if ((65 <= currentCharacter && currentCharacter <= 90)) {        // Check if current character is an alphabetic character
                if (currentCharacter + key <= 90) {
                    ciphered[i] = (char)(currentCharacter + key);
                } else {
                    ciphered[i] = (char)(currentCharacter + key - 26);
                }
            } else if (97 <= currentCharacter && currentCharacter <= 122) {   // Check if current character is an alphabetic character
                if (currentCharacter + key <= 122) {
                    ciphered[i] = (char)(currentCharacter + key);
                } else {
                    ciphered[i] = (char)(currentCharacter + key - 26);
                }
            } else {                                                          // If character is not an alphabetic character
                ciphered[i] = currentCharacter;
            }
        }
        System.out.println("The ciphered text is: ");
        System.out.println(ciphered);
    }

}
