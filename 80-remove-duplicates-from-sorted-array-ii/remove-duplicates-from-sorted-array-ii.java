class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int k=0;
        int temp=nums[0];
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]!=temp)
            {
                temp=nums[i];
                count=0;
            }
            if(count<2)
            {
                nums[k++]=nums[i];
            }
            count++;
        }
        return k;

    }
}