package 二叉树;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-06 12:09
 **/
public class _108将有序数组转换为二叉搜索树 {

    //递归，找数组的中点，然后左右子树是左右两个区间的中点
    public TreeNode sortedArrayToBST(int[] nums) {

        return traverse(nums,0,nums.length-1);

    }
    //遍历

    public TreeNode traverse(int nums[],int left,int right){

        //二叉搜索树，自上而下遍历，先序
        if (nums.length == 0 || left>right) return null;

        int middle = (left+right+1)/2;
        //此处需要+1，因为java中舍去小数，不+1，部分情况会出现middle在数组是偶数个的情况下，获得的middle偏左，
        // 在最后两个元素判断的时候，会让左侧更小的元素首先进入搜索树，二更大的一个元素后入
        TreeNode root = new TreeNode(nums[middle]);


        //左右    java中  1/2 = 0；
        root.left = traverse(nums,left,middle-1);
        root.right = traverse(nums,middle+1,right);

        return root;
    }
    @Test
    public void test(){
        System.out.println(1/2);
    }
}
