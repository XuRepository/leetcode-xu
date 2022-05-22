package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-17 14:27
 **/
public class _23合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (true){
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for(int i=0;i< lists.length;i++){
                if (lists[i] == null) continue;
                if (lists[i].val < minValue){
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }
            if (minIndex==-1) break;

            cur.next =  lists[minIndex];
            cur = cur.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return dummy.next;
    }

    //堆排序，优先队列
    public ListNode mergeKLists1(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for (ListNode node :lists){
            if(node!=null){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            ListNode n1 = queue.poll();
            cur.next = n1;
            cur = cur.next;

            if (n1.next!=null){
                queue.offer(n1.next);
            }
        }
        return dummy.next;
    }
}