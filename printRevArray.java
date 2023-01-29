import java.util.Scanner;

public class printRevArray {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        print(n);
        scn.close();
    }

    static void print(int n) {
        if (n == 0)
            return;
        int i = scn.nextInt();
        print(n - 1);
        System.out.println(i);

    }
}
