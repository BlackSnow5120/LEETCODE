import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // 1. Automatically sort and remove duplicates
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        
        // 2. Map each unique number to its rank 
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : set) {
            rankMap.put(num, rank);
            rank++; // Increment rank for the next unique, larger number
        }
        
        // 3. Build the final answer array using O(1) lookups
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = rankMap.get(arr[i]);
        }
        
        return ans;
    }
}
