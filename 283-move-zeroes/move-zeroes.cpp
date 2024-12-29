class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i = 0;
        int len = nums.size();
        int zero = 0;
        while (i < len) {
            if (nums[i] == 0) {
                nums.erase(nums.begin() + i);
                len--; 
                zero++;
            } else {
                i++; 
            }
        }
        for (int j = 0;j<zero;j++) {
            nums.push_back(0);
        }
    }
};
