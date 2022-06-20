package Tree;

import java.util.ArrayList;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-03 00:00
 **/
public class _98验证二叉搜索树 {



    // 递归
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }


    ArrayList<Integer> list = new ArrayList<Integer>();

    //要知道中序遍历下，输出的二叉搜索树节点的数值是有序序列。
    public boolean isValidBS1T(TreeNode root) {

        if (root==null) return true;

        boolean left = isValidBST(root.left);
        if (!left) return false;

        list.add(root.val);

        boolean right = isValidBST(root.right);
        if (!right) return false;


        for (int i = 1 ;i < list.size();i++){

            if (list.get(i-1)>=list.get(i)){
                return false;
            }

        }
        return true;

    }



}
