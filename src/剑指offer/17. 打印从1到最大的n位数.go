package 剑指offer

import "math"

func printNumbers(n int) []int {
	max := int(math.Pow10(n))
	res := make([]int, max-1)
	for i := 0; i < max-1; i++ {
		res[i] = i + 1
	}
	return res
}
