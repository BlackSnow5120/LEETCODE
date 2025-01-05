class Solution {
public:
    int func(int i,int j,string &s,string &ss,vector<vector<int>> &dp)
    {
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s[i]==ss[j]) return dp[i][j] = 1 + func(i-1,j-1,s,ss,dp);
        else return dp[i][j] = max(func(i-1,j,s,ss,dp),func(i,j-1,s,ss,dp));
    }
    int minInsertions(string s) {
        int n = s.size();
        string ss = s;
        reverse(s.begin(),s.end());
        vector<vector<int>> dp (n,vector<int>(n,-1));
        return n - func( n-1, n-1, s, ss,dp);
    }
};