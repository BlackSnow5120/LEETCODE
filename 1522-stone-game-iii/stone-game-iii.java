import java.util.Arrays;

class Solution {
    public int maxDiff(int[] stoneValue, int i, int[] memo) {
        int n = stoneValue.length;

        // Base case: No stones left to pick
        if (i >= n) {
            return 0;
        }

        // Return memoized result
        if (memo[i] != Integer.MIN_VALUE) {
            return memo[i];
        }

        int res = Integer.MIN_VALUE;
        int currentTakenSum = 0;

        for (int k = 1; k <= 3 && i + k - 1 < n; k++) {
            currentTakenSum += stoneValue[i + k - 1];
            
            int optionScore = currentTakenSum - maxDiff(stoneValue, i + k, memo);
            res = Math.max(res, optionScore);
        }

        memo[i] = res;
        return memo[i];
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] memo = new int[n];
        
        Arrays.fill(memo, Integer.MIN_VALUE);

        int diff = maxDiff(stoneValue, 0, memo);

        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}