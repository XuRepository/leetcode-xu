package leetcode;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-20 13:26
 **/
public class _48旋转图像 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int startIndex = 0;
        int[] temp = new int[length];
        while (startIndex<length/2){
            int maxLength = length - startIndex*2 -1;
            int endIndex = length-1-startIndex;
            if (maxLength<=0) break;

            //记录第一波被替代的几个值
            for (int i = startIndex; i < endIndex; i++) {
                temp[i] = matrix[startIndex][i];
            }

//            int step =maxLength;
//            for (int i = startIndex; i < endIndex; i++) {
//                matrix[startIndex][i] = matrix[startIndex+step][startIndex];
//                step--;
//            }
            for (int i = 0; i < maxLength; i++) {
                matrix[startIndex][startIndex+i] = matrix[endIndex-i][startIndex];
            }

            for (int i = 0; i < maxLength ; i++) {
                matrix[endIndex-i][startIndex] = matrix[endIndex][endIndex-i];

            }

            for (int i = 0; i < maxLength; i++) {
                matrix[endIndex][endIndex-i] = matrix[startIndex+i][endIndex];
            }

            for (int i = 0; i < maxLength; i++) {
                matrix[startIndex+i][endIndex] = temp[startIndex+i];
            }

            startIndex++;

        }
    }
}
