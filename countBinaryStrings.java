import java.util.Scanner;

public class countBinaryStrings {
    public static void main(String[] args) {

        // count the number of binary strings of length
        // n such that no two zeroes occur consecutively

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int old0 = 1; // number of binary strings of length 1 ending in 0
        int old1 = 1; // number of binary strings of length 1 ending in 1

        for (int i = 1; i < n; i++) { // each iteration increases length of string by 1

            int new0 = old1;
            int new1 = old0 + old1;
            old0 = new0;
            old1 = new1;
        }

        System.out.println(old0 + old1);
    }
}