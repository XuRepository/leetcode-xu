package 双指针;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-06-05 10:37
 **/
public class _16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {

        int length = nums.length;
        Arrays.sort(nums);

        int minSum = 1000000;

        for (int i = 0; i < length; i++) {

            if (i>0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = length - 1;
            //做双指针判断的时候条理清晰！
            while (left <right){
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) return sum;

                if (Math.abs(sum - target) < Math.abs(minSum - target)){
                    minSum = sum;
                }

                if (sum > target){
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                }

                if (sum < target){
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                }
            }
        }

        return minSum;
    }

    @Test
    public void test(){
        threeSumClosest(new int[]{0,0,0},1);
    }
}
