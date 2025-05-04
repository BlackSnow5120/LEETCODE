class Solution {
    public int sumSubarrayMins(int[] nums) {
        int n = nums.length;
        long summin = 0; 
        long mod = 1_000_000_007;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MIN_VALUE : nums[i];
            while (!st.isEmpty() && nums[st.peek()] > curr) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (long)(mid - left) * (right - mid);
                summin = (summin + (count * nums[mid]) % mod) % mod;
            }
            st.push(i);
        }

        return (int) summin;
    }
}
