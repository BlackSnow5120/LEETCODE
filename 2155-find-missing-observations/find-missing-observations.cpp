class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        int sum = accumulate(rolls.begin(),rolls.end(),0);
        int num = (mean*(rolls.size() + n)) - sum;
        vector<int> ans;
        int a = num/n;
        if(a>6 || a < 1){return {};}
        for(int i = 0; i< n; i++)
        {
            ans.push_back(a);
        }
        int b = num%n;
        for(int i = 0 ; i< ans.size();i++)
        {
            if(b)
            {
                ans[i]++;
                b--;
                if(ans[i]>6)
                {
                    return {};
                }
            }
        }
        return ans;
    }
};