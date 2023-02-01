import java.util.Scanner;

/**
 * encodings
 */
public class encodings {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        } else if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == 0) {
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                asf += code;
                System.out.println(asf);
            }
            return;
        } else {
            String query1 = str.substring(0, 1);
            if (query1.equals("0")) {
                return;
            } else {
                int chv = helper(query1);
                char code = (char) ('a' + chv - 1);
                printEncodings(str.substring(1), asf + code);
            }

            String query2 = str.substring(0, 2);
            int chv = helper(query2);
            if (chv <= 26) {
                char code = (char) ('a' + chv - 1);
                printEncodings(str.substring(2), asf + code);
            }
        }
    }

    static int helper(String s) { // converts string to integer
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';
            ans *= 10;
            ans += temp;
        }
        return ans;
    }
}