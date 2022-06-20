package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-21 14:08
 **/
public class _104二叉树的最大深度 {

    //方法2 DFS遍历数层数
    public int maxDepth(TreeNode root) {

        //出口
        if(root == null)return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = 1+Math.max(left,right);

        return depth;
    }

    //方法1 层序遍历数层数
    public int maxDepth1(TreeNode root) {

        int level = 0;

        if(root == null) return level;

        Deque<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty()){

            int length = queue.size();//当前层的节点数量

            //当前层的节点进行全部弹出 并在弹出的时候把他们的子节点加队伍
            while(length>0){

                TreeNode cur = queue.pop();

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

        return level;
    }


}
