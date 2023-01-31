import java.util.Scanner;

/**
 * stairPath
 */
public class stairPath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int steps = scn.nextInt();
        scn.close();
        printStairPaths(steps, "");
    }

    public static void printStairPaths(int n, String path) {

        if (n < 0)
            return;
        if (n == 0) {
            System.out.println(path);
            return;
        }
        printStairPaths(n - 1, path + '1');
        printStairPaths(n - 2, path + '2');
        printStairPaths(n - 3, path + '3');
    }
}