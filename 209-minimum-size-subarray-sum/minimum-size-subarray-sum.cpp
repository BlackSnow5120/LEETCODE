class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int i  = 0;
        int j = 0;
        int size = nums.size();
        int temp_sum=0;
        int ans=INT_MAX;
        while(j<size)
        {

            temp_sum+=nums[j++];
            while(temp_sum>=target)
            {
                // cout<<temp_sum<<i<<j<<endl;
                ans=min(ans,abs(i-j));
                temp_sum-=nums[i++];
            }
        }
        if(ans==INT_MAX){return 0;}
        return ans;

    }
};