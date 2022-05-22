package 栈与队列;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-20 16:11
 **/
public class _347前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {

        //排序
        Arrays.sort(nums);

        //优先队列，内容是一个二元组【数值，次数】
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p2[1] - p1[1];
            }
        });


        //双指针遍历，造窗口
        int left = 0;
        int right = 0;

        while (right < nums.length) {

            while(right < nums.length && nums[left] == nums[right]){
                right++;
            }

            queue.add(new int[]{nums[left], right - left});

            left = right;
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;

    }
}
