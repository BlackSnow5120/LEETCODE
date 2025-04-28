class Solution {
    public int func(int i, int j, int[][] grid, int count) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Out of bounds or obstacle
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == -1) {
            return 0;
        }
        
        // If reached end
        if (grid[i][j] == 2) {
            if (count == 0) {
                return 1; // All non-obstacle cells visited
            } else {
                return 0; // Not all cells visited
            }
        }
        
        // Mark current cell visited
        grid[i][j] = -1;
        
        int up = func(i - 1, j, grid, count - 1);
        int down = func(i + 1, j, grid, count - 1);
        int left = func(i, j - 1, grid, count - 1);
        int right = func(i, j + 1, grid, count - 1);
        
        // Backtrack
        grid[i][j] = 0;
        
        return up + down + left + right;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int startI = 0, startJ = 0;
        int count = 0;
        
        // Find start position and count non-obstacle cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != -1) {
                    count++;
                }
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        }
        
        return func(startI, startJ, grid, count - 1); 
        // count-1 because start cell is counted already
    }
}
