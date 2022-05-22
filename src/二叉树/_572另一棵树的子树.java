package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-21 09:20
 **/
public class _572另一棵树的子树 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        //递归出口
        if(root == null && subRoot == null) return true;
        else if(subRoot == null) return true;
        else if(root == null) return false;


        //递归内操作
        if(root.val == subRoot.val){
            if(isSameTree(root,subRoot)) return true;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

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
