class Solution {
public:
    int func(int n, vector<int>& dp, vector<int>& nums,int j) {
        if (n < j) return 0; 
        if (dp[n] != -1) return dp[n];
        
        int robCurrent = nums[n] + func(n - 2, dp, nums,j); 
        int skipCurrent = func(n - 1, dp, nums,j);          
        
        dp[n] = max(robCurrent, skipCurrent); 
        return dp[n];
    }

    int rob(vector<int>& nums) {

        int n = nums.size();
        if(n==1) return nums[0];
        if(n==2) return max(nums[0],nums[1]);
        vector<int> dp(n, -1); 
        vector<int> dp1(n, -1); 
        return max(func(n - 1, dp, nums,1),func(n-2,dp1,nums,0)); 
    }
};
