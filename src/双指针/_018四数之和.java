package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-19 16:34
 **/
public class _018四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int length = nums.length;

        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0;i<length;i++){

            if(i>0 && nums[i] ==nums[i-1]) continue;

            for(int j = i+1;j<length;j++){

                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }

                int left = j+1;
                int right = length-1;

                while(left<right){

                    int sum = nums[i]+nums[j]+nums[left]+nums[right];

                    if(sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        lists.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[right] ==nums[right-1]) right--;
                        while(left<right && nums[left] ==nums[left+1]) left++;

                        left++;
                        right--;
                    }


                }
            }

        }

        return lists;

    }
}
