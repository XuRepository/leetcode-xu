package array.矩阵循环;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-10 20:32
 **/
public class _59螺旋矩阵 {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];


        int loop = n / 2;//循环的轮数  n=1循环0轮，n=2循环一轮，n=3循环1轮，n=4循环2轮。。。。。

        //每轮循环的起始点的坐标，每循环一轮，该点往右下走一位，即X++  Y++
        int startX = 0;
        int startY = 0;

        int offset =1;//偏移量，每轮循环的遍历长度是startX ~~~ n - offset  这一段。
        //因此   每一轮startX+1   offset+2才行，因为n-offset得到右侧边界。

        int count =1;//用于给矩阵赋值

        while (loop > 0) {

            int i = startX;
            int j = startY;

            //横着向右
            for(;j<startY+n-offset;j++){
                matrix[i][j]=count++;
            }

            //竖着向下
            for(;i<startX+n-offset;i++){
                matrix[i][j]=count++;
            }

            //横着向左
            for(;j>startY;j--){
                matrix[i][j]=count++;
            }

            //竖着向上
            for(;i>startX;i--){
                matrix[i][j]=count++;
            }

            startX ++;
            startY ++;

            offset +=2;

            loop--;
        }

        //如果n是奇数，那么最后一轮是一个点，即最中间的点！此时的loop已经为0。但是中间点还未填充！
        if(n%2==1){
            matrix[n/2][n/2]=count;
        }


        return matrix;
    }

    @Test
    public void test() {
        System.out.println(1 / 2);
    }
}
