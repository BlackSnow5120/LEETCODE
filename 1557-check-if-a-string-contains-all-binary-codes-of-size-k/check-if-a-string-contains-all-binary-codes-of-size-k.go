func hasAllCodes(s string, k int) bool {
    mp := map[string]bool{}
    tar := int(math.Pow(2,float64(k)))
    for i:=k;i<=len(s);i++{
        mp[s[i-k:i]]=true
    }
    return len(mp) == tar
}