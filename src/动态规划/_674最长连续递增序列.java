package 动态规划;

import java.util.Arrays;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-16 14:51
 **/
public class _674最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        dp[0] = 1;
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])dp[i] =  dp[i] = dp[i-1]+1;
            if(res<dp[i]) res= dp[i];
        }
        return res;

    }
}
