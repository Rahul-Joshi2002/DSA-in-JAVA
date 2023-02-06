import java.util.Scanner;

public class goldmine {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mine = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mine[i][j] = scn.nextInt();
            }
        }
        scn.close();

        int[][] dp = new int[n][m];
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    dp[i][j] = mine[i][j];
                } else if (i - 1 < 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + mine[i][j];
                } else if (i + 1 == n) {
                    dp[i][j] = Math.max(dp[i - 1][j + 1], dp[i][j + 1]) + mine[i][j];
                } else {
                    int temp = Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]);
                    dp[i][j] = Math.max(temp, dp[i][j + 1]) + mine[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] > max)
                max = dp[i][0];
        }

        System.out.println(max);
    }
}
