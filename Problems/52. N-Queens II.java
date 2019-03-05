class Solution {

    private int count;

    public int totalNQueens(int n) {
        count = 0;
        if (n < 1)  return 0;
        boolean[] flag = new boolean[n], flag_45 = new boolean[2 * n - 1], flag_135 = new boolean[2 * n - 1];
        char[][] chess = new char[n][n];
        solve(0, n, flag, flag_45, flag_135);
        return count;
    }

    private void solve(int row, int n, boolean[] flag, boolean[] flag_45, boolean[] flag_135) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++)
            if (! flag[col] && ! flag_45[row + col] && ! flag_135[n - 1 + col - row]) {
                flag[col] = flag_45[row + col] = flag_135[n - 1 + col - row] = true;
                solve(row + 1, n, flag, flag_45, flag_135);
                flag[col] = flag_45[row + col] = flag_135[n - 1 + col - row] = false;
            }
    }
}
