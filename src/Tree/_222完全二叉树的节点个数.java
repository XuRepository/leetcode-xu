package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-21 16:51
 **/
public class _222完全二叉树的节点个数 {


    //完全二叉树
    public int countNodes(TreeNode root) {

        if (root == null){
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth){
            //左子树是完全二叉树
            return (1 << leftDepth) + countNodes(root.right);
            //2 << leftDepth   =====》    2的leftDepth次方-1 为左子树  +1为root

        }else{
            //右子树为完全二叉树，左子树不是
            return (1 << rightDepth) + countNodes(root.left);

        }

    }

    public int getDepth(TreeNode node){

        if (node == null){
            return 0;
        }

        int depth = 0;

        while (node!=null){
            node = node.left;
            depth+=1;
        }
        return depth;

    }


    //普通二叉树递归
    public int countNodes1(TreeNode root) {

        if (root == null){
            return 0;
        }

        return countNodes(root.left)+countNodes(root.right)+1;
    }

}
