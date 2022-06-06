package Integer;

import java.util.HashMap;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-06-02 15:53
 **/
public class _12整数转罗马数字 {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");

        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");

        StringBuilder sb = new StringBuilder();

        int[] roma = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        for (int i = roma.length - 1; i >=0 && num > 0; i--) {

            if (num >=  roma[i]){
                int j = num/roma[i];
                num = num%roma[i];

                for(;j>0;j--){
                    sb.append(map.get(roma[i]));
                }
            }
        }

        return sb.toString();
    }
}
