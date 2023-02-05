import java.util.Scanner;

public class climbStairsMinMoves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] jumps = new int[n];
        for (int i = 0; i < n; i++) {
            jumps[i] = scn.nextInt();
        }
        scn.close();

        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= jumps[i]; j++) {
                if (i + j > n)
                    continue;
                if (dp[i + j] < min)
                    min = dp[i + j];
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
            else
                dp[i] = min;
        }
        System.out.println(dp[0]);
    }
}
