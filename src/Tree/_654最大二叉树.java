package Tree;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-02 19:27
 **/
public class _654最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return maxNode(nums,0,nums.length-1);
    }

    public TreeNode maxNode(int[] nums,int left,int right){
//        int length = right - left +1 ;

        if (left>right) return null;

        //1数组找最大值
        int max = Integer.MIN_VALUE;
        int max_index = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max){
                max = nums[i];
                max_index = i;
            }
        }

        TreeNode node = new TreeNode(max);

        if (right == left){//叶子节点
            return node;
        }

        //2切分数组
        int ll = left;
        int lr = max_index-1;

        int rl = max_index+1;
        int rr = right;

        node.left = maxNode(nums,ll,lr);
        node.right = maxNode(nums,rl,rr);

        return node;

    }

}
