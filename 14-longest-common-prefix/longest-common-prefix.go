func longestCommonPrefix(strs []string) string {
    ans:=strs[0]
    temp:=""
    for _,i := range strs{
        k:=0
        for j:= 0;j<len(i) && k<len(ans);j++{
            if(i[j] == ans[k]){
                temp += string(i[j])
            }else{
                break
            }
            k++
        }
        ans=temp
        temp=""
    }
    return ans
}