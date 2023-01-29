import java.util.Scanner;

public class towerOfHanoi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1id = scn.nextInt();
        int t2id = scn.nextInt();
        int t3id = scn.nextInt();
        scn.close();
        toh(n, t1id, t2id, t3id);
    }

    static void toh(int n, int a, int b, int c) {
        if (n == 0) {
            return;
        }
        toh(n - 1, a, c, b);
        System.out.println(n + " [" + a + " -> " + b + "] ");
        toh(n - 1, c, b, a);
    }
}
