import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Track columns and diagonals
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row + col
        boolean[] diag2 = new boolean[2 * n]; // row - col + n

        backtrack(0, board, result, col, diag1, diag2, n);
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result,
                           boolean[] col, boolean[] diag1, boolean[] diag2, int n) {

        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] || diag1[row + c] || diag2[row - c + n]) continue;

            // Place queen
            board[row][c] = 'Q';
            col[c] = diag1[row + c] = diag2[row - c + n] = true;

            backtrack(row + 1, board, result, col, diag1, diag2, n);

            // Backtrack
            board[row][c] = '.';
            col[c] = diag1[row + c] = diag2[row - c + n] = false;
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}