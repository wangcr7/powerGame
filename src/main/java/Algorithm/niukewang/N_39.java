package Algorithm.niukewang;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class N_39 {

    public boolean ret = true;

    public boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }


    public boolean isBalanced1(TreeNode root){

        height1(root);
        return ret;
    }


    public int height1(TreeNode root){

        if (ret == false) {
            return 0;
        }
        if (root == null){
            return 0;
        }
        int l = height1(root.left);
        int r = height1(root.right);
        if (Math.abs(l - r) > 1){
            ret = false;
        }
        return Math.max(l , r) + 1;
    }

    class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
