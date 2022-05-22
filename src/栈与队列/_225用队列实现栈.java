package 栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-19 20:03
 **/
public class _225用队列实现栈 {

    class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {

            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();

        }

        public void push(int x) {

            queue1.add(x);

        }

        public int pop() {

            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }

            int res = queue1.poll();

            while(queue2.size()>0){
                queue1.add(queue2.poll());
            }

            return res;

        }

        public int top() {

            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }

            int res = queue1.peek();

            queue2.add(queue1.poll());

            while(queue2.size()>0){
                queue1.add(queue2.poll());
            }

            return res;

        }

        public boolean empty() {

            return queue1.size()==0;

        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
