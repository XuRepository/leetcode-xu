package 哈希表;

import org.junit.Test;

import java.util.HashSet;

/**
 * @program: leetcode2022
 * @description:
 * 题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！
 * @author: XuJY
 * @create: 2022-02-18 20:25
 **/
public class _202快乐数 {

    public boolean isHappy(int n) {

        int sum = n;

        HashSet<Integer> set = new HashSet<>();

        while(sum!=1){

            set.add(sum);

            int k = 0;
            while(sum!=0){
                k+=(sum%10)*(sum%10);
                System.out.println(k);
                sum = sum/10;
            }
            sum = k;

            if(set.contains(sum)){
                return false;
            }

        }

        return true;
    }

    @Test
    public void test(){
        System.out.println(isHappy(19));
    }

}
