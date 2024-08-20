class Solution {
public:
    int minAddToMakeValid(string s) {
        int a=0;
        int ans=0;
        for(auto i : s)
        {
            if(i == '(') a++;
            else
            {
                if(a) a--;
                else
                {
                    ans++;
                }
            }
        }
        return ans+a;
    }
};