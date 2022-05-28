package 链表;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-26 12:09
 **/
public class _141环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return false;
    }
}
