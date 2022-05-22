package 字符串;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-16 19:53
 **/
public class 剑指Offer05替换空格 {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");
        for(String str : s1){
            sb.append(str).append("%20");
        }
        return sb.substring(0,sb.length()-3);

    }

}
