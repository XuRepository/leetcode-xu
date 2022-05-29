package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-29 21:34
 **/
public class _152乘积最大子数组 {

    public int maxProduct1(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        //子序列-动态规划
        //[0]:以nums[i]结尾的连续子序列的正max值！
        //[1]:以nums[i]结尾的连续子序列的负min值！
        int[][] dp = new int[nums.length][2];
        //init
        dp[0][0] = Math.max(0,nums[0]);
        dp[0][1] = Math.min(0,nums[0]);
        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i][0] = Math.max(nums[i],Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]));
            dp[i][1] = Math.min(nums[i],Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]));
            max = Math.max(dp[i][0],max);
        }

        return max;

    }
}
