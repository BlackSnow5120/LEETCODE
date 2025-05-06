class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!st.empty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if (st.empty())
                    break;
                int left = st.peek();
                int width = i - left - 1;
                int w1 = Math.min(height[i], height[left]) - height[top];

                ans += w1 * width;

            }
            st.push(i);
        }
        return ans;
    }
}