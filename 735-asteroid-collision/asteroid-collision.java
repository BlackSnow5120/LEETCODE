class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for(int i =0;i<arr.length;i++)
        {
            int des=0;
            while(!st.empty() && des==0 && arr[st.peek()]>=0 && arr[i]<0)
            {
                if(arr[st.peek()]+arr[i]<0) st.pop();
                else if(arr[st.peek()]+arr[i]>0) des=1;
                else
                {
                    des=1;
                    st.pop();
                }
            }
            if(des==0) st.push(i);

        }
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = arr[st.pop()];
        }

        return result;
    }
}