func wordPattern(pattern string, s string) bool {
	mp := make(map[rune]string)
	mp1 := make(map[string]bool)

	sarr := strings.Split(s, " ")
    if(len(pattern)!= len(sarr)){
        return false
    }
	for ind, i := range pattern {
        fmt.Println(mp1[sarr[ind]])
		if mp[i] == "" && mp1[sarr[ind]] == false {
			mp[i] = sarr[ind]
            mp1[sarr[ind]] = true
		} else if mp[i] != sarr[ind] {
			return false
		}
	}
    return true
}
