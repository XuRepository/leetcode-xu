package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 16:23
 **/
public class _343整数拆分 {
    public int integerBreak(int n) {

        int[] dp = new int[n+1];

        dp[2] = 1;//初始化dp

        for (int i = 3; i <=n ; i++) {

            for (int j = 1; j < i; j++) {//j是拆分的大小，从1道i-1
                //j*(i-j):把i分成2个数字
                //j*dp[i-j]：把i分成3个或者3个以上的数字
                dp[i] = Math.max(Math.max(j*dp[i-j],j*(i-j)),dp[i]);
            }
        }
        return dp[n];
    }
}
