package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-12 13:54
 **/
public class _279完全平方数 {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        //构建物品数组
        int[] objs = new int[(int) Math.pow(n, 0.5)+1];
        for (int i = 0; i < objs.length; i++) {
            objs[i]  =i*i;
        }

        for (int i = 1; i < objs.length; i++) {
            for (int j = objs[i]; j <= n; j++) {
                if (dp[j - objs[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - objs[i]] + 1);
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) return -1;
        return dp[n];
    }
}
