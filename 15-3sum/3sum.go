func threeSum(nums []int) [][]int {
	size := len(nums)
	mp := make(map[[3]int]bool)
	sort.Ints(nums)
	ans := make([][]int,0)

	for i := 0; i < size; i++ {
		j := i + 1
		k := size - 1
        for j<k{
            sum:=(nums[i] + nums[j] + nums[k])
            
		if sum == 0 {
			mp[[3]int{nums[i] ,nums[j] ,nums[k]}] = true
            j++
            k--
		}else if sum>0{
            k--
        }else{
            j++
        }
        }
	}
	for k,_ := range mp{
	    ans = append(ans,k[0:])
	}
	return ans
}