import java.util.*;

public class getSubsequences {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        ArrayList<String> ans = gss(str);
        System.out.println(ans);
    }

    static ArrayList<String> gss(String str) {

        if (str.length() == 0) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        char ch = str.charAt(0);
        String s = str.substring(1);
        ArrayList<String> temp = gss(s);
        ArrayList<String> ans = new ArrayList<>();
        for (String x : temp) {
            ans.add(x);
        }
        for (String x : temp) {
            ans.add(ch + x);
        }
        return ans;
    }
}