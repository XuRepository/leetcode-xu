package 动态规划

//考虑动态规划，因为问题可以分解为子问题：
//一根长度为n的绳子，可以切成两段i,j，也可以切成更多段i,....
//dp[n] = max1 (i*j, i*dp[j])
func cuttingRope(n int) int {

	dp := make([]int, n+1) //长度为n的绳子切了之后的最大乘积
	dp[0] = 0
	dp[1] = 1
	dp[2] = 1
	for i := 3; i <= n; i++ { //从3开始计算dp[i]
		for j := 1; j < i; j++ {
			//dp[i]由dp[i]之前的元素推导,j代表第二段切下的长度，可能会继续切
			//i-j代表第一段不分解的长度
			dp[i] = Max(dp[i], (i-j)*j, (i-j)*dp[j])
		}
	}
	return dp[n]
}

func Max(i1 int, i2 int, i3 int) int {
	m := i1
	if i2 > m {
		m = i2
	}
	if i3 > m {
		m = i3
	}
	return m
}

//使用回溯会超时
var max1 int

func cuttingRope1(n int) int {
	path := make([]int, 0)
	max1 = 0
	backcuttingRope(path, n)
	return max1
}

func backcuttingRope(path []int, remain int) {
	//1,出口:长度n都被切完了，没有剩余，就结束
	if remain == 0 {
		//至少两段
		if len(path) == 1 {
			return
		}
		//计算最大值
		product := 1
		for _, i := range path {
			product *= i
		}
		if product > max1 {
			max1 = product
		}
		return
	}

	//i代表被切的长度
	for i := 1; i <= remain; i++ {
		path = append(path, i)
		remain -= i
		backcuttingRope(path, remain)
		remain += i
		path = path[0 : len(path)-1]
	}
}
