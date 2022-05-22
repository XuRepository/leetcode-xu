package array.移除元素_双指针;

/**
 * @program: leetcode2022
 * @description:双指针法：一快一慢两个指针
 * @author: XuJY
 * @create: 2022-02-07 20:44
 **/
public class _26删除有序数组重复项 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        int res = 1;
        int slowIndex = 1;


        for(int fastIndex = 1;fastIndex<nums.length;fastIndex++){
            //判断当前快指针所指的元素是否大于慢指针所指向的前一个元素，
            // 如果大于，说明当前快指针元素是第一次出现，否则，当前快指针元素已经出现过啦
            //慢指针指向的元素应当是从头开始依次不重复的单个元素的末尾
            //快指针用于遍历
            if(nums[fastIndex]>nums[slowIndex-1]){
                res++;
                nums[slowIndex++]=nums[fastIndex];
            }

        }
        return res;
    }
}
