package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-20 20:28
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
