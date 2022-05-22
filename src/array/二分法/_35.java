package array.二分法;

/**
 * @program: leetcode2022
 * @description: 二分法
 * @author: XuJY
 * @create: 2022-02-06 20:28
 **/
public class _35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int middle = (left+right)/2;
            if(nums[middle]==target)
                return middle;
            else if(nums[middle]<target)
                left = middle+1;
            else
                right = middle-1;
        }
        return right+1;
    }
}
