class Solution {
    public boolean func(int[] nums, int i, int j, int score1, int score2, boolean player1) {
        // ✅ CORRECTED RECURSION
        if (i == j) {
            if (player1)
                return (score1 + nums[i]) >= score2;
            else
                return score1 >= (score2 + nums[i]);
        }
        if (player1) {
            boolean a = func(nums, i + 1, j, score1 + nums[i], score2, false);
            boolean b = func(nums, i, j - 1, score1 + nums[j], score2, false);
            return a || b; // Player 1 seeks ANY winning path
        } else {
            boolean a = func(nums, i + 1, j, score1, score2 + nums[i], true);
            boolean b = func(nums, i, j - 1, score1, score2 + nums[j], true);
            return a && b; // Player 2 tries to block Player 1 on BOTH paths
        }
    }

    public boolean predictTheWinner(int[] nums) {

        return func(nums, 0, nums.length - 1, 0, 0, true);
    }
}