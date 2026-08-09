class Solution {
    public int func1(int[] piles, int i, int m, int[] suffixSum, int[][] dp) {
        if (i >= piles.length) {
            return 0;
        }

        // Calculate total remaining stones from current index i to the end
        int totalRemaining = suffixSum[i];

        int maxSum = 0;

        if (dp[i][m] != -1) {
            return dp[i][m];
        }

        // k represents the number of piles taken in this turn (1 <= k <= 2 * m)
        for (int k = 1; k <= 2 * m && i + k <= piles.length; k++) {
            // The opponent will play optimally from index (i + k) with updated M = max(m, k)
            int opponentBest = func1(piles, i + k, Math.max(m, k), suffixSum, dp);

            // Current player's score = total remaining stones - opponent's best score
            maxSum = Math.max(maxSum, totalRemaining - opponentBest);
        }

        return dp[i][m] = maxSum;
    }

    public int stoneGameII(int[] piles) {
        int[] suffixSum = new int[piles.length];
        int sum = 0;
        for (int i = piles.length - 1; i >= 0; i--) {
            sum += piles[i];
            suffixSum[i] = sum;
        }
        int[][] dp = new int[piles.length][piles.length * 2];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return func1(piles, 0, 1, suffixSum, dp);
    }
}