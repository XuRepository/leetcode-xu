package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-21 09:09
 **/
public class _100相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //递归出口
        if(p==null && q == null) return true;
        else if(p==null || q == null) return false;
        else if(p.val!=q.val) return false;

        //进入递归

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;

    }


}
