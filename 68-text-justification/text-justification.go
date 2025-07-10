func fullJustify(words []string, maxWidth int) []string {
    result := []string{}
    i := 0

    for i < len(words) {
        lineLen := len(words[i])
        j := i + 1

        for j < len(words) && lineLen+1+len(words[j]) <= maxWidth {
            lineLen += 1 + len(words[j])
            j++
        }

        gaps := j - i - 1
        line := ""

        if j == len(words) || gaps == 0 {
            for k := i; k < j; k++ {
                line += words[k]
                if k != j-1 {
                    line += " "
                }
            }
            for len(line) < maxWidth {
                line += " "
            }
        } else {
            totalSpaces := maxWidth - (lineLen - gaps)
            spacePerGap := totalSpaces / gaps
            extraSpaces := totalSpaces % gaps

            for k := i; k < j-1; k++ {
                line += words[k]
                line += strings.Repeat(" ", spacePerGap)
                if extraSpaces > 0 {
                    line += " "
                    extraSpaces--
                }
            }
            line += words[j-1]
        }

        result = append(result, line)
        i = j
    }

    return result
}
