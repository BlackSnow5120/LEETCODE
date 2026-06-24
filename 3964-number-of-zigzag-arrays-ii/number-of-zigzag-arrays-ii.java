import java.util.Arrays;

class Solution {
    private static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) return m;

        int size = 2 * m;

        // 1. Build the Transition Matrix
        long[][] transition = new long[size][size];
        for (int i = 0; i < m; i++) {
            // Top-Right: Current Prefix-state transitions to Next Suffix-state
            for (int j = 0; j < i; j++) {
                transition[i][j + m] = 1;
            }
            // Bottom-Left: Current Suffix-state transitions to Next Prefix-state
            for (int j = i + 1; j < m; j++) {
                transition[i + m][j] = 1;
            }
        }

        // 2. Initialize the Base DP State Vector (all 1s)
        long[][] dp = new long[1][size];
        Arrays.fill(dp[0], 1);

        // 3. Perform Matrix Exponentiation: dp = dp * (transition^(n-1))
        long[][] finalTransition = matrixPower(transition, n - 1, size);
        long[][] finalDp = multiplyMatrices(dp, finalTransition, 1, size, size);

        // 4. Sum up all possible valid ending states
        long totalWays = 0;
        for (int i = 0; i < size; i++) {
            totalWays = (totalWays + finalDp[0][i]) % MOD;
        }

        return (int) totalWays;
    }

    // Helper: Raises a square matrix to a power in O(log p) time
    private long[][] matrixPower(long[][] base, int power, int size) {
        // Initialize result as an Identity Matrix (1s on diagonal, 0s elsewhere)
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) result[i][i] = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, base, size, size, size);
            }
            base = multiplyMatrices(base, base, size, size, size);
            power >>= 1;
        }
        return result;
    }

    // Helper: Standard Matrix Multiplication (A x B) with 0-skipping optimization
    private long[][] multiplyMatrices(long[][] A, long[][] B, int rowsA, int colsA, int colsB) {
        long[][] result = new long[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int k = 0; k < colsA; k++) {
                if (A[i][k] == 0) continue; // Skip multiplication if entry is 0
                
                for (int j = 0; j < colsB; j++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return result;
    }
}