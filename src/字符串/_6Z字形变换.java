package 字符串;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-06-01 23:55
 **/
public class _6Z字形变换 {


        public String convert1(String s, int numRows) {
            if (numRows >= s.length() || numRows == 1) return s;

            //直接构造
            int t = 2*numRows -2;
            int colNum = numRows -1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                //i+j是当前遍历到的字符串的下标
                for (int j = 0; i+j < s.length(); j = j+t) {
                    //每行每周期的第一个元素
                    sb.append(s.charAt(i+j));

                    if (i >0 && i < numRows-1 && j+t-i<s.length()){
                        sb.append(s.charAt(j+t-i));
                    }
                }
            }
            return sb.toString();
        }




        public String convert(String s, int numRows) {
        //列数：
        int colNum = numRows -1;
        //一组的字母数量
        int charNum = numRows + numRows - 2;
        if(charNum == 0) return s;

        //完整的组数
        int group = s.length() / charNum;
        //剩余的字母数量
        int left = s.length() % charNum;

        //最后一组的列数：
        int lastColNum = 0;
        if (left > numRows){
            lastColNum = 1 + left%numRows;
        }else{
            lastColNum = 1;
        }
        //最终的列数
        int numCols = group * colNum + lastColNum;


        //开始按照规则向数组添加元素！
        char[][] z = new char[numRows][numCols];
        for (int i = 0; i < s.length(); i++) {
            int outerId = (i / charNum)*colNum ;
            int innerId = i % charNum;

            if (innerId >= numRows){
                outerId = 1 + outerId + innerId - numRows;

                innerId = numRows-1 -(innerId - numRows +1);


            }

            z[innerId][outerId] = s.charAt(i);

        }



        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[0].length; j++) {
                if (z[i][j]!=0) sb.append(z[i][j]);
            }
        }

        return sb.toString();
    }

}
