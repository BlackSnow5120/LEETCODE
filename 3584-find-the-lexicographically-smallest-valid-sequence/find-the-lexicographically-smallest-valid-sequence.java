class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int count = 0;
        int[] suffixArray = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            suffixArray[i] = count;
            if (count < m && word1.charAt(i) == word2.charAt(m - 1 - count)) {
                count++;
            }
        }
        int[] ans = new int[m];
        int j = 0;
        boolean changes = false;
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } else if (!changes && suffixArray[i] >= m - 1 - j) {
                ans[j++] = i;

                changes = true;
            }

        }
        if (j == m) {
            return ans;
        }

        return new int[] {};
    }
}