package 二叉树;

import java.util.*;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-22 19:51
 **/
public class _513找树左下角的值 {

    //考虑层序遍历到最后一行第一个元素
    public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int res = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (i == 0) {
                        res = poll.val;
                    }
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }
            return res;
    }

}
