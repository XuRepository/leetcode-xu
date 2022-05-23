package 二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-23 17:54
 **/
public class _114二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null) {
            flatten(root.right);
            return;
        }
        //因为右侧节点在访问完毕左子树 最后一个节点之后就会被访问到，所以考虑把右字数放到左子树的最右侧节点。

        TreeNode node = root.left;//左子树最右侧！
        while (node.right!=null){
            node = node.right;
        }
        node.right = root.right;
        flatten(root.left);

        root.right = root.left;
        root.left=null;

    }

    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur!=null){
            TreeNode next = cur.left;
            TreeNode maxRight = cur.left;
            if (next!=null){
                //左子树最右节点
                while (maxRight.right!=null){
                    maxRight = maxRight.right;
                }
                maxRight.right = cur.right;
                cur.right = cur.left;
                cur.left=null;
            }
            cur = cur.right;
        }

    }




    public void flatten1(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        dfs(root,queue);
        if (queue.isEmpty()) return;
        TreeNode cur = queue.pop();
        while (!queue.isEmpty()){
            cur.left = null;
            cur.right = queue.pop();
            cur = cur.right;
        }
    }

    public void dfs(TreeNode root, Deque<TreeNode> res){
        if (root!=null){
            res.add(root);
            dfs(root.left,res);
            dfs(root.right,res);
        }
    }
}

