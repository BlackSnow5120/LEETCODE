class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int sum=0;
        vector<vector<int>> cat(3,vector<int>());
        for(int i =0;i<nums.size();i++){
            sum+=nums[i];
            cat[nums[i]%3].push_back(nums[i]);
        }
        int req = sum%3;
        if(req==1){
            int a = INT_MAX,b=INT_MAX;
            if(cat[2].size()>1 ){
                a = cat[2][0] + cat[2][1];
            }
            if(cat[1].size()>0){
                b = cat[1][0];
            }
            return sum - min(a,b);
        }
        if(req==2){
            int a = INT_MAX,b=INT_MAX;
            if(cat[1].size()>1 ){
                a = cat[1][0] + cat[1][1];
            }
            if(cat[2].size()>0){
                b = cat[2][0];
            }
            return sum - min(a,b);
        }
        return sum;
    }
};