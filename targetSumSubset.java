import java.util.Scanner;

/**
 * targetSumSubset
 */
public class targetSumSubset {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        scn.close();
        boolean[][] dp = new boolean[n + 1][tar + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < tar + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < tar + 1; j++) {
                if (dp[i - 1][j] == true || (j - a[i - 1] >= 0 && dp[i - 1][j - a[i - 1]] == true)) {
                    dp[i][j] = true;
                }
            }
        }

        System.out.println(dp[n][tar]);

    }
}