package 位运算;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-06-05 21:57
 **/
public class _50Pow {
    //快速幂，不能够简单地累积计算，会超时！
    //位运算-二分法
    //位运算-二分法：https://leetcode.cn/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
    public double myPow(double x, int n) {
        long N = n;//避免负数变正数的时候越界！
        if (N==0) return 1.0;

        if (N<0) N = -N;

        double x_contibute = 1.0;

        while(n>0){
            if ((N & 1) == 1){
                x_contibute *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return n > 0 ? x_contibute : 1.0/x_contibute;
    }




    //使用分治法！计算x的n/2递归计算即可！
    public double myPow1(double x, int n) {
        long N = n;//避免负数变正数的时候越界！
        if (N==0) return 1.0;
        return n > 0 ? quickMi(x, N) : 1.0/quickMi(x , Math.abs(N));
    }

    private double quickMi(double x, long n) {
        if(n==0) return 1.0;//出口

        double half = quickMi(x, n /2);

        if (n %2==1) return half * half * x;
        else return half * half;
    }


}
