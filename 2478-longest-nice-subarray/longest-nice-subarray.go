func longestNiceSubarray(nums []int) int {
	ans := 1
	sum := 0
	for i := 0; i < len(nums)-1; i++ {
		if nums[i]&nums[i+1] == 0 {
			sum = nums[i]
			j := i + 1
			for j < len(nums) && sum&nums[j] == 0 {
				sum += nums[j]
				j++
			}
			if j-i > ans {
				ans = j - i
			}
		}
	}
	return ans
}