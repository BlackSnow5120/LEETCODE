func isIsomorphic(s string, t string) bool {
	mp := make(map[rune]byte)
	mp1 := make(map[byte]bool)

	for ind, i := range s {
		v, found := mp[i]
		if !found {
			if !mp1[t[ind]] {
				mp[i] = t[ind]
                mp1[t[ind]]=true
			} else {
				return false
			}

		} else if v != t[ind] {
			return false
		}
	}
	return true

}