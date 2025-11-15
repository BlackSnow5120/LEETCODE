class Solution {
public:
static int comp(vector<int> &a,vector<int> &b){
    if(a[0]==b[0]){
        return a[1]<b[1];
    }
    return a[0]<b[0];
}
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end(),comp);
        vector<vector<int>> ans;
        int low=intervals[0][0];
        int high=intervals[0][1];
        for(int i=1;i<intervals.size();i++){
            if(intervals[i][0]<=high){
                high=max(high,intervals[i][1]);
            }else{
                ans.push_back({low,high});
                low=intervals[i][0];
                high=intervals[i][1];
            }
        }
         ans.push_back({low,high});
         return ans;

    }
};