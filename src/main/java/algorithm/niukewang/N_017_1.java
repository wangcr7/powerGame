package algorithm.niukewang;

/**
 * @program: CristianoRonaldo
 * @description: 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * @author: wang chi
 * @create: 2020-06-18 18:01
 */
public class N_017_1 {

    /**
     * 输入两个二叉树，判断是否包含子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSubStructure(TreeNode root1, TreeNode root2) {
        return (root1 != null && root2 != null) && (recur(root1, root2) || isSubStructure(root1.left, root2) || isSubStructure(root1.right, root2));
    }
    boolean recur(TreeNode root1, TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null || root1.val != root2.val) return false;
        return recur(root1.left, root2.left) && recur(root1.right, root2.right);
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
