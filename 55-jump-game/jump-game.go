func canJump(nums []int) bool {
	maxLen := nums[0]

	for i := 1; i < len(nums) && i <= maxLen; i++ {
		if i+nums[i] > maxLen {
			maxLen = i + nums[i]
		}
	}
    if maxLen>=len(nums)-1{
        return true
    }
    return false
}