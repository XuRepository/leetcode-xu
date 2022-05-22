package 哈希表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-20 14:04
 **/
public class _49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {



        HashMap<String, List<String>> map = new HashMap<>();


        for (String str : strs) {
            int[] dic = new int[26];

            for (int j = 0; j < str.length(); j++) {
                dic[str.charAt(j)-'a']++;
            }

            //把计数器转化为String作为Key，V是相等KEY的集合！
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < dic.length; j++) {
                if (dic[j]!=0){
                    sb.append('a'+j);
                    sb.append(dic[j]);

                }
            }
            String key = sb.toString();
//            System.out.println(key);

            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());

    }

    @Test
    public void test(){
        groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
    }

}
