package Integer;

import java.util.HashMap;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-31 21:10
 **/
public class _13罗马数字转整数 {

    public int romanToInt1(String s) {
        int[] mapper = new int[26];
        mapper['I'-'A'] = 1;
        mapper['V'-'A'] = 5;
        mapper['X'-'A'] = 10;
        mapper['L'-'A'] = 50;
        mapper['C'-'A'] = 100;
        mapper['D'-'A'] = 500;
        mapper['M'-'A'] = 1000;



        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i<s.length()-1){
                if (mapper[s.charAt(i)-'A'] < mapper[s.charAt(i+1)-'A']){
                    res += mapper[s.charAt(i+1)-'A'] - mapper[s.charAt(i)-'A'];
                    i++;
                }else {
                    res += mapper[s.charAt(i)-'A'];
                }
            }else{
                res+=mapper[s.charAt(i)-'A'];
            }
        }

        return res;
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> mapper = new HashMap<>();
        mapper.put('I',1);
        mapper.put('V',5);
        mapper.put('X',10);
        mapper.put('L',50);
        mapper.put('C',100);
        mapper.put('D',500);
        mapper.put('M',1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i<s.length()-1){
                if (mapper.get(s.charAt(i)) < mapper.get(s.charAt(i+1))){
                    res += mapper.get(s.charAt(i+1)) - mapper.get(s.charAt(i));
                    i++;
                }else {
                    res += mapper.get(s.charAt(i));
                }
            }else{
                res+=mapper.get(s.charAt(i));
            }
        }

        return res;


    }

}
