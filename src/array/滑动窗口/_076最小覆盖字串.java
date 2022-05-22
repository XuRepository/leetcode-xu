package array.滑动窗口;

import org.junit.Test;

/**
 * @program: leetcode2022
 * @description:滑动窗口+字典！
 * 判断子串是否被满足 可以设置一个字典！
 * @author: XuJY
 * @create: 2022-02-10 15:40
 **/
public class _076最小覆盖字串 {
    public String solution(String s,String t){
        if(s.length() == 0 || t.length() == 0 || s.length()<t.length()){
            return "";
        }

        //建立一个需求字典need，存放t中所需要的字符个数。字符视为ascii码
        int[] need = new int[128];

        //遍历t字符串，完善need,通过ascii码确定字符位置为need下标
        for (int i = 0; i < t.length(); i++) {

            need[t.charAt(i)]++;
        }

        int needCount = t.length();//记录需要字符的总数量！

        //滑动窗口开启！

        int l = s.length();

        int left = 0;
        int right = 0;
        int miniLength = s.length()+1;

        String res = "";

        while(right<l){

            char c = s.charAt(right);
            //s[right]进入need 更新need
            if(need[c]>0){//进队元素是需要的元素
                needCount--;
            }
            need[c]--;//进队元素  维护need

            if(needCount==0){//当前窗口不再需要字符，已经包含子串t

                while(left<right && need[s.charAt(left)]<0){//左侧出窗口的元素是多余的

                    need[s.charAt(left)]++;
                    left++;
                }
                //此时窗口内仍然包含t，并且左侧多余元素都i已经出去了，可以判断当前窗口长度
                if(miniLength>=right-left+1){
                    miniLength = right -left+1;
                    res = s.substring(left,right+1);
                }

                //到此时，这一论的最小窗口结束了，开始下一轮！
                //左侧第一个有用元素出窗口！
                need[s.charAt(left)]++;
                left++;
                needCount++;
            }
            right++;
        }
        if(miniLength==s.length()+1) return "";
        else return res;
    }


    public String minWindow(String s, String t) {

        int l = s.length();

        int left = 0;
        int right = 0;
        int miniLength = s.length()+1;

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        String res = "";


        while(right<l){

            //判断窗口内的字串是否满足条件？首先看窗口长度和ct对比 再看是否有字串
            while(right-left+1>=ct.length && haveString(left,right,cs,ct)){
                //如果窗口内包含字串t
                if(miniLength >= right-left+1 ){

                    miniLength = right-left+1;
                    res = s.substring(left, right+1);//更新结果

                    //sb.substring(2, 4);
                    //从索引号2开始到索引好4结束(并且不包含索引4截取在内，
                    // 也就是说实际截取的是2和3号字符)；
                }
                left++;
            }
            right++;
        }

        if(miniLength==s.length()+1) return "";
        else return res;

    }

    private boolean haveString(int left, int right, char[] cs, char[] ct) {


        int t = 0;//ct当前字母是否存在在cs中的标记
        int[] flag = new int[right-left+1];//标记当前cs数组的某下标的数字是否被使用！


        for (int i = 0; i < ct.length; i++) {



            for(int j=left;j<=right;j++){

                if(ct[i] == cs[j] && flag[j-left]==0){
                    t++;//ct每通过一个字符 t++
                    flag[j-left]=1;
                    break;
                }
            }

        }
        if(t!=ct.length) return false;//如果ct[i]bu存在于cs中
        else return true;
    }

    @Test
    public void test(){
        String s = "acbbaca";
        String t = "aba";
        System.out.println(minWindow(s,t));
        //"ADOBECODEBANC"
        //"ABC"
        //"acbbaca"
        //"aba"
    }

}
