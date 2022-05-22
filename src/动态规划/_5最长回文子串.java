package 动态规划;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-16 19:36
 **/
public class _5最长回文子串 {
    public String longestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()+1][t.length()+1];
        int res = 0;
        int index = -1;


        for (int i = 0; i < s.length() ; i++) {
            for (int j = 0; j <t.length(); j++) {

                if (s.charAt(i)==t.charAt(j)){
                    if (i==0 || j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }

                    if (res < dp[i][j]){
                        int beforeReverse = s.length()-j-1;
                        if (i-dp[i][j]+1 == beforeReverse){
                            res = dp[i][j];
                            index = i;
                        }

                    }
                }
            }
        }

        if (index>=0){
            String substring = s.substring(index - res+1 , index+1 );//i,j比实际的下标大1个  1-length
            return substring;
        }else{
            return null;
        }


    }

    public String  solution(String s){
        if (s.isEmpty()) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1,len2);
            if (len > end - start+1){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }

        return s.substring(start,end+1);



    }

    public int expand(String s,int left,int right){
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;right++;
        }
        return right-left-1;
    }
}
