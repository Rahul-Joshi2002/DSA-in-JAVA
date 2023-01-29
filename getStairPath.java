import java.util.*;

public class getStairPath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStairPaths(int n) {

        if (n < 0) {
            ArrayList<String> empty = new ArrayList<>();
            return empty;
        }

        if (n == 0) {
            ArrayList<String> path = new ArrayList<>();
            path.add("");
            return path;
        }

        ArrayList<String> paths = new ArrayList<>();

        ArrayList<String> path1 = getStairPaths(n - 1);

        for (String p : path1) {
            p = '1' + p;
            paths.add(p);
        }

        ArrayList<String> path2 = getStairPaths(n - 2);

        for (String p : path2) {
            p = '2' + p;
            paths.add(p);
        }

        ArrayList<String> path3 = getStairPaths(n - 3);

        for (String p : path3) {
            p = '3' + p;
            paths.add(p);
        }

        return paths;

    }

}