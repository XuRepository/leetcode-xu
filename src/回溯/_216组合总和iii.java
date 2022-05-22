package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-06 19:21
 **/
public class _216组合总和iii {


    List<List<Integer>> res = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        backTracking(k,n,1,0);
        return res;

    }

    public void backTracking(int k,int n,int startIndex,int sum){

        if (path.size() == k){
            if (sum == n)
                res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < 9-(k-path.size())+1; i++) {
            //剪枝
            if (sum + i > n){
                break;
            }

            sum+=i;
            path.add(i);

            backTracking(k,n,i+1,sum);

            path.remove(path.size()-1);
            sum -=i;

        }
    }
}
