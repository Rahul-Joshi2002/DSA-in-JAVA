import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = scn.nextInt();
        }
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        scn.close();

        int[] dp = new int[cap + 1];
        for (int i = 1; i < cap + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i - wt[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }

        System.out.println(dp[cap]);
    }
}