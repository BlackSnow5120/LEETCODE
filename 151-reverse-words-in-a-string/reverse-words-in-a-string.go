func reverseWords(s string) string {
	strarr := strings.Split(s, " ")
	ans := ""
	for i := len(strarr) - 1; i > 0; i-- {
		if strarr[i] != "" && strarr[i] != " " {
			ans += strarr[i]
			ans += " "
		}
	}
	if strarr[0] != "" && strarr[0] != " " {
		ans += strarr[0]
	}
	return strings.Trim(ans," ")
}