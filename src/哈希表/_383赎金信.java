package 哈希表;

import org.junit.Test;

import java.security.interfaces.DSAParams;
import java.util.HashMap;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-19 14:12
 **/
public class _383赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i),
                    map.getOrDefault(magazine.charAt(i),0)+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if(map.getOrDefault(ransomNote.charAt(i),0)<=0){
                return false;
            }else{
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
            }
        }

        return true;
    }

    @Test
    public void test(){
        System.out.println(canConstruct("aa","ab"));
    }
}
