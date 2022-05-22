package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-20 21:13
 **/
public class _101对称二叉树 {
    //
    //递归，这个判断对称二叉树，判断的是两棵子树，而不是两个子节点的数字
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return compare(root.left,root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        //递归出口
        if(left == null && right == null) return true;
        else if(left == null && right!=null) return false;
        else if(left != null && right==null) return false;
        else if(left.val!=right.val) return false;

        //递归内操作
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);

        return outside&inside;
    }

    //迭代法：


}
