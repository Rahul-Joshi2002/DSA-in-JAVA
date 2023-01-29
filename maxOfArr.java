import java.util.Scanner;

public class maxOfArr {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            arr[i] = val;
        }
        scn.close();
        int ans = maxOfArray(arr, 0);
        System.out.println("Maximum value of the array is - " + ans);
    }

    static int maxOfArray(int[] a, int i) {
        if (i == a.length - 1) {
            return a[i];
        }
        return Math.max(a[i], maxOfArray(a, i + 1));
    }
}
