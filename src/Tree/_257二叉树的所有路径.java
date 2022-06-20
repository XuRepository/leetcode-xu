package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-21 19:52
 **/
public class _257二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {


        List<String> res = new ArrayList<String>();

        if (root ==null){
            return res;
        }

        List<Integer> path = new ArrayList<Integer>();

        path.add(root.val);

        recursion(root,res,path);

        return res;

    }

    public void recursion(TreeNode root, List<String> res, List<Integer> path){

        //当前节点加入队列，本题目的可以保证加入的节点非空
//        path.add(root.val);

        if (root.left == null && root.right == null){
            //到达叶子节点，递归来到出口。
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1));

            res.add(sb.toString());

        }


        //回溯和递归要在同一个花括号才能够有效的恢复系案场！！
        if (root.left!=null){
            path.add(root.left.val);
            recursion(root.left,res,path);
            path.remove(path.size()-1);//回溯，恢复现场
        }

        if (root.right!=null){
            path.add(root.right.val);
            recursion(root.right,res,path);
            path.remove(path.size()-1);//回溯，恢复现场
        }

    }
}
