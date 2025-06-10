class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int k = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(mp.getOrDefault(nums[i],0)==0)
            {
                nums[k++]=nums[i];
                mp.put(nums[i],1);
            }
        }
        return k;
    }
}