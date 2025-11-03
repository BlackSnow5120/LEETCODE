class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        int n = colors.size();
        int ans = 0;
        int maxTime = 0;
        int totalTime = 0;
        int count = 0;
        char col = colors[0];
        for (int j = 0; j < n; j++) {
            if (col != colors[j]) {
                
                if (count > 1) {
                    ans += totalTime - maxTime;
                }
                col = colors[j];
                count = 0;
                maxTime = 0;
                totalTime=0;
            }
            count++;
            maxTime = max(maxTime, neededTime[j]);
            totalTime += neededTime[j];
        }
        if (count > 1) {
            ans += totalTime - maxTime;
        }
        return ans;
    }
};