package dfs;

import sun.awt.image.GifImageDecoder;

import java.util.Arrays;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-30 14:07
 **/
public class _200岛屿数量 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] used = new boolean[row][col];//记录当前的1位置是否已经搜索过
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(used[i][j]);
                if (grid[i][j] == '1' && !used[i][j]){
                    //找到1位置，搜索上下左右！一次性搜索完成当前1的全部陆地，标记为used！
                    visit(grid,i,j,used);//标记当前的ij位置为true，并且寻找当前位置右侧下侧的1，并标记之。
                    count++;
                }
            }
        }
        return count;
    }

    private void visit(char[][] grid, int i, int j, boolean[][] used) {

        if (i<0 || j<0 || i>grid.length-1 || j> grid[0].length-1 || grid[i][j]=='0' || used[i][j]) return;//used[i][k]放在最后规避越界问题！


        used[i][j] = true;

        //右侧：
        visit(grid,i,j+1, used);
        //下侧
        visit(grid,i+1,j,used);
        //左侧
        visit(grid,i,j-1, used);
        //上侧
        visit(grid,i-1,j,used);

    }
}
