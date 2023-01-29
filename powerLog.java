import java.util.Scanner;
// time complexity -> log(n)

public class powerLog {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        scn.close();
        int ans = power(x, n);
        System.out.println(ans);
    }

    static int power(int x, int n) {
        if (n == 1) {
            return x;
        }
        int temp = power(x, n / 2);
        int ans = temp * temp;
        if (n % 2 != 0)
            ans *= x;
        return ans;
    }
}
