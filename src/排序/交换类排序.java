package 排序;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-04-03 00:37
 **/
public class 交换类排序 {



    //maopao
    //On2
    public void 冒泡排序1(int[] nums){


    }


























    //On2
    public void 冒泡排序(int[] nums){

        int n = nums.length;

        //外层
        for (int i = n-1; i >=0; i++) {
            int flag = 0;

            for (int j = 1; j <= i ; j++) {
                if (nums[j-1] > nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;

                    flag = 1;
                }
            }

            if (flag==0) break;
        }

        return ;
    }

    //快速排序
    public void 快速排序1(int[] nums,int left,int right){

        int n = nums.length;
        int i = left;
        int j = right;
        int temp;

        if (left <= right){
            temp = nums[left];

            while(i<j){

                while (i<j && nums[j]>=temp) j--;
                if (i<j){
                    nums[i] = nums[j];
                    i++;
                }

                while (i<j && nums[i]>temp) i++;
                if (i<j){
                    nums[j] = nums[i];
                    j--;
                }

            }
            nums[i] = temp;
            快速排序1(nums,left,i-1);
            快速排序1(nums,i+1,right);

        }



    }

    //快速排序
    public void 快速排序(int[] nums,int l,int r){

        int left = l;
        int right =r;

        if (right>left){
            int sentinel = nums[left];
            while (right>left){

                //从右侧开始向左遍历，直到遇到第一个小于哨兵的or遇到left
                while(right>left && nums[right]>=sentinel){
                    right--;
                }
                nums[left] = nums[right];

                //改为从左向右遍历，找到第一个比哨兵大的数or遇到right
                while (left<right && nums[left]<=sentinel){
                    left++;
                }
                nums[right] = nums[left];
            }
            //遍历结束，此时left = right 就是哨兵应该到的位置
            nums[left] = sentinel;

            快速排序(nums,l,left-1);
            快速排序(nums,right+1,r);
        }

        return;

    }

    @Test
    public void test(){
        int[] ints = new int[]{5,2,4,6,9,7};

        快速排序(ints,0,ints.length-1);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }

    }




}
