class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;

        int maxReach = nums[0];
        int t = nums[0];
        int steps = 1;

        for (int i = 1; i < n; i++) {
            if (i > maxReach)
                return -1; // unreachable
            if (i > t) {
                steps++;
                t = maxReach;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return steps;
    }
}