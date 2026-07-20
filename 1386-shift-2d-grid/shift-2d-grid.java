class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++)
                row.add(0);
            ans.add(row);
        }

        k %= n * m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i * m + j;
                int newIndex = (index + k) % (n * m);

                int newRow = newIndex / m;
                int newCol = newIndex % m;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return ans;
    }
}