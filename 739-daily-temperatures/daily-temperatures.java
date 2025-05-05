class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int ans[] = new int[n];

        for(int i =0;i<n;i++)
        {
            while(!st.empty() && arr[i]>arr[st.peek()])
            {
                int tempind = st.pop();
                ans[tempind] = i-tempind;
            }
            st.push(i);
        }
        while(!st.empty())
        {
            ans[st.pop()]=0;

        }
        return ans;

    }
}