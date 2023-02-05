import java.util.Scanner;

public class variableJumps {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] jumps = new int[n];
        for (int i = 0; i < n; i++) {
            jumps[i] = scn.nextInt();
        }
        scn.close();
        int dp[] = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= jumps[i]; j++) {
                if (i + j > n)
                    continue;
                dp[i] += dp[i + j];
            }
        }
        System.out.println(dp[0]);
    }
}