package 栈与队列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-19 21:19
 **/
public class _1047删除字符串中的所有相邻重复项 {

    public String removeDuplicates(String s) {

            Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(stack.size()==0 || stack.peek()!=c){
                stack.add(c);
            }else{
                stack.pop();
            }

        }


        StringBuffer stringBuffer = new StringBuffer();

        Stack<Character> stack2 = new Stack<>();

        int size = stack.size();

        for (int i = 0; i < size; i++) {
            stack2.push(stack.pop());
        }


        while(stack2.size()>0){

            stringBuffer.append(stack2.pop());
        }

        return stringBuffer.toString();

    }

    @Test
    public void test(){
        System.out.println(removeDuplicates("baabca"));
    }

}
