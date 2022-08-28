package algorithm.niukewang;


import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class N_60 {


    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        int depth = 1;
        Queue<TreeNode> queue1 = new LinkedBlockingQueue();
        queue1.offer(pRoot);
        Queue<TreeNode> queue2 = new LinkedBlockingQueue();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (!queue1.isEmpty() || !queue2.isEmpty()){
            ArrayList list = new ArrayList();
            if (depth%2 != 0){
                while (!queue1.isEmpty()){
                    TreeNode node = queue1.poll();
                    if (node != null){
                        list.add(node.val);
                        if (node.left != null){
                            queue2.offer(node.left);
                        }
                        if (node.right != null){
                            queue2.offer(node.right);
                        }
                    }
                }
            } else {
                while (!queue2.isEmpty()){
                    TreeNode node = queue2.poll();
                    if (node != null){
                        list.add(node.val);
                        if (node.left != null){
                            queue1.offer(node.left);
                        }
                        if (node.right != null){
                            queue1.offer(node.right);
                        }

                    }
                }

            }
            if (list.isEmpty()){
                continue;
            }
            result.add(list);
            depth++;
        }
        return result;
    }

    public static void main(String[] args) {


        Queue queue1 = new LinkedBlockingQueue();


        queue1.add(null);


        System.out.println(queue1.poll());
        System.out.println(queue1.poll());



    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
