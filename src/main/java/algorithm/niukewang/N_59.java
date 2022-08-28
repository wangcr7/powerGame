package algorithm.niukewang;
import java.util.ArrayList;
import java.util.Stack;


/**
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印
 * ，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class N_59 {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

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

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
