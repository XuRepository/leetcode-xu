package 栈与队列;

import java.util.Stack;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-19 19:37
 **/
public class _232用栈实现队列 {

    class MyQueue {

        Stack<Integer> stack1;//入队

        Stack<Integer> stack2;//出队

        public MyQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void push(int x) {

            stack1.push(x);

        }

        public int pop() {

            if(stack2.isEmpty()){

                while(!stack1.isEmpty()){

                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();

        }

        public int peek() {

            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }

            return stack2.peek();

        }

        public boolean empty() {
            return (stack1.isEmpty() && stack2.isEmpty());
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
