package 动态规划

//动态规划，dp[i][j]代表以ij为右下角的最大正方形的边长
//推导公式：dp[i[[j] = min(dp[i-1][j],dp[i-1][j-1]，dp[i][j-1])
func maximalSquare(matrix [][]byte) int {
	dp := make([][]int, len(matrix)) //go语言的二维数组需要使用切片定义
	for i := range dp {
		dp[i] = make([]int, len(matrix[0]))
	}
	maxSize := 0

	//init
	for i, ch := range matrix[0] {
		if ch == '1' {
			dp[0][i] = 1
			maxSize = 1
		}
	}
	for i := 0; i < len(matrix); i++ {
		if matrix[i][0] == '1' {
			dp[i][0] = 1
			maxSize = 1
		}
	}

	for i := 1; i < len(matrix); i++ {
		for j := 1; j < len(matrix[0]); j++ {
			if matrix[i][j] == '1' {
				dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1
				if maxSize < dp[i][j] {
					maxSize = dp[i][j]
				}
			}
		}
	}

	return maxSize * maxSize

}

func min(i int, i2 int, i3 int) int {
	min := i
	if min > i2 {
		min = i2
	}
	if min > i3 {
		min = i3
	}
	return min
}
