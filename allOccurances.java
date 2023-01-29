import java.util.Scanner;

public class allOccurances {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        scn.close();
        int[] ans = allIndices(arr, x, 0, 0);

        for (int i : ans)
            System.out.print(i + " ");
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {

        if (idx == arr.length) {
            return new int[fsf];
        }
        if (arr[idx] == x) {
            int[] ans = allIndices(arr, x, idx + 1, fsf + 1);
            ans[fsf] = idx;
            return ans;
        } else {
            int[] ans = allIndices(arr, x, idx + 1, fsf);
            return ans;
        }
    }
}