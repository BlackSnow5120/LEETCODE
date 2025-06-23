func hIndex(citations []int) int {
	sort.Ints(citations)
	size := len(citations)
	ans := 0
	for i := 0; i < size; i++ {
		if citations[i] >= size-i {
			ans = size-i
            break
		}
	}
	return ans
}