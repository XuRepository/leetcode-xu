package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-03 12:54
 **/
public class _530二叉搜索树的最小绝对差 {

    int min = Integer.MAX_VALUE;
    TreeNode pre ;

    //中序遍历 -- >递增 --> 找MIN
    public int getMinimumDifference(TreeNode root) {

        travel(root);
        return min;

    }

    public void travel(TreeNode root){

        if (root == null) return;

        //左
        travel(root.left);

        if (pre!=null){
            if (Math.abs(root.val - pre.val) < min){
                min = root.val - pre.val;
            }
        }
        pre = root;

        //右
        travel(root.right);

        return ;

    }

}
