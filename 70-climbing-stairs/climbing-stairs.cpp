class Solution {
public:
    int func(int n, vector<int> &dp)
    {
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=0) return dp[n];
        int step1 = func(n-1,dp);
        int step2 = func(n-2,dp);
        dp[n] = step1 + step2;
        return dp[n];

    }
    int climbStairs(int n) {
        vector<int> dp = vector<int>(n+1,0);
        return func(n,dp);
    }
};