package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-22 19:28
 **/
public class _56合并区间 {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int min = intervals[0][0];
        int max = intervals[0][1];;
        int count = 0;
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        for (int i =1 ; i < res.length; i++) {
            int curMin = intervals[i][0];
            int curMax = intervals[i][1];

            if (curMin <= max){
                max = Math.max(max,curMax);
                res[count][1] =max;
            }else{
                count++;
                min = curMin;
                max  =curMax;
                res[count][0] = curMin;
                res[count][1] = curMax;

            }
        }

        return Arrays.copyOf(res,count+1);
    }

    public int[][] merge1(int[][] intervals) {
        ArrayList<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    @Test
    public void test(){
        merge(new int[][]{{1,4},{0,4}});
    }
}
