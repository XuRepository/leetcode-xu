package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 11:08
 **/
public class _509斐波那契数 {
    public int fib(int n) {
        if (n<=1) return n;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }
}
