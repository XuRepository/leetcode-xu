package array.移除元素_双指针;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description: 移除元素_双指针
 * @author: XuJY
 * @create: 2022-02-07 20:19
 **/
public class _27 {
    //考虑使用交换元素的方法！发现与val相等的元素，就把该元素放到数组的末尾上去
    //这里其实是双指针。
    public int removeElement(int[] nums, int val) {

        int i=0;
        int j=nums.length-1;//末尾的元素 作为和前面的元素做交换的下标
        int res = 0;

        while(i<=j){
            if(nums[i]==val){

                nums[i]=nums[j];
                nums[j]=val;
                j--;
            }else{
                res++;
                i++;
            }
        }
        return res;
    }

    public int removeElement1(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex]!=val){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }


        @Test
    public void test(){
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int res = removeElement(nums,2);
        System.out.println("res:"+res);
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }

    }
}
