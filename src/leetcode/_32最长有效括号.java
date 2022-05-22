package leetcode;

import java.util.Stack;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-17 21:42
 **/
public class _32最长有效括号 {
    public int longestValidParentheses(String s) {

        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                left++;
            }else{
                if (right >= left){

                }
            }
        }

        return maxLength;
    }



}
