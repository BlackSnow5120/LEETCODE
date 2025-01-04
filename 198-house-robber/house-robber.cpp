class Solution {
public:
    int func(int n, vector<int>& dp, vector<int>& nums) {
        if (n < 0) return 0; 
        if (dp[n] != -1) return dp[n];
        
        int robCurrent = nums[n] + func(n - 2, dp, nums); 
        int skipCurrent = func(n - 1, dp, nums);          
        
        dp[n] = max(robCurrent, skipCurrent); 
        return dp[n];
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n, -1); 
        return func(n - 1, dp, nums); 
    }
};
