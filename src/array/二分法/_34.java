package array.二分法;

/**
 * @program: leetcode2022
 * @description: 二分法找多个边界
 * @author: XuJY
 * @create: 2022-02-06 23:26
 **/
public class _34 {
    public int[] searchRange(int[] nums, int target) {
        //左侧边界值，左侧第一个target左边一个坐标
        int leftBoard = getLeftBoard(nums,target);

        //右侧边界值，右侧第一个target左边一个坐标
        int rightBoard = getRightBoard(nums,target);

        if(leftBoard==-2||rightBoard==-2){
            //target小于数组最小值or大于数组最大值
            return new int[]{-1,-1};
        }else if(rightBoard-leftBoard>1){
            //找到target
            return new int[]{leftBoard+1,rightBoard-1};
        }else{
            //target在数组范围内 但是数组中不存在，此时leftboard为小于target的第一个数字的下标志，
            // rightboard为大于target的第一个数字的坐标，他们之前相减应该为1
            return new int[]{-1,-1};
        }
    }

    //找左边界,最终找到的是左侧第一个target的左侧位置
    public int getLeftBoard(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int leftBoard =-2;

        while(left<=right){
            int middle = (left+right)/2;
            //如果所求的target在中点右侧，就left调整
            //否则，就是所求target在中点or中点的左侧，就往左逼近寻找左侧的第一个target所在位置
            if(nums[middle]>=target){
                right=middle-1;//最终找到的是左侧第一个target的左侧位置
                leftBoard = right;
            }else {
                left = middle+1;
            }
        }
        return leftBoard;
    }

    //找右侧边界
    public int getRightBoard(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int rightBoard =-2;

        while(left<=right){
            int middle = (left+right)/2;
            //如果所求的target在中点右侧，就left调整
            if(nums[middle]<=target){
                left = middle+1;
                rightBoard = left;

            }else {
                right=middle-1;
            }
        }
        return rightBoard;
    }
}
