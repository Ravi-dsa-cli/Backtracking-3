
import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        place(0, board, res);
        return res;
    }

    void place(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validateDup(board, row, col)) {
                board[row][col] = 'Q';
                place(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    static boolean validateDup(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;

        // Upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Left row
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;

        // Lower-left diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        NQueens sol = new NQueens();
        int n = 4;  // You can change this value to test for other n
        List<List<String>> solutions = sol.solveNQueens(n);

        System.out.println("Total solutions for N = " + n + ": " + solutions.size());
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
