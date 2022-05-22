package 链表;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-10 23:40
 **/
public class _203移除元素 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1,head);//虚拟节点作为头节点

        ListNode prior = dummy;
        ListNode current = head;

        while(current!=null){

            if(current.val == val){
                prior.next = current.next;
            }else{
                prior = current;
            }

            current = current.next;

        }
        return dummy.next;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = l1;
        System.out.println(l1);
        System.out.println(l2);
        l2.val=2;
        System.out.println(l1.val);
        l1.val=4;
        System.out.println(l2.val);
    }
}
