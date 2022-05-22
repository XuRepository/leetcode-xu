package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description: 回溯
 * @author: XuJY
 * @create: 2022-05-17 13:52
 **/
public class _22括号生成 {

    int usedLeft = 0;
    int usedRight = 0;

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        int[] used = new int[2*n];
        char[] chars = new char[2*n];
        for (int i = 0; i < n; i++) {
            chars[i] = '(';
        }
        for (int i = n; i < 2*n; i++) {
            chars[i] = ')';
        }
        backtracking(result,path,n,used,chars);
        result.forEach(System.out::println);
        return result;


    }

    public void backtracking(List<String> result, StringBuilder path,int n,int[] used,char[] chars){

        //出口
        if (path.length()==2*n){
            result.add(new String(path));
        }

        for (int i = 0; i < 2*n; i++) {
            if (i>0 && chars[i]==chars[i-1] && used[i-1]==0) continue;

            if (used[i] == 0){
                if (chars[i] == '(')
                    usedLeft++;
                else{
                    if (usedRight>=usedLeft) continue;
                    usedRight++;
                }
                path.append(chars[i]);
                used[i] = 1;
                backtracking(result,path,n,used,chars);
                used[i] =0;
                path.deleteCharAt(path.length()-1);

                if (chars[i] == '(')
                    usedLeft--;
                else{
                    usedRight--;
                }

            }

        }

    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
