class Solution {
        public void dfs(int[][] board, int i, int j, int[][] arr, int m, int n) {
        arr[i][j] = 1;

        int[] delrow = {0, 1, 0, -1};
        int[] delcol = {1, 0, -1, 0};

        for (int k = 0; k < 4; k++) {
            int nrow = i + delrow[k];
            int ncol = j + delcol[k];

            if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && board[nrow][ncol] == 1 && arr[nrow][ncol] == 0) {
                dfs(board, nrow, ncol, arr, m, n);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n]; // Array to track visited cells

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && arr[i][0] == 0) dfs(grid, i, 0, arr, m, n);
            if (grid[i][n - 1] == 1 && arr[i][n - 1] == 0) dfs(grid, i, n - 1, arr, m, n);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && arr[0][j] == 0) dfs(grid, 0, j, arr, m, n);
            if (grid[m - 1][j] == 1 && arr[m - 1][j] == 0) dfs(grid, m - 1, j, arr, m, n);
        }
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && arr[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}