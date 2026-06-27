class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.merge(num, 1, Integer::sum);
        }

        int countOfOnes = mp.getOrDefault(1, 0);
        int result = (countOfOnes > 0) ? (countOfOnes % 2 == 0 ? countOfOnes - 1 : countOfOnes) : 1;

        for (int num : nums) {
            if (num == 1) {
                continue;
            }
            int ans = 0;
            long next = num;
            int count = mp.getOrDefault((int) next, 0);
            while (count >= 2) {
                ans += 2;
                next = next * next;
                count = mp.getOrDefault((int) next, 0);
            }

            if (count == 1) {
                ans += 1;
            } else {
                ans -= 1;
            }
            
            result = Math.max(result, ans);
        }

        return result;
    }
}