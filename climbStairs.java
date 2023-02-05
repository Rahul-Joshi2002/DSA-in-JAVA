
/**
 * climbStairs
 */
import java.util.Scanner;

public class climbStairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int dp[] = new int[n + 1]; // memoization
        int paths = solve(n, 0, dp);
        System.out.println(paths);
        int dp1[] = new int[n + 1]; // tabulation
        dp1[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp1[i] = dp1[i - 1];
            } else if (i == 2) {
                dp1[i] = dp1[i - 1] + dp1[i - 2];
            } else {
                dp1[i] = dp1[i - 1] + dp1[i - 2] + dp1[i - 3];
            }
        }
        System.out.println(dp1[n]);
    }

    public static int solve(int n, int curr, int[] dp) {
        if (curr > n) {
            return 0;
        }
        if (curr == n) {
            return 1;
        }
        if (dp[curr] != 0) {
            return dp[curr];
        }
        int path1 = solve(n, curr + 1, dp);
        int path2 = solve(n, curr + 2, dp);
        int path3 = solve(n, curr + 3, dp);
        int paths = path1 + path2 + path3;
        return paths;
    }
}