package 字符串;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-16 20:13
 **/
public class _151颠倒字符串中的单词 {
    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        int right = s.length()-1;
        int left = s.length()-1;

        while (left >=0){
            if (s.charAt(left) == ' '){
                if (right == left){
                    right -- ;
                    left -- ;
                }else{
                    sb.append(s.substring(left+1,right)).append(" ");
                    left --;
                    right = left;
                }
                continue;
            }
            left --;
        }

        if (right != left){
            sb.append(s.substring(left+1,right+1));
        }else{
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();



    }
}
