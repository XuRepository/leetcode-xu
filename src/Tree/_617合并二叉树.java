package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-02 22:11
 **/
public class _617合并二叉树 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        //先序遍历
        if (root1 == null && root2 == null) return null;
        int sum = 0;

        if (root1!=null){
            sum+=root1.val;
        }
        if (root2!=null){
            sum+=root2.val;
        }
        TreeNode node = new TreeNode(sum);

        if (root1==null){
            node.left = mergeTrees(null,root2.left);
            node.right = mergeTrees(null,root2.right);
        }else if (root2==null){
            node.left = mergeTrees(root1.left,null);
            node.right = mergeTrees(root1.right,null);
        }else{
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right,root2.right);
        }

        return node;

    }
}
