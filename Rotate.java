
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Letter Numbers cipher by Doruk
 * 21/04/18
 */

public class Rotate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        System.out.println("Please enter the box length you wish to use");
        int boxLength = sc.nextInt();
        List<String> boxLines = new ArrayList<>();
        int j = 1;

        for (int i = 0; i < text.length(); i++) {
            String currentCharacter = text.substring(i,i + 1);
            if (j == 1 || j % boxLength == 1) {
                boxLines.add(currentCharacter);
            } else {
                String currentLine = boxLines.get(boxLines.size() - 1);
                boxLines.set(boxLines.size() - 1, currentLine.concat(currentCharacter));
            }
            j++;
        }
        System.out.println("The ciphered text is: ");
        for (int i = boxLength - 1; i >= 0; i--) {
            for (String line : boxLines) {
                if (i < line.length()) {
                    System.out.print(line.charAt(i));
                } else {
                    System.out.print("X");
                }
            }
        }
        System.out.println();
    }

}
