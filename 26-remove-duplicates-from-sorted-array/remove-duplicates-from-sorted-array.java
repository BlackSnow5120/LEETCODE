class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int size = nums.length;
        int ans = 0;
        for(int j = 1;j<size;j++)
        {
            if(nums[i]!=nums[j])
            {
                
                nums[ans++] = nums[i];
                i=j;
            } 
        }
        nums[ans++] = nums[i];
        return ans;
    }
}