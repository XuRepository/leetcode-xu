package 栈与队列;

import java.util.Stack;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-29 22:17
 **/
public class MinStack2 {
    //不使用额外空间！使用栈保存 当前插入元素 和 插入前的min 的差值！

    //栈内保存的是 当前元素 - 上一个元素时的全局min = diff
    Stack<Long> stack;
    int min ;


    public MinStack2() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()){
            min = val;
            stack.push(0L);
        }else {
            Long diff = Long.valueOf(val) - min;
            stack.push(diff);
            min = Math.min(min,val);
        }
    }

    public void pop() {
        Long diff = stack.pop();
        if (diff <0){//val - 上一个min <0 ，那么加入val时，会被更新为当前的min = val。pop时需要恢复上一个min
            min = (int)(min - diff);
        }else{
           //val - 上一个min > 0 ，那么当前的min  就是上一个元素的min，pop不需要更新min
        }

    }

    public int top() {
        Long diff = stack.peek();
        if (diff <0){//val - 上一个min <0 ，那么加入val时，会被更新为当前的min = val。
            return min;
        }else{
            return (int)(min+diff);
        }
    }

    public int getMin() {
        return min;
    }
}
