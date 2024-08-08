class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        int total = n * m;

        int firstRow = 0;
        int lastRow = n - 1;
        int firstCol = 0;
        int lastCol = m - 1;

        int count = 0;
        vector<int> ans;
        while (count < total) {
            for (int i = firstCol; count < total && i <= lastCol; i++) {
                ans.push_back(matrix[firstRow][i]);
                ++count;
            }
            firstRow++;

            for (int i = firstRow; count < total && i <= lastRow; i++) {
                ans.push_back(matrix[i][lastCol]);
                ++count;
            }
            lastCol--;

            for (int i = lastCol; count < total && i >= firstCol; i--) {
                ans.push_back(matrix[lastRow][i]);
                ++count;
            }
            lastRow--;

            for (int i = lastRow; count < total && i >= firstRow; i--) {
                ans.push_back(matrix[i][firstCol]);
                ++count;
            }
            firstCol++;
        }

        return ans;
    }
};