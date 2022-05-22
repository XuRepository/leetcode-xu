package 排序;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-04-03 12:01
 **/
public class  二路归并排序 {
    



    public void mergeSort(int[] nums,int[] res,int left, int right){
        if (left<right){
            int mid = left+(right-left)/2;
            mergeSort(nums,res,left,mid);
            mergeSort(nums,res,mid+1,right);

            merge(nums,res,left,mid,right);//合并左右两个数组
        }
    }

    public void merge(int[] nums,int[] temp,int left,int mid,int right){

        int i = left;
        int j = mid+1;
        int numEle = right-left+1;//数字个数
        while (i<= mid && j<=right){
            if (nums[i]<nums[j]){
                temp[left++] = nums[i++];
            }else{
                temp[left++] = nums[j++];
            }
        }


        while (j<=right){
            temp[left++] = nums[j++];
        }

        while (i<=mid){
            temp[left++] = nums[i++];
        }

        //临时空间的数字写回
        for (int k = 0; k < numEle; k++) {
            nums[right] = temp[right];
            right--;
        }



    }


    @Test
    public void test(){
        int[] nums = {1, 9, 5, 7, 2};
        int[] temp = new int[nums.length];
        mergeSort(nums,temp,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(temp[i]);
        }
    }

}
