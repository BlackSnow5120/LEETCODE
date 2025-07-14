import "sort"

func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	var combos [][]int
	amt := len(nums)

	for i := 0; i < amt-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		j, k := i+1, amt-1
		for k > j {
			total := nums[i] + nums[j] + nums[k]

			if total > 0 {
				k--
			} else if total < 0 {
				j++
			} else {
				combos = append(combos, []int{nums[i], nums[j], nums[k]})
				j++

				for nums[j] == nums[j-1] && k > j {
					j++
				}
			}
		}
	}

	return combos
}