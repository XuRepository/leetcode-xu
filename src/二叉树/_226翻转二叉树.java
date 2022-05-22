package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-20 20:56
 **/
public class _226翻转二叉树 {

    //先序遍历过程中进行交换子树
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        
        TreeNode temp = new TreeNode();

        temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        
        return root;

    }

}
