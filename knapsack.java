import java.util.Scanner;

public class knapsack {
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

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < cap + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j - wt[i - 1] >= 0)
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < cap + 1; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }
        System.out.println(dp[n][cap]);
    }
}