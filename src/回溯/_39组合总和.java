package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-06 22:16
 **/
public class _39组合总和 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        Arrays.sort(candidates);
        backTracing(candidates,target,0,0);

        return result;
    }

    //回溯法，深度未定，宽度为candidate的元素个数
    public void backTracing(int[] candidates, int target , int sum ,int startIndex){

        //出口
        if (sum == target){
            result.add(new ArrayList<>(new ArrayList<>(path)));
            return;
        }

        for (int i = startIndex ; i < candidates.length; i++) {

            if (sum + candidates[i] > target) return;//剪枝

            sum += candidates[i];
            path.add(candidates[i]);

            backTracing(candidates,target,sum,i);//关键点:不用i+1了，表示可以重复读取当前的数

            sum-=candidates[i];
            path.remove(path.size()-1);

        }

    }
}
