package 动态规划;

import java.util.Arrays;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 15:56
 **/
public class _63不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;//行数
        int n = obstacleGrid[0].length;//列数

        //初始化dp
        int[][] dp = new int[m ][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break;//第一行，第一列 一旦出现障碍，障碍之后的都不走了
            }else {
                dp[i][0] = 1;
            }

        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                break;
            }else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i <m ; i++) {

            for (int j = 1; j <n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else
                    dp[i][j] = 0;
            }

        }
        return dp[m-1][n-1];

    }
}
