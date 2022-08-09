package 剑指offer

//回溯法，矩阵的上下左右侧就像树的孩子！
func exist1(board [][]byte, word string) bool {
	if len(word) == 0 {
		return true
	}
	raw := len(board)
	col := len(board[0])
	for i := 0; i < raw; i++ {
		for j := 0; j < col; j++ {
			// 先初始化一个二维数组，数组为row行，每行存储一个切片，具体大小先不定
			used := make([][]bool, raw)
			// 然后再为每行申请一个 column的数组放入
			for i := range used {
				used[i] = make([]bool, col)
			}

			if backTracking1(board, word, i, j, used, 0) {
				return true
			}
		}
	}
	return false
}

func backTracking1(board [][]byte, word string, i int, j int, used [][]bool, strIndex int) bool {
	//出口
	if len(word) == strIndex {
		return true
	}
	if i < 0 || j < 0 || i >= len(board) || j >= len(board[0]) || used[i][j] == true {
		return false
	}

	if board[i][j] == word[strIndex] {
		used[i][j] = true
		//上
		up := backTracking1(board, word, i-1, j, used, strIndex+1)
		down := backTracking1(board, word, i+1, j, used, strIndex+1)
		left := backTracking1(board, word, i, j-1, used, strIndex+1)
		right := backTracking1(board, word, i, j+1, used, strIndex+1)
		used[i][j] = false
		return up || down || left || right
	}
	return false
}

//回溯法，矩阵的上下左右侧就像树的孩子！
func exist(board [][]byte, word string) bool {
	if len(word) == 0 {
		return true
	}
	raw := len(board)
	col := len(board[0])
	for i := 0; i < raw; i++ {
		for j := 0; j < col; j++ {
			if backTracking(board, word, i, j, 0) {
				return true
			}
		}
	}
	return false
}

//四叉回溯
func backTracking(board [][]byte, word string, i int, j int, strIndex int) bool {
	if len(word) == strIndex {
		return true
	}
	if i < 0 || j < 0 || i >= len(board) || j >= len(board[0]) || board[i][j] == ' ' || board[i][j] != word[strIndex] {
		return false
	}
	temp := board[i][j]
	board[i][j] = ' '

	res := backTracking(board, word, i-1, j, strIndex+1) ||
		backTracking(board, word, i+1, j, strIndex+1) ||
		backTracking(board, word, i, j-1, strIndex+1) ||
		backTracking(board, word, i, j+1, strIndex+1)
	board[i][j] = temp
	return res
}
