package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-07 21:05
 **/
public class _93复原IP地址 {

    ArrayList<String> res = new ArrayList<String>();
    ArrayList<String> path = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {

        backTracking(s,0);
        return res;

    }

    public void backTracking(String s,int startIndex){

        //剪枝
        if (path.size()>4){
            return;
        }
        //出口
        if (path.size() == 3){//遍历结束，3个数字,此时判断第四个数字是否是地址
            if (isIpAddress(s,startIndex,s.length()-1)){
                StringBuilder sb = new StringBuilder();
                for(String str : path){
                    sb.append(str).append(".");
                }
                sb.append(s.substring(startIndex));

                res.add(sb.toString());
            }
            return;
        }



        for (int i = startIndex; i < s.length(); i++) {

            if (isIpAddress(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));//substring，param1：起始地址；param2：终止地址后一位
            }else {
                continue;
            }

            backTracking(s,i+1);

            path.remove(path.size()-1);

        }

    }

    private boolean isIpAddress(String s, int startIndex, int i) {
        //判断是否大于三位。，大于三位直接杀掉
        if (i - startIndex >2) return false;

        String str = s.substring(startIndex,i+1);

        if (str == null ||str.length() == 0){
            return false;
        }

        int num = Integer.parseInt(str);

        if (num>0 && num<=255){
            if (str.charAt(0)=='0'){
                return false;
            }
            return true;
        }else if (num ==0 && str.length() == 1){
            return true;
        }

        return false;
    }


}
