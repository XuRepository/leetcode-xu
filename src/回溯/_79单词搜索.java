package 回溯;

import java.security.cert.TrustAnchor;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-23 15:28
 **/
public class _79单词搜索 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int[][] used = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                boolean res = check(i,j,board,word,0,used);
                if (res) return true;
            }

        }
        return false;
    }

    private boolean check(int i, int j, char[][] board, String word, int index, int[][] used) {
        if (index > word.length()-1) return false;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;

        if (index == word.length()-1 && word.charAt(index) == board[i][j] && used[i][j]==0) return true;


        //出口

        if (word.charAt(index) == board[i][j] && used[i][j]==0) {
            used[i][j] = 1;
            boolean res1 = check(i - 1, j, board, word, index + 1,used);
            if (res1) {
                used[i][j] = 0;
                return true;
            }
            boolean res2 = check(i + 1, j, board, word, index + 1,used);
            if (res2){
                used[i][j] = 0;
                return true;
            }
            boolean res3 = check(i, j - 1, board, word, index + 1,used);
            if (res3){
                used[i][j] = 0;
                return true;
            }
            boolean res4 = check(i, j + 1, board, word, index + 1,used);
            if (res4){
                used[i][j] = 0;
                return true;
            }

            used[i][j] = 0;
            return false;
        } else {
            return false;
        }
    }

}
