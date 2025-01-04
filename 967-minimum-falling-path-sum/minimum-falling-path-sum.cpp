class Solution {
public:
    int func(int i, int j, vector<vector<int>>& dp, int m, vector<vector<int>>& grid) {
        if (j < 0 || j >= m) return INT_MAX; // Out of bounds for columns
        if (i == m - 1) return grid[i][j];  // Base case: bottom row
        if (dp[i][j] != INT_MIN) return dp[i][j]; // Return memoized result

        int down = func(i + 1, j, dp,m, grid);
        int left = func(i + 1, j - 1, dp, m,grid);
        int right = func(i + 1, j + 1, dp, m,grid);

        return dp[i][j]= grid[i][j] + min(down,min(right,left));
    }
int minFallingPathSum(vector<vector<int>>& matrix) {
        int n=matrix.size();
        vector<vector<int>> dp(n,vector<int>(n,INT_MIN));
        int ans=INT_MAX;
        for(int i=0;i<n;i++){
            ans=min(ans,func(0,i,dp,n,matrix));
        }
        return ans;
    }
};
