package 排序;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-04-03 10:47
 **/
public class 选择排序 {

    public void 简单选择排序(int[] nums){

        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[index] <= nums[j])
                    continue;
                else{
                    index = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

    }

    //堆排序   O(nlog2n)
    public void heapSort(int[] nums,int heapLength){
        for (int i = heapLength-1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums,0,i-1);//堆化当前节点，堆排序
        }
        return;
    }
    //建立堆,自底向上建立！
    public  void createHeap(int[] nums,int heapLength){
        for (int i = heapLength-1; i >= 0 ; i--) {
            heapify(nums,i,heapLength);
        }
    }
    //堆化节点，堆排序
    public void heapify(int[] nums,int root,int heapLength){
        int left = (root+1)*2-1;
        int right = (root+1)*2;
        int max = root;

        //找第i个节点及其左右孩子的最大值
        if (left<heapLength && nums[max] < nums[left]){
            max = left;
        }

        if (right<heapLength && nums[max] < nums[right]){
            max = right;
        }

        if (max != root){
            //交换最大值到root位置
            int temp = nums[root];
            nums[root] = nums[max];
            nums[max] = temp;

            //此时根节点调整到max位置，max位置为根的节点可能不符合堆的定义！
            heapify(nums,max,heapLength);
        }
    }

    @Test
    public void test(){
        int[] ints = new int[]{5,2,4,6,9,7};

        createHeap(ints,ints.length);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }

        System.out.println(" ");

        heapSort(ints,ints.length);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }



    }
}
