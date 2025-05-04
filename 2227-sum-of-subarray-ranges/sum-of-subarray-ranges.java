class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long summin = 0;
        long summax = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MIN_VALUE : nums[i];
            while (!st.isEmpty() && nums[st.peek()] > curr) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (long)(mid - left) * (right - mid);
                summin += count * nums[mid];
            }
            st.push(i);
        }

        st.clear();

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MAX_VALUE : nums[i];
            while (!st.isEmpty() && nums[st.peek()] < curr) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (long)(mid - left) * (right - mid);
                summax += count * nums[mid];
            }
            st.push(i);
        }

        return summax - summin;
    }
}
