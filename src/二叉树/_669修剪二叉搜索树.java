package 二叉树;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-05 21:29
 **/
public class _669修剪二叉搜索树 {

    //递归
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //1,出口
        if (root == null) return root;

        //中
        //首先得判断一下root是否在low和high中间
        if (root.val > high) return trimBST(root.left,low,high);
        if (root.val < low) return trimBST(root.right,low,high);


        //左
        if(root.left!=null && root.left.val < low){
            //左侧的孩子小于low，把左孩子的右子树接过来继续递归
            root.left = root.left.right;
        }
        root.left = trimBST(root.left,low,high);

        //右
        if(root.right!=null && root.right.val > high){
            //左侧的孩子小于low，把左孩子的右子树接过来继续递归
            root.right = root.right.left;
        }
        root.right = trimBST(root.right,low,high);

        return root;//其实遍历整棵树不需要返回值的，这里二叉搜索树返回的是每次遍历本身输入的root，不过中间对root这棵树进行了更新。
        //使用递归的返回值可以更方便的对树进行修改

    }







        //迭代
    public TreeNode trimBST1(TreeNode root, int low, int high) {

        //1，有
        //2，没
        if (root== null) return null;

        TreeNode cur = root;
        //找遇到的第一个位于low和high之间的root节点，作为新的根节点。然后再root左右寻找low和high
        while(cur!=null){

            if (cur.val<low){
                cur = cur.right;
            }
            if (cur.val>high){
                cur = cur.left;
            }
        }

        TreeNode root1= cur;

        //左子树
        while(cur!=null){

            while (cur.left!=null && cur.left.val < low){
                cur.left =  cur.left.right;
            }
            cur = cur.left;
        }


        //找右子树
        while(cur!=null){

            while (cur.right!=null && cur.right.val >high){
                cur.right =  cur.right.left;
            }
            cur = cur.right;
        }

        return root1;
    }

}
