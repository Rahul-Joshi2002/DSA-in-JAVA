import java.util.Scanner;

public class maxSumSubseq {
    public static int FindMaxSum(int arr[], int n) {

        // ----------------------------------------- dp optimized O(N)

        // int[] dp = new int[n];
        // dp[0] = arr[0];
        // int max = arr[0];

        // for(int i = 1; i < n ;i++) {
        // dp[i] = arr[i];
        // if(i != 1) {
        // dp[i] = arr[i] + max;
        // if(dp[i - 1] > max) max = dp[i - 1];
        // }
        // }

        // max = Integer.MIN_VALUE;
        // for(int e: dp) {
        // if(e > max) max = e;
        // }

        // return max;

        // --------------------------------------------- dp O(N^2)

        // int[] dp = new int[n];
        // dp[0] = arr[0];
        // for (int i = 1; i < n; i++) {
        // dp[i] = arr[i];
        // for (int j = 0; j < i - 1; j++) {
        // if (arr[i] + dp[j] > dp[i])
        // dp[i] = arr[i] + dp[j];
        // }
        // }

        // int max = Integer.MIN_VALUE;
        // for (int e : dp) {
        // if (e > max)
        // max = e;
        // }

        // return max;

        // -------------------------------------------- recursive brute force

        int ans1 = calc(arr, n, 0, 0, true);
        int ans2 = calc(arr, n, 0, 0, false);
        return Math.max(ans1, ans2);
    }

    private static int calc(int[] arr, int n, int sum, int idx, boolean inc) {

        if (idx == n)
            return sum;
        int ans = 0;
        if (inc == false) {
            ans = calc(arr, n, sum, idx + 1, true);
        } else {
            int ans1 = calc(arr, n, sum + arr[idx], idx + 1, false);
            int ans2 = calc(arr, n, sum, idx + 1, true);
            ans = Math.max(ans1, ans2);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        int ans = FindMaxSum(arr, n);

        System.out.println(ans);
    }
}