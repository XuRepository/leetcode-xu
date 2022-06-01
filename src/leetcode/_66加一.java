package leetcode;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-31 23:47
 **/
public class _66加一 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        return plus(digits, length-1);

    }

    private int[] plus(int[] digits, int i) {
        if(digits[i] == 9){
            digits[i] = 0;
            if(i != 0){
                digits[i] = 0;
                plus(digits,i-1);
            }else{
                int[] newDigits = new int[digits.length+1];
                newDigits[0] = 1;
                for (int j = 1; j < newDigits.length; j++) {
                    newDigits[j] = digits[i];
                }
                return newDigits;
            }
        }else{
            digits[i] += 1;
        }
        return digits;
    }
}
