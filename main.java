import java.util.*;

/**
 * Columnar Transposition by Doruk
 * 08/04/18
 */

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text to cipher.");
        String text = sc.nextLine();
        System.out.println("Please enter a key. Please use spaces between each numeric value.");
        String key = sc.nextLine();
        Map<Integer, String> keyMap = new LinkedHashMap<>();                                        // Linked Hash Map that stores the letters into their respective columns.

        String[] splitKey = key.split(" ");                                                         // Array containing all entered keys.
        double columnLength = Math.ceil((double)text.length()/(double)splitKey.length);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            int curKey = Integer.parseInt(splitKey[j]);
            j++;
            StringBuilder sb = new StringBuilder();                                                  // New StringBuilder to build current column's letters.
            if (keyMap.containsKey(curKey)) {                                                        // Check if map contains the current column
                sb.append(keyMap.get(curKey));                                                       // Append the current column onto the StringBuilder
            }
            sb.append(text.charAt(i));                                                               // Append the current character from the entered text onto the StringBuilder.
            keyMap.put(curKey, sb.toString());                                                       // Add the required characters to the current column.
            if (j >= splitKey.length) {                                                              // Check to reset j if there are more characters to add.
                j = 0;
            }
        }

        List<Integer> orderedKeys = new ArrayList<>(keyMap.keySet());                                // New ArrayList to store the ordered column keys into.

        Collections.sort(orderedKeys);                                                               // Sort the column keys.


        System.out.println("The ciphered text is: ");
        for (Integer i : orderedKeys) {                                                              // Print out each character in each column in order.
            for (char c : keyMap.get(i).toCharArray()) {
                System.out.print(c);
            }
        }
    }

}