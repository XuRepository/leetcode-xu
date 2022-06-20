package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-02 23:33
 **/
public class _700二叉搜索树中的搜索 {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null){
            return null;
        }

        if (root.val < val){
            return searchBST(root.right,val);
        }else if (root.val > val){
            return searchBST(root.left,val);
        }else {
            return root;
        }

    }

    // 迭代，利用二叉搜索树特点，优化，可以不需要栈
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null)
            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        return root;
    }

}
