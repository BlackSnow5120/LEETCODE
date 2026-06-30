class Solution {
    public int numberOfSubstrings(String s) {
        int i = -1;
        int j = 0;
        int length = s.length();
         int[] count = new int[3]; 
        int ans = 0;
        while (i < j && j < s.length()) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += length - j;
                i++;
                count[s.charAt(i) - 'a']--;
            }
            j++;
        }
        return ans;
    }
}