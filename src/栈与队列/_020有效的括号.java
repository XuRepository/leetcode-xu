package 栈与队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-19 20:56
 **/
public class _020有效的括号 {

    public boolean isValid(String s) {

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }


        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }

            if(s.charAt(i) == ')'){

                if(stack.isEmpty() || stack.pop()!='('){
                    return false;
                }
            }else if(s.charAt(i) == ']'){

                if(stack.isEmpty() || stack.pop()!='['){
                    return false;
                }
            }else if(s.charAt(i) == '}'){

                if(stack.isEmpty() || stack.pop()!='{'){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
