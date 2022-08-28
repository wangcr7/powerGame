package algorithm.niukewang;

import java.util.Stack;

/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class N_58 {

    boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(pRoot.left);
        stack.add(pRoot.right);

        while (!stack.isEmpty()){

            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            stack.add(left.left);
            stack.add(right.right);
            stack.add(left.right);
            stack.add(right.left);
        }

        return true;
    }

    boolean isSymmetrical1(TreeNode pRoot){


        if (pRoot == null){
            return true;
        }

        return comRoot(pRoot.left, pRoot.right);


    }

    private boolean comRoot(TreeNode left, TreeNode right){

        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }

        return comRoot(left.left, right.right) && comRoot(left.right, right.left);


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
