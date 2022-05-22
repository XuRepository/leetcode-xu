package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-15 16:54
 **/
public class _142环形链表 {

    //快慢指针
    public ListNode detectCycle(ListNode head) {

        if(head == null){
            return null;
        }else if(head.next == null){
            return null;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast!=slow && fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;

        }

        if(fast != slow){
            //无环
            return null;
        }

        ListNode index1 = head;
        ListNode index2 = slow;

        while(index1!=index2){
            index1 = index1.next;
            index2 = index2.next;

        }

        return index1;

    }

    //哈希表
    public ListNode hash(ListNode head){

        ListNode position = head;
        Set<ListNode> visited = new HashSet<ListNode>();

        while(position!=null){
            if(visited.contains(position)){
                return position;
            }else{
                visited.add(position);
            }
            position = position.next;
        }

        return null;

    }
}
