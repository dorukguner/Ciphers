import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * My Cipher by Doruk
 * 16/05/18
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        System.out.println("Please enter your key.");
        String key = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        String subText;
        while (sb.length() < text.length()) {
            if ((i + 1) * key.length() < text.length()) {
                subText = text.substring(i * key.length(), (i + 1) * key.length());
            } else {
                subText = text.substring(sb.length(), text.length());
            }
            Map<Integer, Character> sortedMap = new TreeMap<>();
            for (int j = 0; j < subText.length(); j++) {
                int newCharIndex = subText.charAt(j)%key.charAt(j);
                while (sortedMap.containsKey(newCharIndex)) {
                    newCharIndex++;
                }
                sortedMap.put(newCharIndex, subText.charAt(j));
            }
            for (int loc : sortedMap.keySet()) {
                sb.append(sortedMap.get(loc));
            }
            i++;
        }
        System.out.println(sb.toString());
    }


}