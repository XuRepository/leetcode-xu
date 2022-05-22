package 动态规划;

import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-12 14:22
 **/
public class _139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //物品从0开始的  所以是<i
                if (wordDict.contains(s.substring(j,i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }
}
