func minCapability(nums []int, k int) int {
    low, high := 1<<31-1, 0
    for _, v := range nums {
        if v < low {
            low = v
        }
        if v > high {
            high = v
        }
    }

    for low < high {
        fmt.Println(low,high)
        mid := (low + high) / 2
        if canRob(nums, k, mid) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}

func canRob(nums []int, k int, cap int) bool {
    count := 0
    i := 0
    for i < len(nums) {
        if nums[i] <= cap {
            count++
            i += 2
        } else {
            i++
        }
    }
    return count >= k
}