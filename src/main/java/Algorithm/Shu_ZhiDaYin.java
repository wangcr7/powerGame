package Algorithm;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Shu_ZhiDaYin {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        int depth = 1;
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(pRoot);
        Stack<TreeNode> stack2 = new Stack<>();

        ArrayList<ArrayList<Integer> > result = new ArrayList<>();

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> list = new ArrayList();
            if (depth%2 != 0){
                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    if (node != null){
                        list.add(node.val);

                        if (node.left != null) {
                            stack2.push(node.left);
                        }
                        if (node.right != null) {
                            stack2.push(node.right);
                        }
                    }
                }
            } else {
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    if (node != null) {
                        list.add(node.val);
                        if (node.right != null) {
                            stack1.push(node.right);
                        }
                        if (node.left != null) {
                            stack1.push(node.left);
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

    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {

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

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
