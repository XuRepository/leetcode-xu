package 分治;

/**
 * @program: leetcode2022
 * @description: 分治 + 位运算
 * @author: XuJY
 * @create: 2022-06-06 14:18
 **/
public class _29两数相除 {
    public int divide(int dividend, int divisor) {
        //负数转为整数可能存在溢出现象，所以我们考虑把所有正数转为负数
        int ans = 0;

        int pos = 0;


        //一种可能溢出的情况：
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if (divisor > 0) {
            pos++;
            divisor = divisor * -1;
        }

        if (dividend > 0) {
            pos++;
            dividend = dividend * -1;
        }

        while (dividend <= divisor){
            int temp = divisor;
            int count = 1;//当前批次循环要加count个divisor才能达到最接近dividend
            while (dividend - temp <= temp){//防止溢出，实际上是2*temp <= dividend 这里是负数！
                //这里寻找的是2的k次方 * temo  也就是 temp倍增k次之后，不大于dividend！
                temp += temp;
                count += count;
            }
            dividend -= temp;//此时无法继续倍乘temp了  减掉已经计算的count数量，然后重新计算被除数
            ans += count;
        }

//        //找快速乘方法中的合适的z！
//        int left = 1;
//        int right = Integer.MAX_VALUE;
//
//        //寻找最大的ans  使得ans * divisor >= dividend
//        while (left <=right){
//            int mid = left + (right-left)>>1;
//            boolean b = quickAdd(divisor, mid, dividend);
//            if (b){
//                //mid * divisor >= dividend;那就需要找更大的ans
//                ans = mid;
//                if (mid == Integer.MAX_VALUE) break;
//                left = mid +1;
//            }else{
//                right = mid -1;
//            }
//        }

        if (pos % 2 == 0) return ans;
        else {
            return ans * -1;
        }
    }

    /**
     * x 和 y 是负数，z 是正数， 需要判断 z * y >= x 是否成立;实际上就是不断迭代把divisor扩大位两倍，找到最终的res！
     * @param y  divisor
     * @param z   Z / 2   --》  divisor << 2;
     * @param x  dividend
     * @return
     */
    public boolean quickAdd(int y,int z,int x){
        int res = 0;

        while (z>=0){
            if ((z & 1) == 1){
                res += y;

            }
            y = y << 1;//被除数 倍增
            z = z >> 1;
        }

        return res >= x;
    }
}
