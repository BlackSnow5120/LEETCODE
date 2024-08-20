class Solution {
public:
    int minInsertions(string s) {
        stack<int> s1;
int ans=0;
        for(int i =0 ; i< s.size();i++)
        {
            if(s[i]=='(')
            {
                s1.push(i);
            }
            else
            {
                if(s1.empty()) ans++;
                else s1.pop();

                if(s[i+1] != ')')
                {
                    ans++;
                }
                else
                {
                    i++;
                }

            }
        }
        return ans + s1.size()*2;
    }
};