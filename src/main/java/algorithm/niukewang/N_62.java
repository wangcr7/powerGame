package algorithm.niukewang;


import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 */
public class N_62 {


    TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot == null || k == 0){
            return null;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()){
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.pop();
            count++;
            if (count == k){
                return pRoot;
            }
            pRoot = pRoot.right;
        }
        return null;
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
