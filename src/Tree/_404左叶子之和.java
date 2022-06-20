package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-22 14:43
 **/
public class _404左叶子之和 {

    public int sumOfLeftLeaves(TreeNode root) {

        //左叶子之和：先找叶子 在找叶子的时候判断叶子是否是左叶子
        //出口
        if (root==null){
            return 0;
        }



        //改题目sum是值传递而非指针传递，所以说不需要恢复现场
        int left = sumOfLeftLeaves(root.left);

        int right = sumOfLeftLeaves(root.right);

        int value = 0;

        if (root.left != null && root.left.left==null&&root.left.right==null){
            value = root.left.val;
        }

        return left+right+value;

    }

}
