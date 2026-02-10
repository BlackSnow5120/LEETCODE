class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] results = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> hs1 = new HashMap<>();
        Arrays.fill(results, -1);
        for (int i = nums2.length - 1; i >= 0; i--) {
            hs1.put(nums2[i], i);
            while (!st.empty() && nums2[i] > nums2[st.peek()]) {
                st.pop();
            }
            if (!st.empty()) {
                results[i] = nums2[st.peek()];
            }
            st.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = results[hs1.get(nums1[i])];
        }
        return nums1;

    }
}