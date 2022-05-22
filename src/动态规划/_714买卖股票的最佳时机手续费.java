package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-14 14:22
 **/
public class _714买卖股票的最佳时机手续费 {
    public int maxProfit(int[] prices, int fee) {

        if (prices.length==0) return 0;

        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i] - fee,dp[i-1][1]);
        }

        return dp[prices.length-1][1];

    }
}
