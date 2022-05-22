package 链表;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-15 15:48
 **/
public class _面试题_02_07链表相交 {
    /*
    a为相交前的节点数，c为相交点到链表结尾的节点数。

    若相交，链表A： a+c, 链表B : b+c
    a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。
    若不相交，a+b = b+a 。因此相遇处是NULL

     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode l1 = headA;
        ListNode l2 = headB;

        while(l1 != l2){
            l1 = l1==null?headB:l1.next;
            l2 = l2==null?headA:l2.next;
        }
        return l1;
    }
}
