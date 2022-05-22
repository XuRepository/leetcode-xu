package 动态规划;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-16 16:49
 **/
public class _392判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex<s.length()){

            while (tIndex<t.length()){
                if (s.charAt(sIndex) != t.charAt(tIndex))
                    tIndex++;
                else {
                    sIndex++;
                    tIndex++;
                    break;
                }
            }
            if (tIndex==t.length()) break;
        }

        if (sIndex==s.length()) return true;
        else return false;

    }

    public boolean dp(String s,String t){
        int l1 = s.length();
        int l2 = t.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <=l1 ; i++) {
            for (int j = 1; j <=l2 ; j++) {
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        if (dp[l1][l2] == s.length()) return true;
        else return false;
    }
}
