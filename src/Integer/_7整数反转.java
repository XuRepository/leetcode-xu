package Integer;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-06-02 14:09
 **/
public class _7整数反转 {
    public int reverse(int x) {
        int ans = 0;
        while (x!=0){
            int digit = x %10;
            if (ans >Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && digit >7)){
                return 0;
            }
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10) && digit < -8){
                return 0;
            }
            ans = ans*10+digit;
            x/=10;
        }
        return ans;

    }

    public int reverse1(int x) {
        int flag = x>=0?1:-1;
        x = Math.abs(x);


        StringBuilder res = new StringBuilder(Integer.toString(x));
        res.reverse();
        int ans;
        try {
            ans = Integer.parseInt(res.toString());
        }catch (Exception e){
            ans = 0;
        }
        return ans*flag;
    }
}
