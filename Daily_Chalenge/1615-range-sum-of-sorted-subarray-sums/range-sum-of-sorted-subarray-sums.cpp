class Solution {
public:
    int rangeSum(vector<int>& nums, int n, int left, int right) {
        vector <int> sums;
        int sum=0;
        for(int i = 0 ;i <nums.size();i++)
        {
            sum=0;
            for(int j = i ;j <nums.size();j++)
            {
                sum+=nums[j];
                sums.push_back(sum);
            }
        }
        sort(sums.begin(),sums.end());
        int ans=0;
        int MOD = 1000000007;
        for(int i=left-1;i<right;i++)
        {
            ans= (ans + sums[i]) % MOD;
        }
        return ans;
    }
};