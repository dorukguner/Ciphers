import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Railfence cipher by Doruk
 * 19/04/18
 */

public class Railfence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        System.out.println("Please enter the amount of rails.");
        int amountOfRails = sc.nextInt();
        String ciphered = "";
        List<String> rails = new ArrayList<>();
        int j = amountOfRails - 2;
        boolean flag = false;
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.toCharArray()[i];
            if (i < amountOfRails) {
                String newRail = Character.toString(currentCharacter);
                rails.add(newRail);
            } else {
                String currentRail = rails.get(j);
                rails.set(j, currentRail.concat(Character.toString(currentCharacter)));
                if (!flag) {
                    j--;
                } else {
                    j++;
                }
                if (j == 0 || j == amountOfRails - 1) {
                    flag = !flag;
                }
            }
        }
        for (String rail : rails) {
            ciphered = ciphered.concat(rail);
        }
        System.out.println("The ciphered text is: ");
        System.out.println(ciphered);
    }

}
