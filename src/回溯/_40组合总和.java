package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-07 00:00
 **/
public class _40组合总和 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backTracing(candidates,target,0,0,used);

        return result;
    }

    //回溯法，深度未定，宽度为candidate的元素个数
    public void backTracing(int[] candidates, int target , int sum ,int startIndex,boolean[] used){

        //出口
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex ; i < candidates.length; i++) {

            if (i>0 && candidates[i] == candidates[i-1] && used[i-1] == false){
                continue;
            }

            if (sum + candidates[i] > target) return;//剪枝

            sum += candidates[i];
            used[i] = true;
            path.add(candidates[i]);

            backTracing(candidates,target,sum,i+1,used);//关键点:不用i+1了，表示可以重复读取当前的数

            used[i] = false;
            sum-=candidates[i];
            path.remove(path.size()-1);

        }

    }
}
