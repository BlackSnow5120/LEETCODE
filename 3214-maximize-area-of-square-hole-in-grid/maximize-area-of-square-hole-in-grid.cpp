class Solution {
public:
    int maximizeSquareHoleArea(int n, int m, vector<int>& hBars,
                               vector<int>& vBars) {
        int counth = 0;
        int counthmax = 1;
        sort(hBars.begin(), hBars.end());
        sort(vBars.begin(), vBars.end());

        for (int i = 1; i < hBars.size(); i++) {
            if (hBars[i] - hBars[i - 1] == 1) {
                counth++;
            } else {
                counthmax = max(counth + 1, counthmax);
                counth = 0;
            }
        }
        counthmax = max(counth + 1, counthmax);
        int county = 0;
        int countymax = 1;
        for (int i = 1; i < vBars.size(); i++) {
            if (vBars[i] - vBars[i - 1] == 1) {
                county++;
            } else {
                countymax = max(county + 1, countymax);
                county = 0;
            }
        }
        countymax = max(county + 1, countymax);
        int len = min(counthmax+1,countymax+1);
        return len*len;
    }
};