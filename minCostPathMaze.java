import java.util.Scanner;

/**
 * minCostPathMaze
 */
public class minCostPathMaze {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        int[][] maze = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = scn.nextInt();
            }
        }
        scn.close();

        // boolean[][] visited = new boolean[rows][cols];
        // int minCost = minCostFinder(maze, 0, 0, 0, visited); // recursive- TLE

        int[][] dp = new int[rows][cols]; // dp

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j == cols - 1)
                    dp[i][j] = maze[i][j];
                else if (i == rows - 1) {
                    dp[i][j] = dp[i][j + 1] + maze[i][j];
                } else if (j == cols - 1) {
                    dp[i][j] = dp[i + 1][j] + maze[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + maze[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);

    }

    public static int minCostFinder(int[][] maze, int cr, int cc, int csf, boolean[][] visited) {

        if (cr == maze.length || cc == maze[0].length || visited[cr][cc] == true) {
            return Integer.MAX_VALUE;
        }

        if (cr == maze.length - 1 && cc == maze[0].length - 1) {
            return csf + maze[cr][cc];
        }

        visited[cr][cc] = true;

        int hpathCost = minCostFinder(maze, cr, cc + 1, csf + maze[cr][cc], visited);
        int vpathCost = minCostFinder(maze, cr + 1, cc, csf + maze[cr][cc], visited);

        visited[cr][cc] = false;

        return Math.min(hpathCost, vpathCost);
    }
}