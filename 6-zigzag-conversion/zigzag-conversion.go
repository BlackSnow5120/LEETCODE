func convert(s string, numRows int) string {
    if numRows == 1 || numRows >= len(s) {
        return s
    }

    strarr := make([]string, numRows)
    row := 0
    down := false

    for i := 0; i < len(s); i++ {
        strarr[row] += string(s[i])
        if row == 0 || row == numRows-1 {
            down = !down
        }
        if down {
            row++
        } else {
            row--
        }
    }

    result := ""
    for _, part := range strarr {
        result += part
    }
    return result
}
