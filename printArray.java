import java.util.Scanner;

public class printArray {

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
        System.out.println(i);
        print(n - 1);
    }
}
