package algorithm.shu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-06-29 17:48
 */
public class BFS {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public static List<List<Node>> traversal(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Node>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private static void dfs(Node root, int level, List<List<Node>> list) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            List<Node> subList = new ArrayList<>();
            subList.add(root);
            list.add(subList);
        } else {
            list.get(level).add(root);
        }
        dfs(root.leftChild, level + 1, list);
        dfs(root.rightChild, level + 1, list);
    }

    /**
     * 队列解法
     * @param root
     * @return
     */
    public ArrayList<Integer> bfs(Node root) {
        if (root == null){
            return null;
        }
        ArrayList<Integer> array = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            Node treeNode = queue.poll();
            array.add((int) treeNode.data);
            if (treeNode.leftChild != null){
                queue.offer(treeNode.leftChild);
            }
            if (treeNode.rightChild != null){
                queue.offer(treeNode.rightChild);
            }
        }
        return array;
    }

    public static Node createTree(long [] arr){

        Node c,pa = null;
        Node root = new Node(arr[0]);
        root.leftChild = null;
        root.rightChild = null;

        for (int i = 1; i < arr.length; i++) {

            Node p = new Node(arr[i]);
            p.leftChild = null;
            p.rightChild = null;
            c = root;
            while (c != null){
                pa = c;
                if (c.data > p.data){
                    c = c.leftChild;
                } else {
                    c = c.rightChild;
                }
            }

            if (pa.data > p.data){
                pa.leftChild = p;
            } else {
                pa.rightChild = p;
            }
        }
        return root;
    }

    public static void FirstOrder (Node node){
        if (node != null){
            System.out.print(node.data);
            FirstOrder(node.leftChild);
            FirstOrder(node.rightChild);
        }
    }

    public static void main(String[] args) {
        long[] arr = new long[]{10,7,15,3,9,12,17,11};
        Node node = createTree(arr);
        FirstOrder(node);
        System.out.println();
        List<List<Node>> listList = traversal(node);
        for (List<Node> list: listList) {
            for (Node node1:list) {
                System.out.print(node1.data);
            }
        }
    }
}
