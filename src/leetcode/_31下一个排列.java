package leetcode;

import java.util.Arrays;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-17 21:23
 **/
public class _31下一个排列 {
    public void nextPermutation(int[] nums) {

        int index = -1;
        for (int i = nums.length-1; i >=0; i--) {
            if (i>0 && nums[i-1]<nums[i]){
                index = i-1;
                break;
            }
        }
        if (index==-1) {
            Arrays.sort(nums);
            return;
        }

        int target = -1;
        for (int i = nums.length-1; i > index ; i++) {
            if (nums[i]>nums[index]){
                target = i;
                break;
            }
        }

        int temp = nums[target];
        nums[target] = nums[index];
        nums[index] = temp;

        Arrays.sort(nums,index+1,nums.length);
    }
}
