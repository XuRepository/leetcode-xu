package leetcode;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-31 21:27
 **/
public class _14最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for(String str : strs){
            minLen = Math.min(str.length(),minLen);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = 0;
            for(String str:strs){
                if (c!=0 && str.charAt(i)!=c){
                    return res.toString();
                }
                c = str.charAt(i);
            }
            res.append(c);
        }

        return res.toString();
    }
}
