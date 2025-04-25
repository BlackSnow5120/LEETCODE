class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int maxUnbalanced = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else { 
                balance--;
                if (balance < 0) {
                    maxUnbalanced = Math.max(maxUnbalanced, -balance);
                }
            }
        }

        return (maxUnbalanced + 1) / 2;
    }
}
