package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-19 14:49
 **/
public class _015三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;

        List<List<Integer>> lists = new ArrayList<>();

        //排序
        Arrays.sort(nums);

        int i = 0;

        while (i<length-2)
        {
            if(i>0 && nums[i] == nums[i-1]){
                //判断首个位置是否重复，不能用i+1  要和前面的元素比。
                i++;
                continue;
            }

            int left = i+1;
            int right = length-1;

            while(left<right){
                if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(right>left && nums[right] == nums[right-1]){
                        right--;
                    }
                    while(right>left && nums[left] == nums[left+1]){
                        left++;
                    }

                    left++;
                    right--;
                }
            }
            i++;
        }

        return lists;
    }
}
