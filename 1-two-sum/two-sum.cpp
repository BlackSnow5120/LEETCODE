class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> mp;
        int j=1;
        for(int i : nums)
        {
            mp[i]=j++;
        }
        for(int i=0;i<nums.size();i++)
        {
            if(mp[target - nums[i]]!=0)
            {
                if(mp[target - nums[i]]-1 != i)
                {
                return {i,mp[target - nums[i]]-1};
                }
            }
        }
        return{0,0};
    }
};