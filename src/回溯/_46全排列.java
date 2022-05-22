package 回溯;

import junit.extensions.TestDecorator;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-08 15:44
 **/
public class _46全排列 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean[] used = new boolean[nums.length];
        System.out.println(used[0]);

        backTracking(nums,used);
        return result;
    }


    public void backTracking(int[] nums,boolean[] used){

        //出口
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return ;
        }

        //排列问题，每次从集合中取值的时候，不是顺序取的！，需要一个usd数组判断这一树枝哪些取过了，哪些没取过

        for (int i = 0; i < nums.length; i++) {



            if (used[i]){
                continue;
            }



            used[i] = true;//当前树枝的第i个元素已经用过
            path.add(nums[i]);

            backTracking(nums,used);

            used[i] = false;

            path.remove(path.size()-1);

        }
    }
    @Test
    public void test(){
        permute(new int[]{1});
    }
}
