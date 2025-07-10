func longestCommonPrefix(strs []string) string {
    lcp := ""

    for i := 0; i < len(strs[0]); i++ {
        curr := strs[0][i]
        for _, str := range strs {
            if i==len(str) || str[i] != curr {
                return lcp
            }
        }
        lcp += string(curr)
    }

    return lcp
}