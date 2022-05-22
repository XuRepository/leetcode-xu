package 回溯;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-11 16:34
 **/
public class _518零钱兑换ii {
    public int change(int amount, int[] coins) {
        //递推表达式
        int[] dp = new int[amount + 1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {//j每行都要从coins[i]开始，因为外层是物品，每个物品就是一层！j的容量不能比这个物品本身的质量还i小
                dp[j] += dp[j - coins[i]];
                //组成dp[j]的有几种情况：
                //dp[j-coins[0]]:再加一个coins[0]到j
                //dp[j-coins[1]]:再加一个coins[1]到j
                //dp[j-coins[2]]:再加一个coins[2]到j
                //dp[j-coins[3]]:再加一个coins[3]到j
                //dp[j-coins[4]]:再加一个coins[4]到j
                //............已经取过几种就加和几次。

            }
        }
        return dp[amount];
    }
}
