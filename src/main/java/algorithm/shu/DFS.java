package algorithm.shu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-06-29 17:48
 */
public class DFS {

    /**
     * 前序遍历
     * @param node
     */
    public static void FirstOrder (Node node){
        if (node != null){
            System.out.print(node.data);
            FirstOrder(node.leftChild);
            FirstOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历
     */
    public void IOrder(Node node){
        if (node != null){
            IOrder(node.leftChild);
            System.out.println(node.data);
            IOrder(node.rightChild);
        }
    }

    /**
     * 后序遍历
     */
    public void lastOrder(Node node){
        if (node != null){
            lastOrder(node.leftChild);
            lastOrder(node.rightChild);
            System.out.println(node.data);
        }
    }

    public static List<Integer> dfs(Node root){
        if(root == null){
            return null;
        }
        ArrayList<Integer> array = new ArrayList<>();
        Stack<Node> stack=new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node t = stack.pop();
            array.add((int) t.data);
            if(t.rightChild!=null){
                stack.push(t.rightChild);
            }
            if(t.leftChild!=null){
                stack.push(t.leftChild);
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

    public static void main(String[] args) {
        long[] arr = new long[]{10,7,15,3,9,12,17,11};
        Node node = createTree(arr);
        FirstOrder(node);

        System.out.println();
        List<Integer> list = dfs(node);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
