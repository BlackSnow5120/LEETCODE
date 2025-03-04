class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
                int low = 0;
        int high = nums.size()-1;
        int mid=0;
  
        while(low<=high)
        {
            mid =low + (high - low) / 2;
            if(nums[mid] == target)
            {
                while(nums[low]!=target && low>=-1) low+=1;
                while(nums[high]!=target && high>=-1) high-=1;
                return {low,high};
            }

            if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        

        return {-1,-1};
    }
};