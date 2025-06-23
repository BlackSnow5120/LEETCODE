func jump(nums []int) int {
	maxLen := 0
    tempMax:= 0
    steps:=0
	for i := 0; i < len(nums) && i <= maxLen; i++ {
		if i+nums[i] > tempMax {
			tempMax = i + nums[i]
		}
        if i == maxLen && i!=len(nums)-1{
            maxLen=tempMax
            steps++
        }

	}

    return steps
}