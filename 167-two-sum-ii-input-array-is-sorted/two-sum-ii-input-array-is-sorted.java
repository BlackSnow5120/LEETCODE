class Solution {
    public int[] twoSum(int[] nums, int tar) {
        int i =0;
        int j = nums.length-1;

        while(i<j)
        {
            int curr = nums[i]+nums[j];
            if(curr == tar) break;
            if(curr<tar) i++;
            else j--;
        }
        int ans[] = new int[2];
        ans[0]=i+1;
        ans[1]=j+1;
        return ans;
    }
}