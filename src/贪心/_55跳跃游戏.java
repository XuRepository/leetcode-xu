package 贪心;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-20 15:28
 **/
public class _55跳跃游戏 {
    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[0] =  true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>=i-j && dp[j]){
                    dp[i] = true;
                }
            }
//            System.out.println(dp[i]);
        }

        return dp[nums.length-1];
    }

    public boolean canJump1(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,i+nums[i]);
            if(max <= i) return false;
            if (max >= nums.length-1) return true;
        }
        if(max < nums.length-1){
            return false;
        }else{
            return true;
        }
    }


}
