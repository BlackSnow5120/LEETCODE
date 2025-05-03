class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int len = nums.length;

        int ans[] = new int[len];

        for(int i = len-1;i>=0;i--)
        {
            st.push(nums[i]);
        }
        for(int i = len-1;i>=0;i--)
        {
            while(!st.empty() && nums[i]>=st.peek())
            {
                st.pop();
            }
            if(st.empty())
            {
                ans[i]=-1;
            }
            else
            {
                ans[i]=st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
}