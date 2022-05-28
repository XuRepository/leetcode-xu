package 设计;

import org.hamcrest.core.Is;
import org.junit.Test;

import javax.swing.*;
import java.util.*;

/**
 * @program: leetcode2022
 * @description: 维护一个访问顺序队列visitQueue，访问到元素or插入元素的时候
 *https://leetcode.cn/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 * @author: XuJY
 * @create: 2022-05-26 12:55
 **/
public class LRUCache {
    Map<Integer,DLinkedNode> map;
    int capacity;

    //虚拟头尾巴节点,双向链表//维护了当前的一个访问顺序，不重复！
    DLinkedNode head;
    DLinkedNode tail;


    public LRUCache(int capacity) {

        map = new HashMap<>(capacity);
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            DLinkedNode curNode = map.get(key);
            curNode.pre.next = curNode.next;
            curNode.next.pre = curNode.pre;
            moveToTail(curNode);
            return curNode.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            //如果存在，更新node并且移动到当前链表的尾部
            DLinkedNode insertNode = map.get(key);
            insertNode.v = value;

            insertNode.pre.next = insertNode.next;
            insertNode.next.pre = insertNode.pre;
            moveToTail(insertNode);
            map.put(key,insertNode);
        }else {
            if (map.size()>=capacity){
                //队头元素是最近最久未访问 删除！
                DLinkedNode toDelete = head.next;
                head.next = toDelete.next;
                toDelete.next.pre = head;
                map.remove(toDelete.k);
            }
            //直接插入
            DLinkedNode insertNode = new DLinkedNode(key, value);
            moveToTail(insertNode);
            map.put(key,insertNode);
        }

    }

    private void moveToTail(DLinkedNode curNode) {
        //移动当前节点到双向链表的尾部
        tail.pre.next = curNode;
        curNode.pre = tail.pre;
        tail.pre = curNode;
        curNode.next = tail;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(1);
        cache.put(2,1);
        cache.put(3,2);
        cache.get(2);
        cache.get(3);
    }
}
class DLinkedNode{

    int k,v;

    DLinkedNode pre;
    DLinkedNode next;
    public DLinkedNode(){};

    public DLinkedNode(int k, int v) {
        this.k = k;
        this.v = v;
    }
}
