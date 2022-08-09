package 位运算

//dp,On  i&(i-1) --> 把i的最后一位1变为0，所以i&(i-1)<i
func countBits(n int) []int {
	bits := make([]int, n+1)
	for i := 1; i <= n; i++ {
		bits[i] = bits[i&(i-1)] + 1
	}
	return bits
}

//dp,On
//偶数j和j/2的1个数一样，因为偶数最后一位是0，/2相当于右移，1不变
//奇数j = 前一个偶数j-1的1的位数+1
func countBits21(n int) []int {
	res := make([]int, n+1)
	res[0] = 0
	if n == 0 {
		return res
	}
	res[1] = 1
	for i := 2; i <= n; i++ {
		if i%2 == 0 {
			res[i] = res[i>>1]
		} else {
			res[i] = res[i-1] + 1
		}
	}
	return res
}

//O(kn)
func countBits1(n int) []int {
	//暴力法,直接遍历每个比特位
	maxBit := 31
	res := make([]int, n+1)
	for i := 0; i <= n; i++ {
		for j := 0; j <= maxBit; j++ {
			res[i] = (i >> j) & 1 //(i>>j)&1代表着 数字i右侧的第j位！
		}
	}
	return res
}
