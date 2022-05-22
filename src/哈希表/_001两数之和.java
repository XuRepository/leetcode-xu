package 哈希表;

import java.util.HashMap;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-18 21:02
 **/
public class _001两数之和 {
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        if(nums.length<2){
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            int temp = target-nums[i];
            if(map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;

                return res;
            }

            map.put(nums[i],i);

        }

        return res;
    }
}
