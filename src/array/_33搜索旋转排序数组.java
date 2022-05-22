package array;

/**
 * @program: leetcode2022
 * @description: 二分法
 * @author: XuJY
 * @create: 2022-05-17 22:21
 **/
public class _33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length==0) return -1;
        if (length==1) return nums[0]==target?0:-1;

        int left = 0;
        int right = length-1;
        int mid;

        while (left<=right){
            mid = left+(right-left)/2;
            if (target == nums[mid]){
                return mid;
            }
            //看是左侧有序还是右侧有序
            if (nums[left] <= nums[mid]){
                if (target >= nums[left] && target<= nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else {
                if (target >= nums[mid] && target<= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

}
