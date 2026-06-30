class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = -1;
        int j = 0;
        int length = s.length();
        mp.put('a', 0);
        mp.put('b', 0);
        mp.put('c', 0);
        int ans = 0;
        while (i < j && j < s.length()) {
            mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
            while (mp.get('a') > 0 && mp.get('b') > 0 && mp.get('c') > 0) {
                ans += length - j;
                i++;
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
            }
            j++;
        }
        return ans;
    }
}