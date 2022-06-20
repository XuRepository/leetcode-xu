package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-21 15:49
 **/
public class _111二叉树的最小深度 {
    //1递归

    //最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    //
    //说明：叶子节点是指没有子节点的节点。
    public int minDepth1(TreeNode root) {

        if (root == null) return 0;
        int depth = 0;

        if (root.left == null && root.right!=null){
             depth = minDepth(root.right);
        } else if (root.left != null && root.right==null){
             depth = minDepth(root.left);
        } else {
             depth = Math.min(minDepth(root.left),minDepth(root.right));
        }

        return depth+1;

    }

    //3迭代
    public int minDepth2(TreeNode root) {
        //出口
        if (root == null) return 0;

        int level = 0;

        int min_depth = Integer.MAX_VALUE;

        Deque<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty()){

            int length = queue.size();//当前层的节点数量

            //当前层的节点进行全部弹出 并在弹出的时候把他们的子节点加队伍
            while(length>0){

                TreeNode cur = queue.pop();

                if (cur.left ==null && cur.right == null){
                    min_depth = Math.min(min_depth,level+1);
                }

                if(cur.left!=null){
                    queue.add(cur.left);
                }

                if(cur.right!=null){
                    queue.add(cur.right);
                }

                length--;
            }
            ++level;

        }
        return min_depth;
    }

    //2，递归
    public int minDepth(TreeNode root) {
        //出口
        if (root == null) return 0;

        //到达叶子节点
        if (root.left == null && root.right == null){
            return 1;//叶子节点为一层
        }

        int depth = Integer.MAX_VALUE;

        if (root.left!=null){
            depth = Math.min(depth,minDepth(root.left));
        }
        if (root.right != null){
            depth = Math.min(depth,minDepth(root.right));
        }

        return depth+1;

    }

}
