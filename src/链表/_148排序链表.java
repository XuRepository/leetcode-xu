package 链表;

import com.sun.javafx.scene.layout.region.SliceSequenceConverter;
import com.sun.scenario.effect.Merge;

import javax.security.sasl.SaslServer;
import java.awt.image.Kernel;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-26 15:55
 **/
public class _148排序链表 {


    public ListNode sortList(ListNode head) {
        if (head == null) return head;

        int length = 0;
        while (head!=null){
            head = head.next;
            length++;
        }
        int subList;//每次排序的链表的步长！  从1到length/2就可以啦,从底部向上排序
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur;//记录当前排序组
        ListNode pre;//记录上一个排序组的

        for (subList = 1; subList < length; subList++) {
            cur = dummy.next;
            pre = dummy;
            while (cur.next!=null){
               ListNode head1 = cur;
               for (int i = 1; i < subList && cur.next!=null; i++) {
                    cur = cur.next;
               }
               //此时cur位置是head1的tail

               ListNode head2 = cur.next;
               cur.next = null;//断开head1和head2两个链表
                cur = head2;

                for (int i = 1; i < subList && cur.next!=null; i++) {
                    cur = cur.next;
                }
                //此时cur位置是head2的tail

                ListNode next = cur.next;//下一个两人组的起点head
                cur.next = null;//断开

                //合并
                ListNode merge = merge(head1, head2);
                pre.next = merge;

                while (pre.next!=null){
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummy.next;
    }
    //On
    private ListNode merge(ListNode head, ListNode slow) {
        ListNode first = head;
        ListNode second = slow;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (first!=null && second != null){
            if(first.val <= second.val){
                cur.next = first;
                cur = first;
                first = first.next;
            }else{
                cur.next = second;
                cur = second;
                second = second.next;
            }
        }
        if(first!=null){
            cur.next = first;
        }else{
            cur.next = second;
        }
        return dummy.next;
    }


    /**
     * 自顶向下
     * @param head
     * @return
     */
    public ListNode sortLis1t(ListNode head) {
        return sortMyList(head,null);
    }

    public ListNode sortMyList(ListNode head,ListNode tail){
        //出口
        if(head==tail) return null;
        if(head.next == tail){
            head.next = null;//打断不同链表之间的联系
            return head;
        }

        //归并
        //同时找到终点和最后一个节点！  fast走俩  slow走1 到达中点
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= tail){
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode first = sortMyList(head,slow);//On
        ListNode second = sortMyList(slow,fast);//On
        return merge(first, second);//On
    }





}
