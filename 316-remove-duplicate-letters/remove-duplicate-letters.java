class Solution {
    public String removeDuplicateLetters(String s) {
        int lastind[] = new int[26];
        boolean count[] = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            lastind[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (count[curr - 'a'] == true)
                continue;
            while (!st.empty() && curr <= st.peek() && lastind[st.peek() - 'a'] > i) {
                count[st.peek() - 'a'] = false;
                st.pop();
            }

            st.push(curr);
            count[curr - 'a'] = true;

        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty())
            sb.append(st.pop());

        return sb.reverse().toString();
    }
}