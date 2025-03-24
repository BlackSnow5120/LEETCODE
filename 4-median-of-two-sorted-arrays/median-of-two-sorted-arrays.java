class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int total = n + m;
        int target = total / 2;
        boolean isEven = (total % 2 == 0);
        
        int i = 0, j = 0, count = 0;
        int prev = 0, curr = 0;
        
        while (count <= target) {
            prev = curr; // Store previous value to handle even-length case
            if (i < n && (j >= m || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
            count++;
        }

        // If total length is even, return the average of two middle values
        if (isEven) {
            return (prev + curr) / 2.0;
        }
        
        return curr;
    }
}
