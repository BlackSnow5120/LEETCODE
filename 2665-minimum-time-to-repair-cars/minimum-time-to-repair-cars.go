
func repairCars(ranks []int, cars int) int64 {
    low := 1
    maxRank := 0
    for _, r := range ranks {
        if r > maxRank {
            maxRank = r
        }
    }
    high := maxRank * cars * cars

    for low < high {
        mid := low + (high-low)/2
        if func1(mid, cars, ranks) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return int64(low)
}

func func1(time int, cars int, ranks []int) bool {
    count := 0
    for _, r := range ranks {
        j := int(math.Floor(math.Sqrt(float64(time) / float64(r))))
        count += j
        if count >= cars { 
            return true
        }
    }
    return count >= cars
}