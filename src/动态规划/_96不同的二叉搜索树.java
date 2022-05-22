package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 17:17
 **/
public class _96不同的二叉搜索树 {
    public int numTrees(int n) {

        //dp[i] :i个元素的 二叉搜索树 有多少种

        int[] dp = new int[n+1];

        dp[0] = 1;

        for (int i = 1; i <=n ; i++) {

            for (int j = 1; j <= i; j++) {
                //j为头节点
                dp[i] += dp[j-1] * dp[i-j];

            }

        }

        return dp[n];

    }
}
