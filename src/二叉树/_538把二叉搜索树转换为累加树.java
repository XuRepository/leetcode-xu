package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-06 14:47
 **/
public class _538把二叉搜索树转换为累加树 {

    TreeNode pre;


    public TreeNode convertBST(TreeNode root) {


        //递归出口
        if (root == null) return root;

        //右侧
        TreeNode right = convertBST(root.right);

        //中间
        root.val = root.val + pre.val;
        pre = root;

        //左侧
        TreeNode left = convertBST(root.left);


        return root;

    }

}
