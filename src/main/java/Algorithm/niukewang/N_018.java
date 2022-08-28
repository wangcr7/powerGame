package Algorithm.niukewang;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: CristianoRonaldo
 * @description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author: wang chi
 * @create: 2020-06-19 10:27
 */
public class N_018 {

    /**
     * 自己写的
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * 深搜替换
     * @param root
     */
    public void Mirror1(TreeNode root) {

        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            if (node.left != null || node.right != null){
                TreeNode treeNode = node.left;
                node.left = node.right;
                node.right = treeNode;
            }

            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
    }


    /**
     * 广搜遍历
     * @param root
     */
    public void LevelIterator(TreeNode root){
        if (root == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.pop();

            System.out.println(node.val);

            if (node.left != null){
                queue.push(node.left);
            }
            if (node.right != null){
                queue.push(node.right);
            }
        }


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
