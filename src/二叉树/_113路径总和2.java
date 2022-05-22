package 二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-23 09:57
 **/
public class _113路径总和2 {



    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();

        if(root==null){
            return res;
        }

        path.add(root.val);

        findPath(root,targetSum,path,res);

        return res;

    }

    public void findPath(TreeNode root,int targetSum,List<Integer> path,List<List<Integer>> res){

        if (root == null){
            return;
        }
        //叶子节点
        if (root.left == null && root.right == null){
            if (root.val == targetSum ){
                //list.add的值是引用而非拷贝！！！所以在此要开辟一个新的空间！！
                res.add(new ArrayList<>(path));
                //叶子节点提前进入path了，这里不需要恢复系案场，因为return后会有一步返回现场的操作！
//                path.remove(path.size()-1);//恢复现场，因为return后到达了该节点的上一层
                return;
            }else{
//                path.remove(path.size()-1);//恢复现场，因为return后到达了该节点的上一层
                return;
            }
        }

        if (root.left!=null){
            path.add(root.left.val);
            findPath(root.left,targetSum-root.val,path,res);
            path.remove(path.size()-1);//回溯 恢复现场。
        }
        if (root.right!=null){
            path.add(root.right.val);
            findPath(root.right,targetSum-root.val,path,res);
            path.remove(path.size()-1);
        }

        return;

    }

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left=t2;
        t1.right=t3;

         pathSum(t1,4);

    }
}
