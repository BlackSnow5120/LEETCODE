class Solution {
public:
    string minRemoveToMakeValid(string s) {
        stack<int> s1;

        for(int i=0; i<s.size();i++)
        {
            if(s[i]=='(')
            {
                s1.push(i);
            }
            else if(s[i]==')')
            {
                if(s1.empty())
                {
                    s[i]=' ';
                }
                else
                {
                    s1.pop();
                }
            }
        }
        while(!s1.empty())
        {
            s[s1.top()]=' ';
            s1.pop();
        }
        string ans;
        for(auto i : s)
        {
            if(i != ' ')
            {
                ans+=i;
            }
        }
        return ans;
    }
};