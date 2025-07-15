func lengthOfLongestSubstring(s string) int {
	n := len(s)
	left := 0
	ans := 0
	mp := make(map[byte]int)

	for right := 0; right < n; right++ {
		if idx, found := mp[s[right]]; found && idx >= left {
			left = idx + 1
		}
		mp[s[right]] = right
		if right-left+1 > ans {
			ans = right - left + 1
		}
	}

	return ans
}
