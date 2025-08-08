func groupAnagrams(strs []string) [][]string {
    mp := make(map[[26]int][]string)

    ansarr := [][]string{}
    for _,i :=range(strs){
            count := [26]int{}
        for _,j :=range(i){
            count[j-rune('a')]++
        }
        mp[count] = append(mp[count],i)
    }
    for _,v := range(mp){
        ansarr = append(ansarr,v)
    }
    return ansarr
}