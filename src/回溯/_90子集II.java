package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-08 00:30
 **/
public class _90子集II {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracking(nums,0,used);
        return result;
    }
    //因为是存在重复的nums，类似于组合问题的存在重复。此时需要先排序，然后分层和分树枝进行去重操作！
    public void backTracking(int[] nums,  int startIndex , boolean[] used){
        result.add(new ArrayList<>(path));

        //终止条件,因为子集问题需要收集所有节点的结果，所以递归的深度就是startIndex到了数组的结尾！
        if (startIndex == nums.length){
            return ;
        }

        for (int i = startIndex; i < nums.length ; i++) {
            //树层去重
            if (i>0 && nums[i]== nums[i-1] && used[i-1]==false){
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            backTracking(nums,i+1,used);

            used[i] = false;
            path.remove(path.size()-1);

        }
    }
}
