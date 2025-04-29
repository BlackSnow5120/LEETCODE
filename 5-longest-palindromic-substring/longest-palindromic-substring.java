class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) dp[i][i] = true;

        for (int end = 1; end < n; end++) {
            for (int begin = 0; begin < end; begin++) {
                if (s.charAt(begin) == s.charAt(end)) {
                    if (end - begin == 1 || dp[begin + 1][end - 1]) {
                        dp[begin][end] = true;

                        if (end - begin + 1 > maxLen) {
                            maxLen = end - begin + 1;
                            start = begin;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
