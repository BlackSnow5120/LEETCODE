class Solution {
public:
    int func(int i,int j ,vector<vector<int>> &dp,int m,int n,vector<vector<int>>& ob)
    {
        if(i==m || j==n) return 9999999;
        if(i==m-1) return ob[i][j];
        if(dp[i][j]!= -1) return dp[i][j];
        int down = func(i+1,j,dp,m,n,ob);
        int right = func(i+1,j+1,dp,m,n,ob);
        dp[i][j] = ob[i][j] + min(down,right);
        return dp[i][j];
    }
    int minimumTotal(vector<vector<int>>& grid) {
        int m = grid.size();
        int n= grid[m-1].size();
        vector<vector<int>> dp(m,vector<int>(n,-1));
        return func(0,0,dp,m,n,grid);
    }
};