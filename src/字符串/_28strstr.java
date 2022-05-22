package 字符串;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-16 20:43
 **/
public class _28strstr {

    //KMP
    public int strStr(String haystack, String needle) {

        if (needle.isEmpty())return 0;
        int m = haystack.length();
        int n = needle.length();

        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();//匹配串

        //构建needle数组n,代表了匹配串每一个位置的最大相同前后缀长度,i遍历next，j遍历匹配串
        int[] next = new int[n];
        for (int i = 1,j=0; i < n; i++) {

            while(j>0 && p[i]!=p[j]){
                j = next[j-1];
            }

            if (p[i] == p[j]) j++;

            next[i]=j;
        }

        //KMP
        for (int i = 0,j=0; i < m; i++) {

            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;

        }

        return -1;


    }

}
