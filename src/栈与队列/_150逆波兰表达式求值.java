package 栈与队列;

import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-20 11:37
 **/
public class _150逆波兰表达式求值 {

    public int evalRPN1(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < tokens.length; ++i) {
            if ("+".equals(tokens[i])) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(tokens[i])) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(tokens[i])) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }


    public int evalRPN(String[] tokens) {

        if(tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }

        Integer res = 0;

        Deque<String> stack = new LinkedList<String>();

        HashSet<String> set = new HashSet<String>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String s : tokens){

            if(!set.contains(s)){
                stack.push(s);
            }else{
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());

                switch (s){
                    case "+":
                        res=a+b;
                        break;
                    case "-" :
                        res=b-a;
                        break;
                    case "*" :
                        res=a*b;
                        break;
                    case "/" :
                        res= b/a;
                        break;
                }

                stack.push(res.toString());
            }
        }

        return res;
    }

    @Test
    public void test(){
        String[] strings = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(strings)
        );
    }

}
