package 位运算;

import java.util.HashSet;

/**
 * @program: leetcode2022
 * @description: notion + 题解！
 * @author: XuJY
 * @create: 2022-05-26 11:50
 **/
public class _136只出现一次的数字 {
    public int singleNumber1(int[] nums) {
        int single = 0;
        for(int num:nums){
            single = single^num;
        }
        return single;
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            if(set.contains(num)){
                set.add(num);
            }else{
                set.remove(num);
            }
        }
        for(int num:set){
            return num;
        }
        return 0;
    }
}
