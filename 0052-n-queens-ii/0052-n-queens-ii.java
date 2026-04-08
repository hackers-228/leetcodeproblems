class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row + col
        boolean[] diag2 = new boolean[2 * n]; // row - col + n

        backtrack(0, n, col, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2) {
        // If all queens placed
        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] || diag1[row + c] || diag2[row - c + n]) continue;

            // Place queen
            col[c] = diag1[row + c] = diag2[row - c + n] = true;

            backtrack(row + 1, n, col, diag1, diag2);

            // Backtrack
            col[c] = diag1[row + c] = diag2[row - c + n] = false;
        }
    }
}