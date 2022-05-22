package 回溯;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-07 20:19
 **/
public class _131分割回文串 {

    List<List<String>> res = new ArrayList<List<String>>();
    ArrayList<String> path = new ArrayList<String>();


    public List<List<String>> partition(String s) {

        backTracking(s,0);
        return res;

    }

    public void backTracking(String s,int startIndex){

        if (startIndex == s.length()){
            res.add(new ArrayList<String>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            //判断回文
            if (isPartition(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
            }else{
                continue;
            }

            backTracking(s,i+1);

            path.remove(path.size()-1);

        }
    }
    public boolean isPartition(String s,int left,int right){

        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }


}
