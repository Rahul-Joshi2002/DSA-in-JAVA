import java.util.Scanner;

/**
 * printKPC
 */
public class printKPC {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        printCombinations(str, "");
    }

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void printCombinations(String str, String asf) {

        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        int val = (int) (str.charAt(0)) - (int) ('0');
        String code = codes[val];
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            printCombinations(str.substring(1), asf + ch);
        }
    }

}