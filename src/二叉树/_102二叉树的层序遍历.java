package 二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-20 20:25
 **/
public class _102二叉树的层序遍历 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    //层序遍历，广度搜索 使用队列
    //深度遍历 深度搜索  使用栈
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root == null) return res;


        Deque<二叉树.TreeNode> queue = new LinkedList<二叉树.TreeNode>();

        queue.add(root);

        while(!queue.isEmpty()){

            ArrayList<Integer> list = new ArrayList<>();

            int length = queue.size();//当前层的节点数量

            //当前层的节点进行全部弹出 并在弹出的时候把他们的子节点加队伍
            while(length>0){

                TreeNode cur = queue.pop();

                list.add(cur.val);

                if(cur.left!=null){
                    queue.add(cur.left);
                }

                if(cur.right!=null){
                    queue.add(cur.right);
                }

                length--;
            }
            res.add(list);
        }

        return res;

    }
}
