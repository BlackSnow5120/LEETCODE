func strStr(haystack string, needle string) int {
	j := 0
	i := 0
	for i = 0; i < len(haystack) && j < len(needle); i++ {
		if haystack[i] != needle[j] && j!=0{
            i = i-j+1
			j = 0
		}
		if haystack[i] == needle[j] {
			j++   
		}
	}
	if j == len(needle) {
		return i - j
	} else {
		return -1
	}

}