package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-23 15:24
 **/
public class _64最小路径和 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        //init dp

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i!=0 && j!=0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }else if(i ==0 && j ==0){
                    dp[i][j] = grid[0][0];
                }else if(i==0){
                    dp[i][j] = dp[i][j-1] +grid[i][j];
                }else{
                    dp[i][j] = dp[i-1][j] +grid[i][j];
                }
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
