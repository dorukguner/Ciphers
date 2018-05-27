import java.util.Scanner;

/**
 * Morse Code cipher by Doruk
 * 17/05/18
 */

public class MorseCode {

    public static void main(String[] args) {
        MorseCode mc = new MorseCode();
        Scanner sc = new Scanner(System.in);
        char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '\'', ',', '?', '-',
                '=', ':', ';', '(', ')', '/', '"', '$', '_', '@', '!', '+', '~', '#', '&', ' '};
        String[] morseCode = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-,--",
                "--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-.-.-",
                "--..--", "..--..", "-....-", "-...-", "---...", "-.-.-.", "-.--.", "-.--.-", "-..-.", ".-..-.", "...-..-",
                ".----.", "..--.-", ".--.-.", "---.", ".-.-.", ".-...", "...-.-", ". ..."};
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        text = text.toUpperCase();
        String cipheredText = "";

        for (char c : text.toCharArray()) {
            int index = mc.getIndex(alphabet, c);
            if (index != -1 && index < morseCode.length) {
                cipheredText = cipheredText.concat(morseCode[index]);
            } else if (index == -1) {
                System.out.println("The character " + c + " does not have a morse code representation.");
                System.exit(-1);
            } else {
                cipheredText += c;
            }
        }

        System.out.println("The ciphered text is: ");
        System.out.println(cipheredText);


    }
    private int getIndex(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }
}