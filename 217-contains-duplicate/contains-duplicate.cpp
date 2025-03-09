class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map <int,int> mp;
        for(auto i:nums)
        {
            if(mp[i]==0)
            {
                mp[i]=1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
};