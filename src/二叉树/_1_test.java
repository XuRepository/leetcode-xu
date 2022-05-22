//package 二叉树;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @program: leetcode2022
// * @description:
// * @author: XuJY
// * @create: 2022-04-06 19:23
// **/
//public class _1_test {
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<String>();
//
//        if (root == null) return res;
//
//        List<Integer> path = new ArrayList<>();
//
//        dfs(root,res,path);
//
//    }
//
//    int sum;
//    private void dfs(TreeNode root) {
//        if (root == null) {
//
//        }
//
//        if (root.left!=null){
//            dfs(root.left);
//        }
//        if (root.right!=null){
//            dfs(root.right);
//        }
//
//
//    }
//}
//
