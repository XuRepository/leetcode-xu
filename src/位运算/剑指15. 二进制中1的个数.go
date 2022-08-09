package 位运算

func hammingWeight1(num uint32) int {
	count := 0
	for num >= 0 {
		if num&1 != 0 {
			count++
		}
		num = num >> 1
	}
	return count
}

//位运算优化
//n & (n−1)，其预算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。
func hammingWeight(num uint32) int {
	count := 0
	for num != 0 {
		num = num & (num - 1)
		count++
	}
	return count
}
