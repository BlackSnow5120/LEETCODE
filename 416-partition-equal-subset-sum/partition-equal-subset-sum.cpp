class Solution {
public:
    bool func(int n ,int tar,vector<int>& nums,vector<vector<int>> &dp)
    {
        if(n<0 || tar<0) return false;
        if(n==0 && nums[0]==tar) return true;
        if(tar == 0) return true;
        if (dp[n][tar] != -1) return dp[n][tar];
        return dp[n][tar] = func(n-1,tar,nums,dp) || func(n-1,tar-nums[n],nums,dp);
    }
    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int tar = accumulate(nums.begin(), nums.end(), 0);
        if(tar%2 !=0 || n<2) return false;
 vector<vector<int>> dp(n, vector<int>(tar + 1, -1));
        return func(n-1,tar/2,nums,dp);

    }
};