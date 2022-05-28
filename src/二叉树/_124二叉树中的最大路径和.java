package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-25 23:35
 **/
public class _124二叉树中的最大路径和 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        //递归
        getBig(root);
        return max;
    }

    public int getBig(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(getBig(root.left),0);
        int right = Math.max(getBig(root.right),0);

        int curMax = root.val+left+right;
        if (curMax > max) max = curMax;

        return root.val+Math.max(left,right);

    }


}
