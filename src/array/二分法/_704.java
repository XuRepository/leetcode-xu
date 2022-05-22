package array.二分法;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:二分法
 * @author: XuJY
 * @create: 2022-02-05 18:35
 **/
public class _704 {
    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;

        while(left<=right){
            int i = (left+right)/2;
            if(nums[i]==target)
                return i;
            else if(nums[i]<target)
                left = i+1;
            else
                right = i-1;
        }
        return -1;
    }


    @Test
    public void test(){
        int[] nums = {1,2,3,4};
        System.out.println(search(nums,5));
    }
    
}
