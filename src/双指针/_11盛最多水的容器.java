package 双指针;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-05-17 13:19
 **/
public class _11盛最多水的容器 {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int max = (right-left)*Math.min(height[left],height[right]);

        while(left<right){

            if(height[left]>height[right]){
                int rightFlag = height[right];
                //小的一侧向中央搜索更大的高度！
                while(left<right && height[--right]<rightFlag){
                }
            }else{
                int leftFlag = height[left];
                //小的一侧向中央搜索更大的高度！
                while(left<right && height[++left]<leftFlag){
                }
            }
            max = Math.max(max,(right-left)*Math.min(height[left],
                    height[right]));
        }
        return max;
    }
}
