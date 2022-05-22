package 链表;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-14 23:00
 **/
public class _019删除链表的倒数第n节点 {

    //暴力法可以遍历两遍，第一遍找链表长度，第二遍找倒数第N个

    //On的方法：双指针，只遍历一编。
    //双指针的经典应用，如果要删除倒数第n个节点，
    // 让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。
    // 删掉slow所指向的节点就可以了。
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //虚拟头节点dummy
        ListNode dummy = new ListNode(0,head);

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummy;

        int i = 0;//记录到第几个节点了
        while(fast!=null){
            fast = fast.next;

            if(i>n-1){

                pre = slow;
                slow = slow.next;
            }

            i++;

        }
        //slow最后指向倒数第n个元素
        pre.next = slow.next;

        return dummy.next;

    }
}
