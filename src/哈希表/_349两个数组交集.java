package 哈希表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-18 19:51
 **/
public class _349两个数组交集 {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();

        for(int i= 0;i<nums1.length;i++){

            set1.add(nums1[i]);
        }

        for(int i = 0;i<nums2.length;i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }

        //转换为数组
        int[] res = new int[set2.size()];
        int index = 0;
        for (int i:set2) {
            res[index++] = i;
        }
        return res;

    }
}
