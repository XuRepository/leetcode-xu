package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-09 21:15
 **/
public class _20N皇后 {
    List<List<String>> res = new ArrayList<List<String>>();
    ArrayList<String> path = new ArrayList<String>();


    public List<List<String>> solveNQueens(int n) {

        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTracking(0,n,chessboard);

        return res;


    }

    public void backTracking(int row,int n,char[][] chessboard){

        //出口
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (checkQueue(row,col,n,chessboard)){
                chessboard[row][col] = 'Q';

                backTracking(row+1,n,chessboard);

                chessboard[row][col] = '.';

            }

        }


    }

    public boolean checkQueue(int row, int col, int n, char[][] chessboard){
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;


    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }





}
