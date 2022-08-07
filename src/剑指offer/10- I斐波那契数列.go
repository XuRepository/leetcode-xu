package 剑指offer

//动态规划5部曲
func fib(n int) int {
	var mod int = 1e9 + 7
	if n == 0 {
		return 0
	}
	dp := [2]int{}
	dp[0] = 0
	dp[1] = 1
	for i := 2; i <= n; i++ {
		temp := dp[0] + dp[1]
		dp[0] = dp[1]
		dp[1] = temp % mod
	}
	return dp[1]
}

//动态规划5部曲
func fib1(n int) int {
	dp := make([]int, n+1)
	dp[0] = 0
	dp[1] = 1
	for i := 2; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}
