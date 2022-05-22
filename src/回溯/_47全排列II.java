package 回溯;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-08 16:42
 **/
public class _47全排列II {


    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        boolean[] usedD = new boolean[nums.length];//深度的used数组
        System.out.println(usedD[0]);

        backTracking(nums,usedD);
        return result;
    }


    public void backTracking(int[] nums,boolean[] usedD){

        //出口
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return ;
        }

        //排列问题，每次从集合中取值的时候，不是顺序取的！，需要一个usd数组判断这一树枝哪些取过了，哪些没取过

//        boolean[] usedB = new boolean[nums.length];//统计宽度上，该层的元素是否使用过
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {

            if (usedD[i] || set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);

//            if (i>0 && nums[i] == nums[i-1] && usedB[i-1]==true){
//                continue;
//            }


            usedD[i] = true;//当前树枝的第i个元素已经用过
            path.add(nums[i]);

            backTracking(nums,usedD);

            usedD[i] = false;
            path.remove(path.size()-1);

        }
    }
}
