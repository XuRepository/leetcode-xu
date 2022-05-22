package 回溯;

import com.sun.deploy.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-06 20:16
 **/
public class _17电话号码的字母组合 {

    //数字和字母如何映射？HashMap or 2维数组
    private String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    private List<String> res = new ArrayList<String>();

    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return res;

        backTracing(digits,0);

        return res;


    }

    public void backTracing(String digits,int index){

        //出口
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - 48;

        for (int i = 0; i < letterMap[digit].length(); i++) {
            //第一次遍历的宽度是，第一个集合的宽度，也就是对应数字的对应字符串的长度
            sb.append(letterMap[digit].charAt(i));

            backTracing(digits,index+1);

            //恢复现场
            sb.deleteCharAt(sb.length()-1);

        }
    }
}
