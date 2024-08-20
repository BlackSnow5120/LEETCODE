class Solution {
public:
    int scoreOfParentheses(string s) {
        int ans = 0;
        int tempans = 0;
        stack<int> st;
        for (auto i : s) {
            if (i == '(') {
                st.push(0);
            } else {

                int a = 0;
                while (st.top() != 0) {
                    a += st.top();
                    st.pop();
                }
                st.pop();
                if((2*a)==0)
                {
                    st.push(1);
                }
                else
                {
                st.push(2 * a);
                }
            }
        }
        while(!st.empty())
        {
            ans+=st.top();
            st.pop();
        }
        return ans;
    }
};