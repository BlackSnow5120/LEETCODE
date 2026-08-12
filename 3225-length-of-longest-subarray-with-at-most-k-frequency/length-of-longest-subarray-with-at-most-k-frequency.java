class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        HashMap<Integer, Integer> mp1 = new HashMap<>();
        int ansi = 0;
        int ansj = 0;
        for (int j = 0; j < nums.length; j++) {
            mp1.put(nums[j], mp1.getOrDefault(nums[j], 0) + 1);
            if (mp1.getOrDefault(nums[j], 0) > k) {
                
                while (mp1.get(nums[j])>k) {
                System.out.println(i);

                    mp1.put(nums[i], mp1.getOrDefault(nums[i], 0) - 1);
                    i++;

                }
            }
                // System.out.println(i);

            if (j - i > ansj - ansi) {
                ansi = i;
                ansj = j;
            }
        }

        return ansj - ansi +1;
    }
}