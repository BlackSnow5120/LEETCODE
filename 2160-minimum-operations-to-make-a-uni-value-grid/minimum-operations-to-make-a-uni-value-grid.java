class Solution {
    public int minOperations(int[][] grid, int x) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                l1.add(grid[i][j]);
            }
        }
        int mid = (l1.size()) / 2;
        int mid2 = mid - 1;

        int flag = 0;
        int flag1 = 0;
        l1.sort((a, b) -> Integer.compare(a, b));
        int num = l1.get(mid);
        int num1=0;
        if(mid2<0) num1 = l1.get(mid);
        else num1 = l1.get(mid2);
        int ans = 0;
        int ans1 = 0;
        for (int i : l1) {
            if (flag == 0) {
                if (Math.abs(i - num) % x == 0) {
                    ans += Math.abs(i - num) / x;
                } else {
                    flag = 1;
                }
            }
            if (flag1 == 0) {
                if (Math.abs(i - num1) % x == 0) {
                    ans1 += Math.abs(i - num1) / x;
                } else {
                    flag1 = 1;
                }
            }
        }
        if(flag==0 && flag1==0) return Math.min(ans,ans1);
        if(flag==0) return ans;
        if(flag1==0) return ans1;
        return -1;

    }
}