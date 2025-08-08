func canConstruct(ransomNote string, magazine string) bool {
	count := [26]int{}

	for i := 0; i < len(magazine); i++ {
		count[magazine[i]-'a']++
	}

	for i := 0; i < len(ransomNote); i++ {
		idx := ransomNote[i] - 'a'
		count[idx]--
		if count[idx] < 0 {
			return false
		}
	}

	return true
}
