package 哈希表;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-18 19:37
 **/
public class _242有效的字母异位词 {

    public boolean isAnagram(String s, String t) {

        int[] hash = new int[128];

        for (int i = 0; i <s.length() ; i++) {
            hash[s.charAt(i)]++;
        }

        for (int i = 0; i <t.length() ; i++) {
            hash[t.charAt(i)]--;
        }

        for (int i = 0; i < hash.length ; i++) {
            if(hash[i] != 0){
                return false;
            }
        }

        return true;

    }


}
