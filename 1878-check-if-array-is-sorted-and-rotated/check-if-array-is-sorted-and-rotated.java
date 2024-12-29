class Solution {
    public boolean check(int[] nums) {
        int size = nums.length;

        if (size < 2) return true;

        int rotationCount = 0;

        for (int i = 0; i < size; i++) {
            if (nums[i] > nums[(i + 1) % size]) {
                rotationCount++;
            }

            if (rotationCount > 1) return false;
        }

        return true;
    }

}