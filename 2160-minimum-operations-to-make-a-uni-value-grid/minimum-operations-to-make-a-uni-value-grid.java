class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int size = n * m;
        int[] arr = new int[size];

        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

        Arrays.sort(arr);
        int num = arr[size / 2];

        int ans = 0;
        for (int i : arr) {

            if (Math.abs(i - num) % x != 0)
                return -1;
            ans += Math.abs(i - num) / x;

        }

        return ans;

    }
}