func canConstruct(ransomNote string, magazine string) bool {
	mp := make(map[byte]int)
	for i := 0; i < len(magazine); i++ {
		mp[magazine[i]]++
	}
	for i := 0; i < len(ransomNote); i++ {
		mp[ransomNote[i]]--
		if mp[ransomNote[i]] == -1 {
			return false
		}
	}
	return true
}