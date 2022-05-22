package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-03 15:15
 **/
public class _236二叉树的最近公共祖先 {

    /**
     * 公共祖先，后序遍历，从底往上遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //递归出口
        if (root == p || root == q || root == null) return root;

        //后序遍历 一定是从底向上遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);


        if(left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if(left == null && right != null) { // 若找到一个节点
            return right;
        }else if(left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return root;
        }


    }


}
