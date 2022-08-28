package algorithm.niukewang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: CristianoRonaldo
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。 bfs
 * @author: wang chi
 * @create: 2020-06-28 16:39
 */
public class N_022 {

    /**
     * 广搜
     * @param root
     * @return
     */
    public ArrayList<Integer> bfs(TreeNode root) {
        if (root == null){
            return null;
        }
        ArrayList<Integer> array = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            array.add(treeNode.val);
            if (treeNode.left != null){
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null){
                queue.offer(treeNode.right);
            }
        }
        return array;
    }

    /**
     * 深搜
     * @param root
     * @return
     */
    public List<Integer> dfs(TreeNode root){
        if(root == null){
            return null;
        }
        ArrayList<Integer> array = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode t = stack.pop();
            array.add(t.val);
            if(t.right!=null){
                stack.push(t.right);
            }
            if(t.left!=null){
                stack.push(t.left);
            }
        }
        return array;
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
