package 排序;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-04-02 20:47
 **/
public class 插入排序 {

    public void 直接排序(int[] nums){

        int n = nums.length;
        int temp;

        for (int i = 0; i < n; i++) {
            int j;
            temp = nums[i];

            //寻找插入的位置
            for (j = i-1; j >=0 ; j--) {

                if (temp<nums[j]){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }

            nums[j+1]=temp;
        }

        return;
    }

    public void 折半插入排序(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int temp= nums[i];//存储当前元素

            //折半查找当前元素的位置
            int left = 0;
            int right = i-1;
            int mid =0;

            while (right>=left){
                mid = left+(right-left)/2;
                if (temp>nums[mid]){
                    left = mid+1;
                }else if(temp<nums[mid]){
                    right = mid-1;
                }else{
                    right=mid;
                    break;
                }
            }

//            System.out.println(mid);

            for (int j = i-1; j > right; j--) {
                nums[j+1] = nums[j];
            }

            nums[right+1] = temp;
        }
        return;

    }

    @Test
    public void test(){
        int[] ints = new int[]{5,2,4,6,9,7};

        折半插入排序(ints);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }

    }

}
