import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        System.out.println(fibo(n)); // recursive method
        System.out.println(fiboDP(n, new int[n + 1])); // memoization
    }

    public static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int ans = fibo(n - 1) + fibo(n - 2);
        return ans;
    }

    public static int fiboDP(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }

        int ans = fiboDP(n - 1, qb) + fiboDP(n - 2, qb);
        qb[n] = ans;
        return ans;
    }
}