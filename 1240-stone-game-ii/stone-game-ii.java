import java.util.Arrays;

class Solution {
    public int func1(int[] piles, int i, int m, int[][] dp) {
        if (i >= piles.length) {
            return 0;
        }

        if (dp[i][m] != Integer.MIN_VALUE) {
            return dp[i][m];
        }

        int currentTake = 0;
        int maxDiff = Integer.MIN_VALUE;

        // Try taking k piles (1 <= k <= 2 * m)
        for (int k = 1; k <= 2 * m && i + k <= piles.length; k++) {
            currentTake += piles[i + k - 1]; // Accumulate on the fly
            
            int opponentDiff = func1(piles, i + k, Math.max(m, k), dp);
            
            maxDiff = Math.max(maxDiff, currentTake - opponentDiff);
        }

        return dp[i][m] = maxDiff;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int totalSum = 0;
        for (int pile : piles) {
            totalSum += pile;
        }

        // dp[i][m] stores the maximum score difference starting from index i with M = m
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        int maxDiff = func1(piles, 0, 1, dp);

        // Convert (Alice - Bob) difference into Alice's total stones
        return (totalSum + maxDiff) / 2;
    }
}