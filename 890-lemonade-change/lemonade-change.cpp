class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int size = bills.size();
        int n = 0;
        int bill5 = 0;
        int bill10 = 0;
        while (n < size) {
            if (bills[n] == 5) {
                bill5++;
            } else if (bills[n] == 10) {
                bill10++;
                bill5--;
            } else if (bills[n] == 20) {
                if (bill10 > 0) {
                    bill10--;
                    bill5--;
                } else {
                    bill5 -= 3;
                }
            }
            n++;
            if (bill5 < 0 || bill10 < 0) {
                return false;
            }
        }
        return true;
    }
};