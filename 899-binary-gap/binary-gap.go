func binaryGap(n int) int {
	ans := 0
	temp := -1

	for n > 0 {
		if n&1 == 1 {
			ans = max(temp, ans)
			temp = 0
		}
		if temp != -1 {
			temp++
		}
		n >>= 1
	}

	return ans
}
