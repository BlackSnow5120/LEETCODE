class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            mp1.put(s1.charAt(i), mp1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            mp2.put(rightChar, mp2.getOrDefault(rightChar, 0) + 1);
            while (left <= right && mp2.get(s2.charAt(right)) > mp1.getOrDefault(s2.charAt(right), 0)) {
                mp2.put(s2.charAt(left), mp2.get(s2.charAt(left)) - 1);
                left++;
            }
            if (right-left + 1 == s1.length()) {
                return true;
            }
            right++;
        }
        return false;

    }
}