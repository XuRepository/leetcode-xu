package 链表;

/**
 * @program: leetcode2022
 * @description:正向遍历，然后头部插入即可！
 * @author: XuJY
 * @create: 2022-02-13 14:04
 **/
public class _206反转链表 {


    //递归，该方法让当前元素之后的链表全部倒置
    public ListNode reverseList(ListNode head) {

        //出口
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        //递归的目标是让除掉当前head的后面的链表倒置，递归方法的返回值是该链表的首元素！
        head.next = reverseList(newHead);
        newHead.next = head;

        return newHead;

    }



        //双指针 将链表的next修改为反方向即可。
    public ListNode solution1(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next  = null;

        while(cur!=null){

            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;

    }


        //新建链表 头部插入。0n  但是很浪费空间
    public ListNode reverseList1(ListNode head) {

        ListNode dummy = new ListNode();

        ListNode current =  head;
        while(current != null){

            //头部插入当前链表的每个元素
            ListNode node = new ListNode(current.val,dummy.next);
            dummy.next = node;

        }


        return dummy.next;
    }
}
