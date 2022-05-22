package 回溯;

import java.util.*;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-08 13:23
 **/
public class _491递增子序列 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        backtracking(nums,0);
        return result;

    }

    private void backtracking (int[] nums, int start) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        int[] used = new int[201];//这里使用数组来进行去重操作，题目说数值范围[-100, 100]
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    (used[nums[i] + 100] == 1)) continue;
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public void backTracking1(int[] nums,  int startIndex ){

        //保存每个节点的结果
        if (path.size()>1){
            result.add(new ArrayList<>(path));
        }

        //出口
        if (startIndex == nums.length){
            return ;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = startIndex; i < nums.length ; i++) {
            //去重判断，因为有重复值.但是本题目没有对nums进行排序，也不能排序。所以需要一个set来判断当前一层加入的元素是否被使用过！
            if (set.contains(nums[i])){
                continue;
            }

            if (!path.isEmpty() && nums[i] < path.get(path.size()-1)){
                continue;
            }

            set.add(nums[i]);

            path.add(nums[i]);


            backTracking1(nums,i+1);


            path.remove(path.size()-1);


        }

    }


}
