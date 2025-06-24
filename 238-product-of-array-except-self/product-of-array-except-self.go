func productExceptSelf(nums []int) []int {
	ans := make([]int, len(nums))
	prod := 1
	for i := 0; i < len(nums); i++ {
		ans[i] = prod
		prod = prod * nums[i]
	}
	prod = 1
	for i := len(nums) - 1; i >= 0; i-- {
		ans[i] = ans[i] * prod
		prod = prod * nums[i]
	}
	return ans
}