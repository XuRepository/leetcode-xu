package array.滑动窗口;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:滑动窗口算法！On
 * @author: XuJY
 * @create: 2022-02-09 18:21
 **/
public class _209最小长度子数组 {
    /**
     * 滑动窗口解法！复杂度O（n）
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        int length =nums.length;
        int minLength = nums.length+1;

        int left =0;
        int right = 0;

        int sum = 0;//窗口内的数字和

        /**
         * 不要以为for里放一个while就以为是$O(n^2)$啊， 主要是看每一个元素被操作的次数，
         * 每个元素在滑动窗后进来操作一次，
         * 出去操作一次，每个元素都是被被操作两次，所以时间复杂度是 2 × n 也就是$O(n)$。
         */
        while(right<nums.length){

            sum+=nums[right];

            while(sum>=target){

                if(minLength>right-left+1){
                    minLength = right-left+1;
                }

                //左侧窗口滑动
                sum-=nums[left];
                left++;//当窗口内的值大于目标，左侧窗口移动。

            }
            right++;//右侧窗口继续遍历

        }

        if(minLength==nums.length+1)
            return 0;
        else
            return minLength;
    }

    //暴力  O(n方)
    public int solution1(int target,int[] nums){

        int minLength = nums.length;
        int flag = 0;// 查看biao'ji最终的minlength是初始长度还是修改过的长度

        for(int i=0;i<nums.length;i++){

            int sum = 0;
            int length = 0;

            for(int j=i;j<nums.length;j++){


                sum+=nums[j];
                length++;

                if(sum>=target){

                    if(length<=minLength){
                        minLength=length;
                        flag = 1;
                    }else{
                        break;
                    }
                }
            }
        }
        if(flag==1)
            return minLength;
        else
            return 0;
    }

    @Test
    public void test(){
        int[] nums =new int[]{2,3,1,2,4,3};
        System.out.println(solution1(7,nums));


    }
}
