package 回溯;

import java.lang.annotation.Target;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-11 14:42
 **/
public class _416分割等和子集 {



    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum%2==1) return false;

        //01背包 看看能不能在数组中取数字，组成最终的target为sum/2
        //背包的体积为sum / 2
        //背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
        //背包如果正好装满，说明找到了总和为 sum / 2 的子集。
        //背包中每一个元素是不可重复放入。

        int[][] dp = new int[nums.length][sum / 2+1];//dp的行数是物品书，列数是背包容量

        //初始化dp
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= sum/2; i++) {
            if (i>= nums[0]) dp[0][i] = nums[0];
            else dp[0][i] = 0;
        }



        for (int i = 1; i < nums.length; i++) {//物品
            for (int j = 1; j<=sum/2; j++) {//容量
                if (j>=nums[i])
                    dp[i][j]  = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                else//不放
                    dp[i][j] = dp[i-1][j];
            }
        }
        if (dp[nums.length-1][sum/2] == sum/2){
            return true;
        }
        return false;
    }


    public boolean canPartition1(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum%2==1) return false;

        //01背包 看看能不能在数组中取数字，组成最终的target为sum/2
        //背包的体积为sum / 2
        //背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
        //背包如果正好装满，说明找到了总和为 sum / 2 的子集。
        //背包中每一个元素是不可重复放入。
        int[] dp = new int[sum/2+1];//背包的大小 是总和的一半就可以啦！单层背包，数组的下标就是背包的容量。
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {//物品
            for (int j = sum/2; j>=nums[i]; j--) {//容量
                dp[j]  = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if (dp[sum/2] == sum/2){
            return true;
        }
        return false;
    }


}
