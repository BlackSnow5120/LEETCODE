func isPalindrome(s string) bool {
	slower := strings.ToLower(s)
	i := 0
	j := len(s) - 1
	ans := true
	for i < j {
		for !((slower[i] >= 'a' && slower[i] <= 'z') || (slower[i] >= '0' && slower[i] <= '9')) && i<j {
			i++
		}
		for !((slower[j] >= 'a' && slower[j] <= 'z') || (slower[j] >= '0' && slower[j] <= '9')) && j>i{
			j--
		}
		if slower[i] != slower[j] {
			ans = false
            break
		}
		i++
		j--
	}
	return ans
}