func setZeroes(matrix [][]int) {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return
	}
	n := len(matrix)
	m := len(matrix[0])
	arr := []int{}
	arr1 := []int{}

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if matrix[i][j] == 0 {
                arr = append(arr,i)
                arr1 = append(arr1,j)
			}
		}
	}
	for _, val := range arr1 {
		for k := 0; k < n; k++ {
			matrix[k][val] = 0
		}

	}
	for _, val := range arr {

    		for k := 0; k < m; k++ {
			matrix[val][k] = 0
		}
	}

}
func init (){
    debug.SetMemoryLimit(7)
}