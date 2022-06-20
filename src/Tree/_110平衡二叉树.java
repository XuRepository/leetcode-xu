package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-21 21:15
 **/
public class _110平衡二叉树 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        return maxHeight(root)!=-1;

    }

    public int maxHeight(TreeNode root) {

        //出口
        if(root == null)return 0;

        int left = maxHeight(root.left);
        if (left == -1){
            return -1;
        }
        int right = maxHeight(root.right);
        if (right==-1){
            return -1;
        }

        if (Math.abs(left - right)>1){
            return -1;
        }

        int depth = 1+Math.max(left,right);

        return depth;
    }

}
