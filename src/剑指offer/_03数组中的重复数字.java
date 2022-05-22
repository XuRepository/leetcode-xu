package 剑指offer;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-04-20 16:05
 **/
public class _03数组中的重复数字 {

    public int findRepeatNumber(int[] nums) {
        int[] hash = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(hash[nums[i]] == 0)
                hash[nums[i]] = 1;
            else
                return nums[i];
        }
        return -1;
    }

}
