func gameOfLife(board [][]int) {
	n := len(board)
	m := len(board[0])
	board1 := make([][]int, n)
	for i := range board1 {
		board1[i] = make([]int, m)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			count := 0
			if j != 0 && board[i][j-1] == 1 {
				count++
			}
			if i != 0 && board[i-1][j] == 1 {
				count++
			}
			if i != 0 && j != 0 && board[i-1][j-1] == 1 {
				count++
			}
			if i != n-1 && board[i+1][j] == 1 {
				count++
			}
			if j != m-1 && board[i][j+1] == 1 {
				count++
			}
			if i != 0 && j != m-1 && board[i-1][j+1] == 1 {
				count++
			}
			if i != n-1 && j != 0 && board[i+1][j-1] == 1 {
				count++
			}
			if i != n-1 && j != m-1 && board[i+1][j+1] == 1 {
				count++
			}
			if count < 2 {
				board1[i][j] = 0
			} else if count == 3 {
				board1[i][j] = 1
			} else if count > 3 {
				board1[i][j] = 0
			}else{
                board1[i][j]=board[i][j]
            }
			fmt.Println(count)
		}

	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
            board[i][j]=board1[i][j]
		}
	}

}