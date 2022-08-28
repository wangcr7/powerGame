package algorithm.niukewang;

import java.util.ArrayList;

/**
 * @program: CristianoRonaldo
 * @description: 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author: wang chi
 * @create: 2020-06-29 11:42
 */
public class N_024_1 {

    ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null){
            return pathList;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && target == root.val){
            pathList.add(new ArrayList<Integer>(path));
        }
        if (root.val <= target && root.left != null){
            FindPath(root.left, target - root.val);
        }
        if (root.val <= target && root.right != null){
            FindPath(root.right, target - root.val);
        }

        path.remove(path.size() - 1);
        return pathList;
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
