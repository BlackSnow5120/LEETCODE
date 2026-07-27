class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        int max1Ind = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                max1Ind = i;
            }
        }
        int max2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max2 && i != max1Ind) {
                max2 = nums[i];
            }
        }
        if (max2 == -1) {
            max2 = max;
        }
        return (max2 - 1) * (max - 1);

    }
}