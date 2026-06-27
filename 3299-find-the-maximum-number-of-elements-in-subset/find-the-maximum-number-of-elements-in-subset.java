import java.util.HashMap;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.merge(num, 1, Integer::sum);
        }

        // Handle the base case for 1s separately
        int countOfOnes = mp.getOrDefault(1, 0);
        int result = (countOfOnes > 0) ? (countOfOnes % 2 == 0 ? countOfOnes - 1 : countOfOnes) : 1;

        for (int num : nums) {
            if (num == 1) {
                continue;
            }

            int ans = 0;
            long next = num; // Use long to prevent integer overflow when squaring

            // Cache the frequency count to avoid redundant map lookups
            int count = mp.getOrDefault((int) next, 0);
            while (count >= 2) {
                ans += 2;
                next = next * next;
                
                // Break early if we exceed reasonable bounds to prevent endless operations
                if (next > 1_000_000_000) { 
                    count = 0;
                    break;
                }
                count = mp.getOrDefault((int) next, 0);
            }

            if (count == 1) {
                ans += 1;
            } else {
                ans -= 1;
            }
            
            result = Math.max(result, ans);
        }

        return result;
    }
}