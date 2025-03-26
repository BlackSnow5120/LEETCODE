class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                l1.add(grid[i][j]);
            }
        }
        int mid = (l1.size()) / 2;
        int flag = 0;
        l1.sort((a, b) -> Integer.compare(a, b));
        int num = l1.get(mid);
        int ans = 0;
        for (int i : l1) {
            if (flag == 0) {
                if (Math.abs(i - num) % x == 0) {
                    ans += Math.abs(i - num) / x;
                } else {
                    flag = 1;
                }
            }
        }
        if(flag==0) return ans;
        return -1;

    }
}