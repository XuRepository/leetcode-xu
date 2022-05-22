package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode2022
 * @description:
 * 一采用分为两组，HashMap 存一组，另一组和 HashMap 进行比对
 * @author: XuJY
 * @create: 2022-02-19 13:46
 **/
public class _454四数相加 {



        public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();

            for (int u : A) {
                for (int v : B) {
                    countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
                }
            }

            int ans = 0;
            for (int u : C) {
                for (int v : D) {
                    if (countAB.containsKey(-u - v)) {
                        ans += countAB.get(-u - v);
                    }
                }
            }

            return ans;
        }




    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int res = 0;

        int length = nums1.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<length;i++){
            for (int j = 0; j < length; j++) {

                int sum = nums1[i]+nums2[j];
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);
                }else{
                    map.put(sum,1);
                }
            }
        }

        for (int k = 0; k < length; k++) {

            for (int l = 0; l < length; l++) {

                int sum = nums3[k]+nums4[l];

                if(map.containsKey(0-sum)){
                    res+=map.get(0-sum);
                }

            }
        }

        return res;
    }

}
