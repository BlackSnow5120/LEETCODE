func binaryGap(n int) int {
	ans := 0
	temp := -1

	for n > 0 {
        fmt.Println(n,n&1,temp)
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
