package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-02 18:10
 **/
public class _105从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);

    }

    public TreeNode build(int[] preorder,int preLeft,int preRight,
                          int[] inorder,int inLeft,int inRight){

        if (inLeft > inRight || preLeft > preRight)return null;

        //1找先序的头节点
        int root = preorder[preLeft];
        TreeNode node = new TreeNode(root);

        if (preLeft == preRight)return node;//叶子

        //2找中序的切割点
        int cut = inLeft;
        for (; cut <= inRight; cut++) {
            if (inorder[cut]==root){
                break;
            }
        }

        //3切割中序(左闭右开)
        int leftInLeft =inLeft;
        int leftInRight = cut-1;

        int rightInLeft =cut+1;
        int rightInRight = inRight;

        //4切割先序(左闭右开)
        int leftPreLeft =preLeft+1;
        int leftPreRight = preLeft + cut - inLeft ;

        int rightPreLeft =leftPreRight+1;
        int rightPreRight = preRight;

        //递归左右
        node.left = build(preorder,leftPreLeft,leftPreRight,
                inorder,leftInLeft,leftInRight);
        node.right = build(preorder,rightPreLeft,rightPreRight,
                inorder,rightInLeft,rightInRight);

        return node;
    }
}
