class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        Stack<Character> st = new Stack<>();
        int n = num.length();

        for (int i = 0; i < n; i++) {
            char current = num.charAt(i);
            while (!st.empty() && k > 0 && st.peek() > current) {
                st.pop();
                k--;
            }
            if (!st.empty() || current != '0') {
                st.push(current);
            }
        }
        while (k > 0 && !st.empty()) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
