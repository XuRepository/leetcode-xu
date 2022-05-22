package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-12 21:25
 **/
public class _121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {

        int low = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low,prices[i]);
            max = Math.max(max,prices[i] - low);
        }
        return max;
    }
}
