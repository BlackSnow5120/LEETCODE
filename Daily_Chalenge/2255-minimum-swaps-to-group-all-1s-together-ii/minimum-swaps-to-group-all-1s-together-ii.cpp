class Solution {
public:
    int minSwaps(vector<int>& nums) {
        int count=0,k=0,j=0;
        for(auto i : nums)
        {
            if(i == 1)
            {
                count++;
            }
        }
        int ans=INT_MAX,tempans=0,tempcount = count,size=nums.size();
        for(int i = 0;i<nums.size();i++)
        {
            while(tempcount > 0)
            {
                if(k==size){k-=size;}
                if(nums[k++]==0)
                {
                    tempans++;
                }
                tempcount--;
            }
            ans = min(tempans,ans);
            if(nums[i]==0)
            {
                tempans--;
            }
            tempcount++;
        }
        return ans;
    }
};