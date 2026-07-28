class Solution {
    public String smallestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        int length = s.length();
        int half = length / 2;
        boolean odd = (length % 2 == 1);

        char[] charArr = s.substring(0, half).toCharArray();
        Arrays.sort(charArr);

        StringBuilder ans = new StringBuilder();

        for (char c : charArr) {
            ans.append(c);
        }

        if (odd) {
            ans.append(s.charAt(half));
        }

        for (int i = half - 1; i >= 0; i--) {
            ans.append(charArr[i]);
        }

        return ans.toString();
    }
}