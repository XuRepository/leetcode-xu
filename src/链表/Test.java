package 链表;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-11 22:19
 **/
public class Test {
    @org.junit.Test
    public void test(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));          //返回3

    }
}
