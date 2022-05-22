package 链表;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-13 16:09
 **/
public class _024两两交换链表相邻节点 {
    /**
     * Definition for singly-linked list.
     * public class leetcode.ListNode {
     * int val;
     * leetcode.ListNode next;
     * leetcode.ListNode() {}
     * leetcode.ListNode(int val) { this.val = val; }
     * leetcode.ListNode(int val, leetcode.ListNode next) { this.val = val; this.next = next; }
     * }
     */
    //1，递归
    public ListNode swapPairs(ListNode head) {

        //设置递归出口
        if(head==null||head.next==null){
            return head;
        }

        ListNode temp = head.next;//记录下后一个元素
        head.next = swapPairs(temp.next);//后一个元素的下一个元素是递归后的首元素
        temp.next = head;//后一个元素和首元素对调

        return temp;

    }


    //2迭代
    public ListNode iterate2(ListNode head){

        //设置头节点，然后两个两个一组，对头节点后面俩元素对调。然后令标记点为对调后的最后一个元素，继续进行。
        ListNode dummyNode = new ListNode(0,head);
        ListNode cur = dummyNode;

        while(cur.next!=null && cur.next.next!=null){

            //当标记节点后方俩元素不为空 交换！
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;

            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            cur = node1;
        }

        return dummyNode.next;

    }

    //2迭代
    public ListNode iterate(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        ListNode later = null;

        int index = 0;

        while(cur!=null){

            temp = cur.next;

            if(index%2 == 1){
                //进来的是一对元素的第二个，则反转该元素和前一个元素的位置

                cur.next = pre;
                pre.next = temp;

                if(index>1){
                    later.next = cur;
                }else{
                    head = cur;
                }

                later = pre;//记录每一对元素的最后一个  方便进行和下一组第一个元素的later.next的修改

            }else{
                //进来的元素是第一个？
            }

            pre = cur;
            cur = temp;

            index++;

        }
        return head;

    }
}


