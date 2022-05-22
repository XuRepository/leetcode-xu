package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-23 09:02
 **/
public class _112路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) return false;
        //到达根节点：
        if (root.left == null && root.right == null){
            if (targetSum == root.val){
                return true;
            }
        }

        boolean left = hasPathSum(root.left,targetSum-root.val);

        boolean right = hasPathSum(root.right,targetSum-root.val);

        return left == true || right == true;

    }


}
