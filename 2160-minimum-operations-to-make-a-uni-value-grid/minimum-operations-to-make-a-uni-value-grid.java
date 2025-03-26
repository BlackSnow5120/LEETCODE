
class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int size = n * m;
        int[] arr = new int[size];

        // Flatten the grid into an array
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

        // Sort the array to find the median
        Arrays.sort(arr);
        int median = arr[size / 2];

        // Calculate operations
        int operations = 0;
        for (int num : arr) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1;  // If transformation is impossible
            operations += diff / x;
        }

        return operations;
    }
}
