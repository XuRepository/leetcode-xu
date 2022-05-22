package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-12 19:26
 **/
public class _213打家劫舍II {
    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int result1 = robRange(nums, 0, nums.length - 2); // 情况二
        int result2 = robRange(nums, 1, nums.length - 1); // 情况三
        return Math.max(result1, result2);


    }

    public int robRange(int[] nums,int start,int end){
        if (end - start==0) return nums[start];

        int[] dp = new int[nums.length];

        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);

        for (int i = start+2; i <=end; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[end];
    }
}
