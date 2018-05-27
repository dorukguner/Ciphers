import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Playfair cipher by Doruk
 * 14/05/18
 */

public class Playfair {

    public static void main(String[] args) {
        Playfair pf = new Playfair();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        System.out.println("Please enter which letters you'd like to translate.");
        String[] lettersToTranslate = sc.nextLine().toUpperCase().split(" ");
        System.out.println("Please enter the alphabet key to use.");
        String alphabetKey = sc.nextLine().toUpperCase();
        String cipheredText = "";

        char[][] tableau = pf.initialiseTableau(alphabetKey, lettersToTranslate);

        text = pf.replaceAllDuplicates(text);
        List<Integer> spaceLocations = pf.getSpaceLocations(text);
        text = text.replace(" ", "");
        System.out.println(text);
        for (int i = 0; i <= text.length()/2 - 1; i++) {
            StringBuilder curText = new StringBuilder();
            curText.append(text.charAt(2 * i));
            curText.append(text.charAt(2 * i + 1));
            System.out.println(curText.toString());
            cipheredText = cipheredText.concat(pf.translateCharacters(tableau, pf.getCoordsOfString(tableau, curText.toString()), curText.toString()));
        }
        System.out.println();
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[0].length; j++) {
                System.out.print(tableau[i][j]);
            }
            System.out.println();
        }
        cipheredText = pf.replaceSpaces(spaceLocations, cipheredText);
        System.out.println(cipheredText);
    }

    private String replaceSpaces(List<Integer> locations, String string) {
        StringBuilder replacedString = new StringBuilder();
        int offset = 0;
        for (int i = 0; i < string .length(); i++) {
            if (locations.contains(i + offset)) {
                replacedString.append(' ');
                offset++;
            }
            replacedString.append(string.toCharArray()[i]);
        }
        return replacedString.toString();
    }

    private List<Integer> getSpaceLocations(String string) {
        List<Integer> spaces= new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.toCharArray()[i] == ' ') {
                spaces.add(i);
            }
        }
        return spaces;
    }

    private String replaceAllDuplicates(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length() - 1; i+=2) {
            sb.append(string.toCharArray()[i]);
            if (string.toCharArray()[i] == string.toCharArray()[i + 1]) {
                sb.append('X');
            }
            sb.append(string.toCharArray()[i + 1]);
        }
        sb.append(string.toCharArray()[string.length() - 1]);
        if (string.length() % 2 == 1) {
            sb.append('X');
        }
        return sb.toString();
    }

    private char[][] initialiseTableau(String alphabetkey, String[] lettersToTranslate) {
        char[][] tableau = new char[5][5];
        int i = 0;
        int j = 0;

        for (char c : alphabetkey.toCharArray()) {
            if (j >= 5) {
                j = 0;
                i++;
            }
            if (!charArrayContainsLetter(tableau, c) && c != lettersToTranslate[0].charAt(0)) {
                tableau[i][j] = c;
                j++;
            }
        }
        char curChar = 'A';
        while (i < 5) {
            while (j < 5) {
                while (charArrayContainsLetter(tableau, curChar)) {
                    curChar++;
                }
                if (curChar != lettersToTranslate[0].charAt(0)) {
                    if (!charArrayContainsLetter(tableau, lettersToTranslate[1].charAt(0))) {
                        tableau[i][j] = lettersToTranslate[1].charAt(0);
                    }
                    tableau[i][j] = curChar;
                    j++;
                }
                curChar++;
            }
            i++;
            j = 0;
        }
        return tableau;
    }

    private boolean charArrayContainsLetter(char[][] array, char letter) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == letter) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] getCoordsOfString(char[][] tableau, String string) {
        int[][] coords = new int[][]{new int[]{-1, -1}, new int[]{-1, -1}};
        string = string.toUpperCase();
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau.length; j++) {
                if (tableau[i][j] == string.charAt(0)) {
                    coords[0][0] = i;
                    coords[0][1] = j;
                }
                if (tableau[i][j] == string.charAt(1)) {
                    coords[1][0] = i;
                    coords[1][1] = j;
                }
            }

        }
        return coords;
    }

    private String translateCharacters(char[][] tableau, int[][] coords, String original) {
        StringBuilder translatedStringBuilder = new StringBuilder();
        int i1 = coords[0][0];
        int j1 = coords[0][1];
        int i2 = coords[1][0];
        int j2 = coords[1][1];
        if (i1 >= 0 && i2 >= 0 && j1 >= 0 && j2 >= 0) {
            if (i1 == i2) {                     // Same row
                if (j1 < tableau.length - 1) {
                    translatedStringBuilder.append(tableau[i1][j1 + 1]);
                } else {
                    translatedStringBuilder.append(tableau[i1][0]);
                }
                if (j2 < tableau.length - 1) {
                    translatedStringBuilder.append(tableau[i2][j2 + 1]);
                } else {
                    translatedStringBuilder.append(tableau[i2][0]);
                }
            } else if (j1 == j2) {              // Same column
                if (i1 < tableau.length - 1) {
                    translatedStringBuilder.append(tableau[i1 + 1][j1]);
                } else {
                    translatedStringBuilder.append(tableau[0][j1]);
                }
                if (i2 < tableau.length - 1) {
                    translatedStringBuilder.append(tableau[i2 + 1][j2]);
                } else {
                    translatedStringBuilder.append(tableau[0][j2]);
                }
            } else {                            // Rectangle formed between characters
                translatedStringBuilder.append(tableau[i1][j2]);
                translatedStringBuilder.append(tableau[i2][j1]);
            }
        } else {
            translatedStringBuilder.append(original);
        }
        return translatedStringBuilder.toString();
    }

}