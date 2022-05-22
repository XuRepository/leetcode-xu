package 二叉树;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-05 20:21
 **/
public class _450删除二叉搜索树中的节点 {


    public TreeNode deleteNode(TreeNode root, int key) {

        //如果是叶子节点，直接干掉

        //如果不是叶子节点 就得保存父亲和孩子。

        //二叉搜索树，有序的二叉树，一般采用先序遍历自顶向下操作

        //递归方法，返回值是当前树更新后的根节点,这样可以通过递归的返回值来传递当前的根节点


        //递归出口,到头了也没找到！
        if (root == null) return root;

        //中
        if (root.val == key){
            //1,左右孩子都无
            if (root.left == null && root.right == null){
                return null;
            }

            //2,有左没右
            if (root.left != null && root.right == null){

                return root.left;
            }
            //3有右没左
            if (root.left == null && root.right != null){

                return root.right;
            }

            //4有左有右
            if (root.left != null && root.right != null){

                //找右孩子的最坐下节点
                TreeNode cur = root.right;
                while(cur.left!=null){
                    cur = cur.left;
                }

                cur.left = root.left;

                return root.right;//返回值就是当前递归的子树的新的根节点！
            }
        }


        //左
        if (key<root.val)root.left = deleteNode(root.left,key);
        //右
        if (key > root.val)root.right = deleteNode(root.right,key);

        return root;

    }

}
