package array.双指针;

/**
 * @program: leetcode2022
 * @description:双指针，平方后，较大的值在数组的左右，小数在中间！利用双指针从两侧开始往内部逼近即可
 * @author: XuJY
 * @create: 2022-02-09 16:18
 **/
public class _977有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length;
        int[] res = new int[nums.length];

        for (int i=right-1;i>=0;i--){
            if(nums[left]*nums[left]<nums[right]*nums[right]){
                res[i]=nums[right]*nums[right];
            }else{
                res[i]=nums[left]*nums[left];
            }
        }
        return res;
    }
}
