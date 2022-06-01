package leetcode;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-06-01 23:46
 **/
public class _68二进制求和 {
    public String addBinary(String a, String b) {
        //满2进1

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int flag = 0;
        while (i>=0 || j>=0){
            int first = i >= 0 ? a.charAt(i) - '0' : 0;
            int second = j >= 0 ? b.charAt(j) - '0' : 0;

            if (flag + first + second == 3){
                flag = 1;
                sb.append('1');
            }else if(flag + first + second == 2){
                flag = 1;
                sb.append('0');
            }else{
                sb.append(flag + first + second);
                flag = 0;
            }
            i--;
            j--;
        }
        if (flag == 1) sb.append(1);

        return sb.reverse().toString();

    }
}
