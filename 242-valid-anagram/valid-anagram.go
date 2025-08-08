func isAnagram(s string, t string) bool {
    if(len(s)!=len(t)){
        return false
    }
    mp := make(map[rune]int)
    for _,i := range(s){
        mp[i]++
    }
    
        for _,i := range(t){
        mp[i]--
        if(mp[i]==-1){
            return false
        }
    }
    return true

}