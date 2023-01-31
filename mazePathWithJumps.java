
// smart calls, general base case
import java.util.Scanner;

public class mazePathWithJumps {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        scn.close();
        printMazePaths(0, 0, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if (sc == dc - 1 && sr == dr - 1) {
            System.out.println(psf);
            return;
        }

        for (int hs = 1; hs < dc - sc; hs++) {
            printMazePaths(sr, sc + hs, dr, dc, psf + "h" + hs);
        }
        for (int vs = 1; vs < dr - sr; vs++) {
            printMazePaths(sr + vs, sc, dr, dc, psf + "v" + vs);
        }
        for (int ds = 1; ds < dc - sc && ds < dr - sr; ds++) {
            printMazePaths(sr + ds, sc + ds, dr, dc, psf + "d" + ds);
        }
    }
}
