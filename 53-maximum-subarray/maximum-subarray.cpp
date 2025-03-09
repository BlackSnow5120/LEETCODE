class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> vec;
        int temp = 0;
        int maxnum=0;
        int ans=INT_MIN;
        for(auto i : nums)
        {
            maxnum=max(temp+i,i);
            temp=maxnum;
            ans=max(ans,maxnum);
        }
        return ans;
        
    }
};