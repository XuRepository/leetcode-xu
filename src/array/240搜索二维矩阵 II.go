package leetcode_hot100

import "sort"

//O m+n
func searchMatrix(matrix [][]int, target int) bool {
	//从右上角开始搜索，如果target>当前值，说明当前列严格大于，列数-1
	//如果target<当前值，当前行严格小于，行数-1
	i := 0
	j := len(matrix[0]) - 1
	for i < len(matrix) && j >= 0 {

		if matrix[i][j] == target {
			return true
		} else if matrix[i][j] > target {
			j--
		} else if matrix[i][j] < target {
			i++
		}
	}
	return false
}

// 二分
func searchMatrix1(matrix [][]int, target int) bool {

	for _, row := range matrix {
		i := sort.SearchInts(row, target)
		if i < len(row) && row[i] == target {
			return true
		}
	}
	return false
}
