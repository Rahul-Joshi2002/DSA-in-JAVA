import java.util.Scanner;

public class coinChangeCombination {
    public static void main(String[] args) {

        // combinations not permutations
        // define storage and meaning
        // figure out the direction of problem
        // travel and solve

        Scanner scn = new Scanner(System.in);
        int tar = scn.nextInt();
        int n = scn.nextInt();
        int[] denominations = new int[n];
        for (int i = 0; i < n; i++) {
            denominations[i] = scn.nextInt();
        }
        scn.close();
        int[] dp = new int[tar + 1];

        // each cell in array dp represents the number of possible
        // combinations to pay an amount equal to the index of array.
        // problem is to be solved from index 0 to tar

        dp[0] = 1;
        for (int d : denominations) {
            for (int i = d; i < tar + 1; i++) {
                dp[i] += dp[i - d];
            }
        }

        // the loop over the array denominations ensure that what we
        // are getting are indeed combinations nor permutations.

        System.out.println(dp[tar]);

    }
}
