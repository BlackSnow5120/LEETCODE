import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Case 1: k == 1 -> Maximum element with global frequency == 1
        if (k == 1) {
            int ans = -1;
            for (int num : nums) {
                if (count.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }
            return ans;
        }

        // Case 2: k == n -> Entire array is the only subarray; return max element
        if (k == n) {
            int ans = -1;
            for (int num : nums) {
                ans = Math.max(ans, num);
            }
            return ans;
        }

        // Case 3: 1 < k < n -> Only nums[0] or nums[n-1] can appear in exactly 1 subarray
        int ans = -1;
        if (count.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }
        if (count.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}