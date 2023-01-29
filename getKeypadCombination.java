import java.util.Scanner;
import java.util.ArrayList;

public class getKeypadCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("");
            return ans;
        }
        int val = (int) (str.charAt(0)) - (int) ('0');
        String s = codes[val];
        ArrayList<String> al = getKPC(str.substring(1));
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (String x : al) {
                String temp = s.charAt(i) + x;
                ans.add(temp);
            }
        }
        return ans;
    }
}
