public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    if (n < 1)  return res;
    boolean[] flag = new boolean[n], flag_45 = new boolean[2 * n - 1], flag_135 = new boolean[2 * n - 1];
    char[][] chess = new char[n][n];
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            chess[i][j] = '.';
    solve(res, chess, 0, n, flag, flag_45, flag_135);
    return res;
}

private void solve(List<List<String>> res, char[][] chess, int row, int n, boolean[] flag, boolean[] flag_45, boolean[] flag_135) {
    if (row == n) {
        res.add(construct(chess));
        return;
    }
    for (int col = 0; col < n; col++)
        if (! flag[col] && ! flag_45[row + col] && ! flag_135[n - 1 + col - row]) {
            chess[row][col] = 'Q';
            flag[col] = flag_45[row + col] = flag_135[n - 1 + col - row] = true;
            solve(res, chess, row + 1, n, flag, flag_45, flag_135);
            chess[row][col] = '.';
            flag[col] = flag_45[row + col] = flag_135[n - 1 + col - row] = false;
        }
}

private List<String> construct(char[][] chess) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < chess.length; i++)
        res.add(new String(chess[i]));
    return res;
}
