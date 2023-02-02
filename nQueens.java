import java.util.Scanner;

public class nQueens {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        int n = chess.length;
        if (row == n) {
            System.out.println(qsf + ".");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(chess, row, i)) {
                chess[row][i] = 1;
                printNQueens(chess, qsf + row + '-' + i + ", ", row + 1);
                chess[row][i] = 0;
            }
        }
    }

    static boolean isSafe(int[][] chess, int r, int c) {
        int n = chess.length;
        for (int i = 0; i < n; i++) {
            if (i == c)
                continue;
            if (chess[r][i] == 1)
                return false;
        }
        for (int i = 0; i < n; i++) {
            if (i == r)
                continue;
            if (chess[i][c] == 1)
                return false;
        }
        int i = 1;
        int j = 1;
        while (r + i < n && c + j < n) {
            if (chess[r + i][c + j] == 1)
                return false;
            i++;
            j++;
        }
        i = 1;
        j = 1;
        while (r - i >= 0 && c - j >= 0) {
            if (chess[r - i][c - j] == 1)
                return false;
            i++;
            j++;
        }
        i = 1;
        j = 1;
        while (r - i >= 0 && c + j < n) {
            if (chess[r - i][c + j] == 1)
                return false;
            i++;
            j++;
        }
        i = 1;
        j = 1;
        while (r + i < n && c - j >= 0) {
            if (chess[r + i][c - j] == 1)
                return false;
            i++;
            j++;
        }
        return true;
    }
}