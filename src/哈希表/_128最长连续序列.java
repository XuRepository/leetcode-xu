package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-26 00:41
 **/
public class _128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        for(int num : set){
            if (!set.contains(num-1)){
                int curMax = 1;
                int curNum = num;
                while (set.contains(curNum+1)){
                    curNum++;
                    curMax++;
                }
                maxLength = Math.max(curMax,maxLength);
            }
        }
        return maxLength;
    }
}
