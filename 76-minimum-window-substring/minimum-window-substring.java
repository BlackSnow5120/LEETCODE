class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int left = 0;

        HashMap<Character, Integer> mp1 = new HashMap<>();

        // Build frequency map from t (not s)
        for (int i = 0; i < t.length(); i++) {
            mp1.put(t.charAt(i), mp1.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = t.length();
        int ansLeft = 0;
        int ansRight = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char curr = s.charAt(right);

            if (mp1.containsKey(curr)) {
                if (mp1.get(curr) > 0)
                    count--;

                mp1.put(curr, mp1.get(curr) - 1);
            }

            while (count == 0) {

                // Update answer
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }

                char leftChar = s.charAt(left);

                if (mp1.containsKey(leftChar)) {
                    mp1.put(leftChar, mp1.get(leftChar) + 1);

                    if (mp1.get(leftChar) > 0)
                        count++;
                }

                left++;
            }
        }

        return ansRight == Integer.MAX_VALUE
                ? ""
                : s.substring(ansLeft, ansRight + 1);
    }
}