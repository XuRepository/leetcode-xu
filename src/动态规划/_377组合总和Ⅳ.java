package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-12 12:48
 **/
public class _377组合总和Ⅳ {
    public int combinationSum4(int[] nums, int target) {


        int[] dp = new int[target + 1];
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i>=nums[j])
                    dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
