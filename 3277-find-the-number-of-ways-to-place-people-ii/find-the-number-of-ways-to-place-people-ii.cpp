class Solution {
public:
    int numberOfPairs(vector<vector<int>>& points) {
        sort(points.begin(), points.end(), [](vector<int> a, vector<int> b) {
            if (a[0] < b[0]) {
                return true;
            } else if (a[0] == b[0]) {
                return a[1] > b[1];
            }
            return false;
        });
        int ans = 0;
        for (int i = 0; i < points.size(); i++) {
            int upperY = points[i][1];
            int lowerY = INT_MIN;
            for(int j = i + 1;j<points.size();j++){
                int currY = points[j][1];
                if(currY <= upperY && currY > lowerY){
                    lowerY = currY;
                    ans++;
                    if(currY == upperY) break;
                }
            }
        }
        return ans;
    }
};