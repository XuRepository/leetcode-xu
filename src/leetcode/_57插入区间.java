package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-22 20:23
 **/
public class _57插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<int[]>();
        int i;
        for(i=0;i<intervals.length;i++){
            if(newInterval[0]>intervals[i][1]){
                res.add(intervals[i]);
            }else{
                if(newInterval[1] < intervals[i][0]){
                    res.add(newInterval);
                    res.add(intervals[i]);
                }else if(newInterval[1]<=intervals[i][1]){
                    int l = Math.min(newInterval[0],intervals[i][0]);
                    int r = intervals[i][1];
                    res.add(new int[]{l,r});
                }else{
                    int l = Math.min(newInterval[0],intervals[i][0]);
                    while(i<intervals.length && intervals[i][1]<newInterval[1]){
                        i++;
                    }
                    if(i == intervals.length) res.add(new int[]{l,newInterval[1]});
                    else if(intervals[i][0]<= newInterval[1])res.add(new int[]{l,intervals[i][1]});
                    else{
                        res.add(new int[]{l,newInterval[1]});
                        res.add(intervals[i]);
                    }
                }
                i++;
                break;
            }
        }
        while(i<intervals.length){
            res.add(intervals[i]);
        }

        return res.toArray(new int[res.size()][]);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<int[]>();
        int i;
        int left = newInterval[0];
        int right = newInterval[1];
        boolean flag = false;

        for(i=0;i<intervals.length;i++){
            //在右侧  无交集
            if(left >intervals[i][1]){
                res.add(intervals[i]);
            }else if(right<intervals[i][0]){
                if(!flag){
                    res.add(new int[]{left,right});
                    flag = true;
                }
                res.add(intervals[i]);
            }else{
                //有交集 合并交集！
                left = Math.min(left,intervals[i][0]);
                right = Math.max(right,intervals[i][1]);
            }
        }
        if (!flag){
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[res.size()][]);
    }
}
