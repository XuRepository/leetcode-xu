package 链表;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-17 13:41
 **/
public class _21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (list1!=null && list2!=null){
            if (list1.val>list2.val){
                cur.next = list2;
                list2 = list2.next;
            }else{
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if (list1!=null){
            cur.next = list1;
        }else{
            cur.next = list2;
        }
        return dummy.next;
    }
}
