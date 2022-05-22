package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-08 00:10
 **/
public class _78子集 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>(path));
        backTracking(nums,0);
        return result;
    }

    private void backTracking(int[] nums,  int startIndex){
        //终止条件,因为子集问题需要收集所有节点的结果，所以递归的深度就是startIndex到了数组的结尾！
        if (startIndex == nums.length){
            return ;
        }

        for (int i = startIndex; i < nums.length; i++) {

            path.add(nums[i]);
            result.add(new ArrayList<>(path));

            backTracking(nums,i+1);

            path.remove(path.size()-1);

        }
    }

}
