class Solution {
public:
    int check(vector<vector<int>>& grid1, vector<vector<int>>& grid2, int i,
              int j) {
        if (i < 0 || j < 0 || i == grid1.size() || j == grid1[0].size()) {
            return 1;
        }
        if (grid2[i][j] == 1 && grid1[i][j] == 1) {
            grid2[i][j] = 0;
        } else if (grid2[i][j] == 1 && grid1[i][j] == 0){
            return 0;}
        else {
            return 1;
        }
        int a = check(grid1, grid2, i + 1, j);
        int b = check(grid1, grid2, i, j + 1);
        int c = check(grid1, grid2, i, j - 1);
        int d = check(grid1, grid2, i - 1, j);
        return 1 && a && b && c && d;
    }
    int countSubIslands(vector<vector<int>>& grid1,
                        vector<vector<int>>& grid2) {
        int ans = 0;
        for (int i = 0; i < grid2.size(); i++) {
            for (int j = 0; j < grid2[0].size(); j++) {
                if (grid2[i][j]==1 && check(grid1, grid2, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }
};