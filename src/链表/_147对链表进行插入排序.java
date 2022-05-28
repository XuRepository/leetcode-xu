package 链表;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-26 16:31
 **/
public class _147对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {

        if (head == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode lastSorted = head;
        ListNode cur = lastSorted.next;


        while (cur!=null){
            if (cur.val >= lastSorted.val){
                lastSorted = lastSorted.next;
                cur = cur.next;
            }else{
                ListNode pre = dummy;
                while (pre.next.val<cur.val){
                    pre = pre.next;
                }
                lastSorted.next = cur.next;

                cur.next = pre.next;
                pre.next = cur;
                cur = lastSorted.next;
            }
        }
        return dummy.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = dummy;

        while (ptr.next!= null){
            ListNode pre = ptr;
            ListNode cur = ptr.next;
            int min = Integer.MAX_VALUE;
            ListNode maxNode = null;
            ListNode maxPre = null;

            while (cur!=null){

                if (min > cur.val){
                    min = cur.val;
                    maxNode = cur;
                    maxPre = pre;
                }
                pre = cur;
                cur = cur.next;
            }
            if (maxPre != null) {
                maxPre.next = maxPre.next.next;
            }

            maxNode.next = ptr.next;
            ptr.next = maxNode;
            ptr = ptr.next;
        }
        return dummy.next;
    }
}
