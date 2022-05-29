package 栈与队列;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-29 21:48
 **/
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;


    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (!minStack.isEmpty()){
            minStack.push(Math.min(val,minStack.peek()));
        }else{
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
