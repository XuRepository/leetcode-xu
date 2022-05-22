package 回溯;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-11 15:45
 **/
public class _1049最后一块石头的重量 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }

        //01背包 看看能不能在数组中取数字，组成最终的target为sum/2
        //背包的体积为sum / 2
        //背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
        //背包如果正好装满，说明找到了总和为 sum / 2 的子集。
        //背包中每一个元素是不可重复放入。

        int[][] dp = new int[stones.length][sum / 2+1];//dp的行数是物品书，列数是背包容量

        //初始化dp
        for (int i = 0; i < stones.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= sum/2; i++) {
            if (i>= stones[0]) dp[0][i] = stones[0];
            else dp[0][i] = 0;
        }



        for (int i = 1; i < stones.length; i++) {//物品
            for (int j = 1; j<=sum/2; j++) {//容量
                if (j>=stones[i])
                    dp[i][j]  = Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                else//不放
                    dp[i][j] = dp[i-1][j];
            }
        }

        //两队石头
        return (sum-dp[stones.length-1][sum/2]) -dp[stones.length-1][sum/2];



    }
}
