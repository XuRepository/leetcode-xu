package array;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-30 14:00
 **/
public class _169多数元素 {
    public int majorityElement(int[] nums) {
        //摩尔投票：对每个数字而言，都是给遇到自己+1，遇到别人-1，最后剩下的就是众数
        int candidate=0;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(count==0) candidate = nums[i];
            if(candidate == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
