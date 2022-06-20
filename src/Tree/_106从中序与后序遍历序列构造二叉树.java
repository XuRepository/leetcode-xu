package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-23 15:16
 **/
public class _106从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {


        if (postorder.length==0)return null;

        int length = postorder.length;

        //1，找后序遍历的根节点
        int root = postorder[postorder.length-1];
        TreeNode node = new TreeNode(root);


        if (postorder.length==1)return node;


        //2，找中序的切割点
        int cut = 0;
        for (;cut < length; cut++) {
            if (inorder[cut]==root){
                break;
            }
        }

        //3，切割中序
        int[] leftIn = new int[cut];
        int[] rightIn = new int[length - cut -1];

        for (int i = 0; i < cut ; i++) {
            leftIn[i] = inorder[i];
        }

        for (int i = cut+1; i < length; i++) {
            rightIn[i-cut-1] = inorder[i];
        }

        //4,切割后序
        int[] leftPost = new int[cut];
        int[] rightPost = new int[length - cut -1];
        for (int i = 0; i < cut; i++) {
            leftPost[i] = postorder[i];
        }
        for (int i = cut; i < length-1; i++) {
            rightPost[i-cut] = postorder[i];
        }

        //5,递归左右分支
        node.left = buildTree(leftIn,leftPost);
        node.right = buildTree(rightIn,rightPost);

        return node;

    }

}
