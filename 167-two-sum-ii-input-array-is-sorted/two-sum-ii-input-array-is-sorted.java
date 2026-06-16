class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement exists, we found our pair
            if (mp.containsKey(complement)) {
                return new int[]{mp.get(complement), i+1};
            }
            
            // Otherwise, put the current number and index in the map
            mp.put(nums[i], i+1);
        }
        
        return new int[]{0, 0}; 
    }
}