package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-05 11:45
 **/
public class _701二叉搜索树中的插入操作 {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        //按照二叉搜索树的顺序，按照方向查找
        if (root == null){
            root = new TreeNode(val);
            return root;
        }

        if (val > root.val){
            root.right = insertIntoBST(root.right,val);
        }else if (val < root.val){
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

}
