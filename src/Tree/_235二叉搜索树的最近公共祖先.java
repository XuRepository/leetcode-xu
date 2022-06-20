package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-04 23:10
 **/
public class _235二叉搜索树的最近公共祖先 {

    //如果是普通的二叉树，需要后序遍历来自底向下寻找

    //但是如果是二叉搜索树，找最底下的节点，满足left<=root,right>=root

    TreeNode big;
    TreeNode small;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        compare(p,q);
        return travel(root);

    }

    public TreeNode travel(TreeNode root){



        if (root == null || root ==small || root ==big) return root;

        TreeNode left = null;
        TreeNode right = null;

        if (root.val>big.val){
            return travel(root.left);
        }else if (root.val<small.val){
            return travel(root.right);
        }else{
            return root;
        }

    }

    public void compare(TreeNode p, TreeNode q){

        if (p.val>q.val){
            big = p ;
            small = q;
        }else{
            big = q;
            small = p;
        }

    }



}
