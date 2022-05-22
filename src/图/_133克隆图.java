package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode2022
 * @description:
 * @author: XuJY
 * @create: 2022-03-14 20:23
 **/
public class _133克隆图 {
    HashMap<Node,Node> map= new HashMap<Node,Node>();
    public Node cloneGraph(Node node) {

        if (node == null) return node;

        if (map.containsKey(node)){
            return map.get(node);

        }

        Node cloneNode = new Node(node.val,new ArrayList<>());
        map.put(node,cloneNode);

        for(Node neiNode : node.neighbors){

            cloneNode.neighbors.add(cloneGraph(neiNode));

        }
        return cloneNode;

    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node BFS(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> visited = new HashMap();

        // 将题目给定的节点添加到队列
        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList()));

        while (!queue.isEmpty()){
            Node firstNode = queue.remove();
            for(Node neighbor : node.neighbors){

                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }

                // 更新当前节点的邻居列表
                visited.get(firstNode).neighbors.add(visited.get(neighbor));
            }


        }

        return visited.get(node);


    }

}
