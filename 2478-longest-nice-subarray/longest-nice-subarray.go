func longestNiceSubarray(nums []int) int {
	ans := 1
    size := len(nums)
	sum := 0
    j:=0
	for i := 0; i < size-1; i++ {
		if nums[i]&nums[i+1] == 0 {
			sum = nums[i]
			j = i + 1
			for j < size && sum&nums[j] == 0 {
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