package 动态规划;

import java.util.Arrays;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-16 14:34
 **/
public class _300最长上升子序列 {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        dp[0] = 1;
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])dp[i] =  Math.max(dp[i],dp[j]+1);
            }
            if (res<dp[i]) res= dp[i];
        }
        return res;
    }
}
