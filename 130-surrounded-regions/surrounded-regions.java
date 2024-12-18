class Solution {
    public void dfs(char[][] board, int i, int j, int[][] arr, int m, int n) {
        // Mark the current cell as visited in arr
        arr[i][j] = 1;

        // Directions for exploring the neighbors (up, down, left, right)
        int[] delrow = {0, 1, 0, -1};
        int[] delcol = {1, 0, -1, 0};

        // Explore all 4 possible directions
        for (int k = 0; k < 4; k++) {
            int nrow = i + delrow[k];
            int ncol = j + delcol[k];

            // Check for valid bounds and if the neighboring cell is 'O' and not visited
            if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && board[nrow][ncol] == 'O' && arr[nrow][ncol] == 0) {
                // Recursively call DFS for the valid neighbor
                dfs(board, nrow, ncol, arr, m, n);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] arr = new int[m][n]; // Array to track visited cells

        // Perform DFS on the border cells (first and last row, first and last column)
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && arr[i][0] == 0) dfs(board, i, 0, arr, m, n);
            if (board[i][n - 1] == 'O' && arr[i][n - 1] == 0) dfs(board, i, n - 1, arr, m, n);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && arr[0][j] == 0) dfs(board, 0, j, arr, m, n);
            if (board[m - 1][j] == 'O' && arr[m - 1][j] == 0) dfs(board, m - 1, j, arr, m, n);
        }

        // After DFS, mark the unvisited 'O' cells as 'X' (surrounded regions)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell is 'O' and not visited, mark it as 'X'
                if (board[i][j] == 'O' && arr[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

        // Optionally, you could revert back the unmarked 'O' cells (connected to borders) to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
