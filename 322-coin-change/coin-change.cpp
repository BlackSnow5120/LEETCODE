class Solution {
public:
    int func(int n ,int tar,vector<int>& nums,vector<vector<int>> &dp)
    {
        if(n<0) return 1e9;
        if(tar==0) return 0;
        if(dp[n][tar] != -1) return dp[n][tar];
        int a = func(n-1,tar,nums,dp);
        int b = 1e9;
        if(nums[n]<=tar) b= 1 + func(n,tar-nums[n],nums,dp);
        return dp[n][tar] = min(a,b);
        
    }
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<vector<int>> dp(n,vector<int>(amount+1,-1));
        int ans = func(n-1,amount,coins,dp);
        return ans>=1e9 ? -1 : ans;
    }
};