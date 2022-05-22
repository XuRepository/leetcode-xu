package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-20 21:08
 **/
public class DFS {
    // 前序遍历·递归·LC144_二叉树的前序遍历
    void preOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);           // 注意这一句
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    // 中序遍历·递归·LC94_二叉树的中序遍历
    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);             // 注意这一句
        inorder(root.right, list);
    }


    // 后序遍历·递归·LC145_二叉树的后序遍历
    void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);             // 注意这一句
    }


    //迭代
    //1 前序遍历 迭代
    void preOrder_1(TreeNode root,ArrayList<Integer> res){
        Stack<TreeNode> stack = new Stack<>();

        if (root == null){
            return ;
        }
        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode node = stack.pop();
            res.add(node.val);

            //孩子节点入栈
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }

    //中序遍历_迭代
    void inorder_1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur!=null || !stack.isEmpty()){

            if (cur != null){
                //进站
                stack.push(cur);
                cur = cur.left;
            }else{
                //遍历到空姐点了  出战
                cur = stack.pop();

                list.add(cur.val);
                cur = cur.right;
            }
        }
    }

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.left != null){
                    stack.push(node.left);
                }
                if (node.right != null){
                    stack.push(node.right);
                }
            }
            Collections.reverse(result);
            return result;
        }
    }


}
