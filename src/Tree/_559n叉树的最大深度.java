package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-02-21 15:24
 **/
public class _559n叉树的最大深度 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    //递归
    public int maxDepth(Node root) {

        if (root == null) return 0;

        List<Node> children = root.children;

        int depth = 0;

        for(Node node : children){
            int d = maxDepth(node);
            if(depth<d){
                depth = d;
            }
        }

        depth+=1;

        return depth;
    }



    //迭代
    public int maxDepth1(Node root) {

        if (root == null) return 0;

        int depth = 0;

        Deque<Node> deque = new LinkedList<Node>();

        deque.offer(root);

        while(!deque.isEmpty()){//每循环一次，层数+1

            int length = deque.size();//记录当前层的节点数量

            for (int i = 0; i < length; i++) {
                //当前层都出队伍，并且他们的孩子都进入队伍

                Node cur = deque.pop();

                List<Node> children = cur.children;

                for (Node node : children){
                    deque.offer(node);
                }

            }
            depth+=1;
        }

        return depth;
    }

}
