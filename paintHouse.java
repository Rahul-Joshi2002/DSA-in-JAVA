import java.util.Scanner;

public class paintHouse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();

        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    if (j == 0) {
                        dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]) + arr[i][j];
                    } else if (j == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + arr[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]) + arr[i][j];
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (dp[n - 1][i] < ans)
                ans = dp[n - 1][i];
        }

        System.out.println(ans);
    }
}