class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        unordered_map<int,int> mp;

        for(auto i : nums){
            mp[i]=1;
        }
        int ans = original;
        while(mp[ans]==1){
            ans=ans*2;
        }
        return ans;
    }
};