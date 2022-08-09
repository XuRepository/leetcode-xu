package 剑指offer

func cuttingRope2(n int) int {
	var mod int = 1e9 + 7
	nums := n/3 - 1 //先看看如果按照3长度切，能切几份3，如此一来最后的剩余的长度可能是1,2,3,4
	if n <= 3 {
		return n - 1
	}
	//1，循环求余,避免越界！
	remain := powMod(3, nums, mod)
	if n%3 == 0 {
		return (remain * 3) % mod
	} else if n%3 == 1 {
		return (remain * 4) % mod
	} else {
		return (remain * 6) % mod
	}

}

//快速幂Ologn
func powMod(x int, n int, mod int) int {
	remain := 1
	for n != 0 {
		if n&1 != 0 { //奇数
			remain = (remain * x) % mod
		}
		x = x * x % mod
		n = n >> 1
	}
	return remain
}

//循环求余避免越界 On
func circleMod(x int, n int, mod int) int {
	var remain int = 1 //意味着x^k%mod的结果！
	for i := 1; i <= n; i++ {
		remain = (remain * x) % mod
	}
	return remain
}
