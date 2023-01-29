import java.util.Scanner;

class printDecInc {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        pdi(n);
    }

    static void pdi(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);
    }
}