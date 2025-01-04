class Solution {
public:
    int func(int i,int j ,vector<vector<int>> &dp,int m,int n)
    {
        if(i==m || j==n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!= -1) return dp[i][j];
        int down = func(i+1,j,dp,m,n);
        int right = func(i,j+1,dp,m,n);
        dp[i][j] = down + right;
        return dp[i][j];
    }
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m,vector<int>(n,-1));
        return func(0,0,dp,m,n);
    }
};