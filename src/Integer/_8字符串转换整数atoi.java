package Integer;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-06-02 14:40
 **/
public class _8字符串转换整数atoi {
    public int myAtoi(String s) {
        int len = s.length();
        int flag = 1;
        boolean b = false;//判断是否已经开始添加符号or数字！
        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '-' && !b){
                flag = -1;
                b=true;
                continue;
            }

            if (s.charAt(i) == '+' && !b){
                b=true;
                continue;
            }

            if (!b && s.charAt(i)==' ') continue;
            if (s.charAt(i)>'9' ||s.charAt(i)<'0') return ans;


            int digit = s.charAt(i) - '0';
            b = true;
            System.out.println(digit);

            if (flag == 1){
                if (ans > Integer.MAX_VALUE/10 || ans ==Integer.MAX_VALUE/10 && digit > 7){
                    return Integer.MAX_VALUE;
                }
            }

            if (flag == -1){
                if (ans > Integer.MAX_VALUE/10 || ans ==Integer.MAX_VALUE/10 && digit > 8){
                    return Integer.MIN_VALUE;
                }
            }

            ans = ans * 10 + digit;
        }
        return ans*flag;
    }
}
