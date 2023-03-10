import java.util.Scanner;

/**
 * printAllPermutations
 */
public class printAllPermutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        printPermutations(str, "");
    }

    public static void printPermutations(String str, String asf) {
        int len = str.length();
        if (len == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            printPermutations(ros, asf + ch);
        }
    }

}