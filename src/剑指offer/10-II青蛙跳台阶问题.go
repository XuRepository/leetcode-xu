package 剑指offer

func numWays(n int) int {
	var mod int = 1e9 + 7
	dp := make([]int, 2)
	dp[0] = 1
	dp[1] = 1
	for i := 2; i <= n; i++ {
		temp := dp[0] + dp[1]
		dp[0] = dp[1]
		dp[1] = temp % mod
	}
	return dp[1]
}
