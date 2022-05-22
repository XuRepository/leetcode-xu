package 二叉树;

import java.util.*;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-03 14:09
 **/
public class _501二叉搜索树中的众数 {

    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void findMode1(TreeNode root) {
        if (root == null) {
            return;
        }
        findMode1(root.left);

        int rootValue = root.val;
        // 计数
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果以及maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(rootValue);
        }
        pre = root;

        findMode1(root.right);
    }












    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();


    public int[] findMod1(TreeNode root) {

        int max = 0;

        travel(root);

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (max <= entry.getValue()){
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == max){
                list.add(entry.getKey());
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;

    }

    public void travel(TreeNode root){

        if (root == null) return ;

        travel(root.left);

        if (map.containsKey(root.val))
            map.put(root.val,map.get(root.val)+1);
        else
            map.put(root.val,1);

        travel(root.right);

    }

}
