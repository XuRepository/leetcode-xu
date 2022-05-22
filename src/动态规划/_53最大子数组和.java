package 动态规划;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-16 16:10
 **/
public class _53最大子数组和 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i-1],0)+nums[i];
//            System.out.println(dp[i]);

            res = Math.max(res, dp[i]);

        }
        return res;
    }

    @Test
    public void test(){
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
