
/**
 * mazeWithJumps
 */
import java.util.*;

public class mazeWithJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        scn.close();
        ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }

        ArrayList<String> paths = new ArrayList<>();

        for (int step = 1; step <= dc - sc; step++) {
            ArrayList<String> hpaths = getMazePaths(sr, sc + step, dr, dc);
            for (String hpath : hpaths) {
                paths.add("h" + step + hpath);
            }
        }

        for (int step = 1; step <= dr - sr; step++) {
            ArrayList<String> vpaths = getMazePaths(sr + step, sc, dr, dc);
            for (String vpath : vpaths) {
                paths.add("v" + step + vpath);
            }
        }

        for (int step = 1; step <= dc - sc && step <= dr - sr; step++) {
            ArrayList<String> dpaths = getMazePaths(sr + step, sc + step, dr, dc);
            for (String dpath : dpaths) {
                paths.add("d" + step + dpath);
            }
        }
        return paths;
    }
}