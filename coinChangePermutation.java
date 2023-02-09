import java.util.Scanner;

public class coinChangePermutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] denominations = new int[n];
        for (int i = 0; i < n; i++) {
            denominations[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        scn.close();

        int dp[] = new int[tar + 1];
        dp[0] = 1;

        for (int i = 1; i < tar + 1; i++) {
            for (int d : denominations) {
                if (i - d >= 0) {
                    dp[i] += dp[i - d];
                }
            }
        }

        // the loop of denominations kept inside the loop for different
        // amounts ensure that we get all possible permutations

        System.out.println(dp[tar]);
    }
}
