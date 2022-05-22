package 动态规划;

import 二叉树.TreeNode;

import java.util.Arrays;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-10 15:15
 **/
public class _62不同路径 {

    //动态规划
    public int uniquePaths(int m, int n) {

        if (m<=1 && n<=1) return 1;

        //初始化dp
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0],0);//第0行填充0
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = 0;

        }
        dp[1][0] = 1;

        for (int i = 1; i <=m ; i++) {

            for (int j = 1; j <=n; j++) {

                dp[i][j] = dp[i-1][j] + dp[i][j-1];


            }

        }
        return dp[m][n];

    }




    //1深度搜索，类似于二叉树
    public int uniquePaths1(int m, int n) {

        return tarvel(1,1,m,n);
    }

    public int tarvel(int row,int col,int m,int n){
        if (row>m || col > n){
            return 0;//越界
        }
        if (row == m && col == n){
            return 1;//找到一种方案
        }

        return tarvel(row+1,col,m,n) + tarvel(row,col+1,m,n);//往左走 往下走 两种方案
    }


}
