import java.util.*;

public class MazePaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        scn.close();
        ArrayList<String> paths = getMazePaths(0, 0, rows, cols);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if (sr >= dr || sc >= dc) {
            return new ArrayList<String>();
        }
        if (sr == dr - 1 && sc == dc - 1) {
            ArrayList<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }
        ArrayList<String> paths = new ArrayList<>();

        ArrayList<String> path1 = getMazePaths(sr, sc + 1, dr, dc);
        for (String str : path1) {
            str = 'h' + str;
            paths.add(str);
        }

        ArrayList<String> path2 = getMazePaths(sr + 1, sc, dr, dc);
        for (String str : path2) {
            str = 'v' + str;
            paths.add(str);
        }

        return paths;
    }

}