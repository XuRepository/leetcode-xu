package 链表;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-30 11:26
 **/
public class _160相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB){
            pA = pA==null?headB:pA.next;
            pB = pB==null?headA:pB.next;
        }

        if(pA!=null) return pA;
        else return null;
    }
}
