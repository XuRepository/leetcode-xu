package 双指针;

/**
 * @program: leetcode2022
 * @description:数据字典、双指针、滑动窗口
 * @author: XuJY
 * @create: 2022-04-20 18:10
 **/
public class _03 {
    //双指针
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;

        int[] dic = new int[128];

        for (;right < s.length(); right++) {

            dic[s.charAt(right)]+=1;//右侧元素入窗口

            if (dic[s.charAt(right)]==1){

                if (res<right-left+1)
                    res = right-left+1;

            }else{
                while (dic[s.charAt(right)]>1){
                    dic[s.charAt(left)]-=1;
                    left++;
                }
            }

        }

        return res;

    }
}
