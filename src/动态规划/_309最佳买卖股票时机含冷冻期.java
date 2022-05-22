package 动态规划;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-14 14:57
 **/
public class _309最佳买卖股票时机含冷冻期 {
    public int maxProfit( int[] prices) {

        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0]; // 持股票

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        return  Math.max(dp[prices.length-1][3],Math.max(dp[prices.length-1][2],dp[prices.length-1][1]));

    }

}
