func isAnagram(s string, t string) bool {
    if(len(s)!=len(t)){
        return false
    }
    mp := [26]int{}
    for _,i := range(s){
        mp[i-rune('a')]++
    }
    
        for _,i := range(t){
        mp[i-rune('a')]--
        if(mp[i-rune('a')]==-1){
            return false
        }
    }
    return true

}