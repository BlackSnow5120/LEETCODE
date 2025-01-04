class Solution {
public:
    int func(int i,int j ,vector<vector<int>> &dp,int m,int n,vector<vector<int>>& ob)
    {
        if(i==m || j==n || ob[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!= -1) return dp[i][j];
        int down = func(i+1,j,dp,m,n,ob);
        int right = func(i,j+1,dp,m,n,ob);
        dp[i][j] = down + right;
        return dp[i][j];
    }
    int uniquePathsWithObstacles(vector<vector<int>>& ob) {
        int m = ob.size();
        int n= ob[0].size();
        vector<vector<int>> dp(m,vector<int>(n,-1));
        return func(0,0,dp,m,n,ob);
    }
};