package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 14:50
 **/
public class _746使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;//层数

        if (n<=1) return 0;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }

        return dp[n];


    }
}
