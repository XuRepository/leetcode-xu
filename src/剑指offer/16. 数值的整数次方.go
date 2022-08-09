package 剑指offer

//考虑快速幂,float64可能是小数,n也可能是小数
func myPow(x float64, n int) float64 {
	isNagetive := false
	if n < 0 {
		isNagetive = true
		n = -1 * n
	}
	var remain float64 = 1
	for n != 0 {
		if n&1 != 0 {
			remain = remain * x
		}
		x = x * x
		n = n >> 1
	}
	if isNagetive {
		remain = 1 / remain
	}
	return remain
}
