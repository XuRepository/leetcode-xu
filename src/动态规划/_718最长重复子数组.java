package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-16 15:08
 **/
public class _718最长重复子数组 {
    public int findLength(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[][] dp = new int[l1][l2];
        int res = 0;


        //init
        for (int i = 0; i < l1; i++) {
            if (nums1[i] == nums2[0]){
                dp[i][0] = 1;
            }
            if (res < dp[i][0]) res = dp[i][0];

        }
        for (int j = 0; j < l2; j++) {
            if (nums2[j] == nums1[0]){
                dp[0][j] = 1;
            }
            if (res < dp[0][j]) res = dp[0][j];

        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }

        return res;

    }
}
